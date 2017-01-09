package fi.riista.feature.huntingclub.moosedatacard.validation;

import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.effectiveHuntingAreaLargerThanTotalHuntingArea;
import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.huntingAreaNotGivenAtAll;
import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.moosesRemainingInEffectiveHuntingAreaGivenButAreaMissing;
import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.moosesRemainingInEffectiveHuntingAreaGreaterThanMoosesRemainingInTotalHuntingArea;
import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.moosesRemainingInTotalHuntingAreaGivenButAreaMissing;
import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.moosesRemainingNotGivenAtAll;
import static fi.riista.feature.huntingclub.moosedatacard.exception.MooseDataCardImportFailureReasons.totalHuntingAreaMissingAndEffectiveHuntingAreaGivenAsPercentageShare;
import static javaslang.control.Validation.invalid;
import static javaslang.control.Validation.valid;

import fi.riista.integration.luke_import.model.v1_0.MooseDataCardSection_8_1;
import fi.riista.util.F;

import javaslang.control.Validation;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MooseDataCardSection81Validator {

    public static Validation<List<String>, MooseDataCardSection_8_1> validate(
            @Nonnull final MooseDataCardSection_8_1 section) {

        Objects.requireNonNull(section);

        final Validation<? extends Iterable<String>, MooseDataCardSection_8_1> rangeValidation =
                MooseDataCardSummaryField.TOTAL_HUNTING_AREA.validate(section)
                        .combine(MooseDataCardSummaryField.EFFECTIVE_HUNTING_AREA.validate(section))
                        .combine(MooseDataCardSummaryField.EFFECTIVE_HUNTING_AREA_PERCENTAGE.validate(section))
                        .combine(MooseDataCardSummaryField.MOOSES_REMAINING_IN_TOTAL_HUNTING_AREA.validate(section))
                        .combine(MooseDataCardSummaryField.MOOSES_REMAINING_IN_EFFECTIVE_HUNTING_AREA.validate(section))
                        .ap((_1, _2, _3, _4, _5) -> section);

        return F.combine(rangeValidation, validateCombinatorialPresence(section)).map(list -> section);
    }

    private static Validation<List<String>, MooseDataCardSection_8_1> validateCombinatorialPresence(
            final MooseDataCardSection_8_1 section) {

        final List<String> validationErrors = new ArrayList<>();

        final Optional<Double> totalHuntingArea = Optional.ofNullable(section.getTotalHuntingArea());
        final Optional<Double> effectiveHuntingAreaHectares = Optional.ofNullable(section.getEffectiveHuntingArea());
        final boolean effectiveHuntingAreaGiven =
                effectiveHuntingAreaHectares.isPresent() || section.getEffectiveHuntingAreaPercentage() != null;

        final Optional<Integer> moosesRemainingInTotalHuntingArea =
                Optional.ofNullable(section.getMoosesRemainingInTotalHuntingArea());
        final Optional<Integer> moosesRemainingInEffectiveHuntingArea =
                Optional.ofNullable(section.getMoosesRemainingInEffectiveHuntingArea());
        final boolean moosesRemainingNotGivenAtAll =
                !moosesRemainingInTotalHuntingArea.isPresent() && !moosesRemainingInEffectiveHuntingArea.isPresent();

        if (totalHuntingArea.isPresent()) {

            totalHuntingArea.filter(area -> area >= 0.0)
                    .flatMap(total -> effectiveHuntingAreaHectares
                            .filter(effective -> effective > total)
                            .map(effective -> effectiveHuntingAreaLargerThanTotalHuntingArea(effective, total)))
                    .ifPresent(validationErrors::add);

        } else if (effectiveHuntingAreaGiven) {

            if (!effectiveHuntingAreaHectares.isPresent()) {
                validationErrors.add(totalHuntingAreaMissingAndEffectiveHuntingAreaGivenAsPercentageShare());
            }

        } else {
            validationErrors.add(huntingAreaNotGivenAtAll());
        }

        if (moosesRemainingNotGivenAtAll) {
            validationErrors.add(moosesRemainingNotGivenAtAll());
        } else {
            if (moosesRemainingInTotalHuntingArea.isPresent() && !totalHuntingArea.isPresent()) {
                validationErrors.add(moosesRemainingInTotalHuntingAreaGivenButAreaMissing());
            }
            if (moosesRemainingInEffectiveHuntingArea.isPresent() && !effectiveHuntingAreaGiven) {
                validationErrors.add(moosesRemainingInEffectiveHuntingAreaGivenButAreaMissing());
            }

            moosesRemainingInTotalHuntingArea
                    .filter(total -> total >= 0)
                    .flatMap(total -> moosesRemainingInEffectiveHuntingArea
                            .filter(effective -> effective > total)
                            .map(effective -> moosesRemainingInEffectiveHuntingAreaGreaterThanMoosesRemainingInTotalHuntingArea(
                                    effective, total)))
                    .ifPresent(validationErrors::add);
        }

        return validationErrors.isEmpty() ? valid(section) : invalid(validationErrors);
    }

}
