package fi.riista.feature.gamediary.mobile;

import fi.riista.feature.gamediary.image.GameDiaryImage;
import fi.riista.feature.gamediary.srva.SrvaEventSpecVersion;
import fi.riista.feature.gamediary.srva.SrvaEvent;
import fi.riista.feature.gamediary.srva.SrvaEventStateEnum;
import fi.riista.feature.gamediary.srva.method.SrvaMethod;
import fi.riista.feature.gamediary.srva.specimen.SrvaSpecimen;
import fi.riista.feature.gamediary.srva.AbstractSrvaEventDTOTransformerTest;
import fi.riista.util.F;
import fi.riista.util.Functions;
import fi.riista.util.jpa.HibernateStatisticsAssertions;
import javaslang.Tuple2;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static fi.riista.util.TestUtils.createList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MobileSrvaEventDTOTransformerTest extends AbstractSrvaEventDTOTransformerTest {

    @Resource
    private MobileSrvaEventDTOTransformer mobileSrvaEventDTOTransformer;

    @Test
    @HibernateStatisticsAssertions(maxQueries = 6)
    public void testWithSpecimens() {
        SrvaEventSpecVersion specVersion = SrvaEventSpecVersion._1;

        withPerson(person -> {
            final List<Tuple2<SrvaEvent, List<SrvaSpecimen>>> pairs =
                    createList(5, () -> newSrvaEventWithSpecimens(10, person));

            // Generate extra srva event that is not included in input and thus should not affect output either.
            newSrvaEventWithSpecimens(5, person);

            onSavedAndAuthenticated(createUser(person), () -> {
                final List<MobileSrvaEventDTO> dtos = mobileSrvaEventDTOTransformer.apply(F.nonNullKeys(pairs), specVersion);

                assertNotNull(dtos);
                assertEquals(pairs.size(), dtos.size());

                for (int i = 0; i < pairs.size(); i++) {
                    final SrvaEvent srvaEvent = pairs.get(i)._1();
                    final MobileSrvaEventDTO dto = dtos.get(i);

                    assertNotNull(dto);
                    assertTrue(dto.getImageIds().isEmpty());
                    assertCanEdit(dto);
                    assertCommonFields(srvaEvent, dto);
                    assertSpecimens(dto.getSpecimens(), pairs.get(i)._2());
                    assertEquals(specVersion, dto.getSrvaEventSpecVersion());
                }
            });
        });
    }

    @Test
    @HibernateStatisticsAssertions(maxQueries = 6)
    public void testWithMethods() {
        SrvaEventSpecVersion specVersion = SrvaEventSpecVersion._1;

        withPerson(person -> {
            final List<Tuple2<SrvaEvent, List<SrvaMethod>>> pairs =
                    createList(5, () -> newSrvaEventWithMethods(3, person));

            // Generate extra srva event that is not included in input and thus should not affect output either.
            newSrvaEventWithMethods(5, person);

            onSavedAndAuthenticated(createUser(person), () -> {
                final List<MobileSrvaEventDTO> dtos = mobileSrvaEventDTOTransformer.apply(F.nonNullKeys(pairs), specVersion);

                assertNotNull(dtos);
                assertEquals(pairs.size(), dtos.size());

                for (int i = 0; i < pairs.size(); i++) {
                    final SrvaEvent srvaEvent = pairs.get(i)._1();
                    final MobileSrvaEventDTO dto = dtos.get(i);

                    assertNotNull(dto);
                    assertTrue(dto.getImageIds().isEmpty());
                    assertCanEdit(dto);
                    assertCommonFields(srvaEvent, dto);
                    assertMethods(dto.getMethods(), pairs.get(i)._2());
                    assertEquals(specVersion, dto.getSrvaEventSpecVersion());
                }
            });
        });
    }

    @Test
    @HibernateStatisticsAssertions(maxQueries = 6)
    public void testWithImages() {
        SrvaEventSpecVersion specVersion = SrvaEventSpecVersion._1;

        withPerson(person -> {
            final List<Tuple2<SrvaEvent, List<GameDiaryImage>>> pairs =
                    createList(5, () -> newSrvaEventWithImages(5, person));

            // Generate extra srva event that are not included in input and thus should not affect output either.
            newSrvaEventWithImages(5, person);

            onSavedAndAuthenticated(createUser(person), () -> {
                final List<MobileSrvaEventDTO> dtos = mobileSrvaEventDTOTransformer.apply(F.nonNullKeys(pairs), specVersion);

                assertNotNull(dtos);
                assertEquals(pairs.size(), dtos.size());

                for (int i = 0; i < pairs.size(); i++) {
                    final MobileSrvaEventDTO dto = dtos.get(i);

                    assertNotNull(dto);
                    assertCommonFields(pairs.get(i)._1, dto);

                    final Set<UUID> uuids =
                            F.mapNonNullsToSet(pairs.get(i)._2, Functions.idOf(GameDiaryImage::getFileMetadata));

                    assertEquals(uuids, new HashSet<>(dto.getImageIds()));
                    assertCanEdit(dto);
                    assertEquals(specVersion, dto.getSrvaEventSpecVersion());
                }
            });
        });
    }

    @Test
    public void testOtherSpecies() {
        withPerson(person -> {
            final SrvaEvent srvaEvent = newSrvaEvent();
            srvaEvent.setSpecies(null);
            srvaEvent.setOtherSpeciesDescription("otherspecies");

            final List<SrvaEvent> events = Arrays.asList(newSrvaEvent(), srvaEvent);

            onSavedAndAuthenticated(createUser(person), () -> {
                final List<MobileSrvaEventDTO> dtos = mobileSrvaEventDTOTransformer.apply(events, SrvaEventSpecVersion._1);
                assertEquals(2, dtos.size());
                assertEquals(1, dtos.stream().filter(mobileSrvaEventDTO ->
                        mobileSrvaEventDTO.getGameSpeciesCode() == null).count());
            });
        });
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testApplyList_noSpecVersion() {
        mobileSrvaEventDTOTransformer.apply(Collections.emptyList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testApply_noSpecVersion() {
        mobileSrvaEventDTOTransformer.apply(new SrvaEvent());
    }

    @Test
    public void testApply_emptyList() {
        assertNotNull(mobileSrvaEventDTOTransformer.apply(Collections.emptyList(), SrvaEventSpecVersion._1));
    }

    private static void assertCanEdit(MobileSrvaEventDTO dto) {
        assertEquals(dto.getState() != SrvaEventStateEnum.APPROVED, dto.isCanEdit());
    }
}