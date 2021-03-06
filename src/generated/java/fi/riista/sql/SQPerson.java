package fi.riista.sql;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;

import com.querydsl.sql.spatial.RelationalPathSpatial;


/**
 * SQPerson is a Querydsl query type for SQPerson
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class SQPerson extends RelationalPathSpatial<SQPerson> {

    private static final long serialVersionUID = 86833128;

    public static final SQPerson person = new SQPerson("person");

    public final StringPath byName = createString("byName");

    public final NumberPath<Integer> consistencyVersion = createNumber("consistencyVersion", Integer.class);

    public final NumberPath<Long> createdByUserId = createNumber("createdByUserId", Long.class);

    public final DateTimePath<java.sql.Timestamp> creationTime = createDateTime("creationTime", java.sql.Timestamp.class);

    public final NumberPath<Long> deletedByUserId = createNumber("deletedByUserId", Long.class);

    public final StringPath deletionCode = createString("deletionCode");

    public final DateTimePath<java.sql.Timestamp> deletionTime = createDateTime("deletionTime", java.sql.Timestamp.class);

    public final BooleanPath denyMagazine = createBoolean("denyMagazine");

    public final BooleanPath denyPost = createBoolean("denyPost");

    public final BooleanPath denyTransmit = createBoolean("denyTransmit");

    public final StringPath email = createString("email");

    public final BooleanPath enableSrva = createBoolean("enableSrva");

    public final StringPath firstName = createString("firstName");

    public final StringPath homeMunicipality = createString("homeMunicipality");

    public final StringPath homeMunicipalityCode = createString("homeMunicipalityCode");

    public final DatePath<java.sql.Date> hunterExamDate = createDate("hunterExamDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> hunterExamExpirationDate = createDate("hunterExamExpirationDate", java.sql.Date.class);

    public final StringPath hunterNumber = createString("hunterNumber");

    public final DatePath<java.sql.Date> huntingBanEnd = createDate("huntingBanEnd", java.sql.Date.class);

    public final DatePath<java.sql.Date> huntingBanStart = createDate("huntingBanStart", java.sql.Date.class);

    public final DatePath<java.sql.Date> huntingCardEnd = createDate("huntingCardEnd", java.sql.Date.class);

    public final DatePath<java.sql.Date> huntingCardStart = createDate("huntingCardStart", java.sql.Date.class);

    public final DatePath<java.sql.Date> huntingPaymentOneDay = createDate("huntingPaymentOneDay", java.sql.Date.class);

    public final NumberPath<Integer> huntingPaymentOneYear = createNumber("huntingPaymentOneYear", Integer.class);

    public final DatePath<java.sql.Date> huntingPaymentTwoDay = createDate("huntingPaymentTwoDay", java.sql.Date.class);

    public final NumberPath<Integer> huntingPaymentTwoYear = createNumber("huntingPaymentTwoYear", Integer.class);

    public final StringPath invoiceReferenceCurrent = createString("invoiceReferenceCurrent");

    public final NumberPath<Integer> invoiceReferenceCurrentYear = createNumber("invoiceReferenceCurrentYear", Integer.class);

    public final StringPath invoiceReferencePrevious = createString("invoiceReferencePrevious");

    public final NumberPath<Integer> invoiceReferencePreviousYear = createNumber("invoiceReferencePreviousYear", Integer.class);

    public final BooleanPath isFinnishCitizen = createBoolean("isFinnishCitizen");

    public final StringPath languageCode = createString("languageCode");

    public final StringPath lastName = createString("lastName");

    public final StringPath lhPersonId = createString("lhPersonId");

    public final StringPath magazineLanguageCode = createString("magazineLanguageCode");

    public final DateTimePath<java.sql.Timestamp> modificationTime = createDateTime("modificationTime", java.sql.Timestamp.class);

    public final NumberPath<Long> modifiedByUserId = createNumber("modifiedByUserId", Long.class);

    public final NumberPath<Long> mrAddressId = createNumber("mrAddressId", Long.class);

    public final DateTimePath<java.sql.Timestamp> mrSyncTime = createDateTime("mrSyncTime", java.sql.Timestamp.class);

    public final NumberPath<Long> otherAddressId = createNumber("otherAddressId", Long.class);

    public final NumberPath<Long> personId = createNumber("personId", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Long> rhyMembershipId = createNumber("rhyMembershipId", Long.class);

    public final StringPath ssn = createString("ssn");

    public final com.querydsl.sql.PrimaryKey<SQPerson> personPkey = createPrimaryKey(personId);

    public final com.querydsl.sql.ForeignKey<SQAddress> personMrAddressFk = createForeignKey(mrAddressId, "address_id");

    public final com.querydsl.sql.ForeignKey<SQAddress> personOtherAddressFk = createForeignKey(otherAddressId, "address_id");

    public final com.querydsl.sql.ForeignKey<SQOrganisation> rhyMembershipFk = createForeignKey(rhyMembershipId, "organisation_id");

    public final com.querydsl.sql.ForeignKey<SQSrvaEvent> _srvaEventAuthorFk = createInvForeignKey(personId, "author_id");

    public final com.querydsl.sql.ForeignKey<SQHarvestReport> _harvestReportAuthorFk = createInvForeignKey(personId, "author_id");

    public final com.querydsl.sql.ForeignKey<SQObservation> _gameObservationAuthorFk = createInvForeignKey(personId, "author_id");

    public final com.querydsl.sql.ForeignKey<SQJhtTraining> _jhtTrainingPersonIdFk = createInvForeignKey(personId, "person_id");

    public final com.querydsl.sql.ForeignKey<SQHarvest> _harvestActualShooterFk = createInvForeignKey(personId, "actual_shooter_id");

    public final com.querydsl.sql.ForeignKey<SQObservation> _gameObservationApproverToHuntingDayPersonIdFk = createInvForeignKey(personId, "approver_to_hunting_day_id");

    public final com.querydsl.sql.ForeignKey<SQHarvest> _harvestAuthorFk = createInvForeignKey(personId, "author_id");

    public final com.querydsl.sql.ForeignKey<SQOccupation> _occupationPersonFk = createInvForeignKey(personId, "person_id");

    public final com.querydsl.sql.ForeignKey<SQHarvestPermitContactPerson> _harvestPermitContactPersonPersonFk = createInvForeignKey(personId, "contact_person_id");

    public final com.querydsl.sql.ForeignKey<SQHarvest> _harvestApproverToHuntingDayPersonIdFk = createInvForeignKey(personId, "approver_to_hunting_day_id");

    public final com.querydsl.sql.ForeignKey<SQHuntingClubMemberInvitation> _huntingClubMemberInvitationPersonFk = createInvForeignKey(personId, "person_id");

    public final com.querydsl.sql.ForeignKey<SQObservation> _gameObservationObserverFk = createInvForeignKey(personId, "observer_id");

    public final com.querydsl.sql.ForeignKey<SQOccupationNomination> _occupationNominationPersonIdFk = createInvForeignKey(personId, "person_id");

    public final com.querydsl.sql.ForeignKey<SQSrvaEvent> _srvaEventApproverAsPersonFk = createInvForeignKey(personId, "approver_as_person_id");

    public final com.querydsl.sql.ForeignKey<SQSystemUser> _systemUserPersonFk = createInvForeignKey(personId, "person_id");

    public final com.querydsl.sql.ForeignKey<SQOccupationNomination> _occupationNominationRhyPersonIdFk = createInvForeignKey(personId, "rhy_person_id");

    public final com.querydsl.sql.ForeignKey<SQHarvestPermit> _harvestPermitOwnerFk = createInvForeignKey(personId, "original_contact_person_id");

    public SQPerson(String variable) {
        super(SQPerson.class, forVariable(variable), "public", "person");
        addMetadata();
    }

    public SQPerson(String variable, String schema, String table) {
        super(SQPerson.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public SQPerson(Path<? extends SQPerson> path) {
        super(path.getType(), path.getMetadata(), "public", "person");
        addMetadata();
    }

    public SQPerson(PathMetadata metadata) {
        super(SQPerson.class, metadata, "public", "person");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(byName, ColumnMetadata.named("by_name").withIndex(12).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(consistencyVersion, ColumnMetadata.named("consistency_version").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(createdByUserId, ColumnMetadata.named("created_by_user_id").withIndex(3).ofType(Types.BIGINT).withSize(19));
        addMetadata(creationTime, ColumnMetadata.named("creation_time").withIndex(6).ofType(Types.TIMESTAMP).withSize(35).withDigits(6).notNull());
        addMetadata(deletedByUserId, ColumnMetadata.named("deleted_by_user_id").withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(deletionCode, ColumnMetadata.named("deletion_code").withIndex(35).ofType(Types.CHAR).withSize(1));
        addMetadata(deletionTime, ColumnMetadata.named("deletion_time").withIndex(8).ofType(Types.TIMESTAMP).withSize(35).withDigits(6));
        addMetadata(denyMagazine, ColumnMetadata.named("deny_magazine").withIndex(33).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(denyPost, ColumnMetadata.named("deny_post").withIndex(32).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(denyTransmit, ColumnMetadata.named("deny_transmit").withIndex(31).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(email, ColumnMetadata.named("email").withIndex(14).ofType(Types.VARCHAR).withSize(255));
        addMetadata(enableSrva, ColumnMetadata.named("enable_srva").withIndex(40).ofType(Types.BIT).withSize(1));
        addMetadata(firstName, ColumnMetadata.named("first_name").withIndex(10).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(homeMunicipality, ColumnMetadata.named("home_municipality").withIndex(16).ofType(Types.VARCHAR).withSize(255));
        addMetadata(homeMunicipalityCode, ColumnMetadata.named("home_municipality_code").withIndex(34).ofType(Types.CHAR).withSize(3));
        addMetadata(hunterExamDate, ColumnMetadata.named("hunter_exam_date").withIndex(26).ofType(Types.DATE).withSize(13));
        addMetadata(hunterExamExpirationDate, ColumnMetadata.named("hunter_exam_expiration_date").withIndex(27).ofType(Types.DATE).withSize(13));
        addMetadata(hunterNumber, ColumnMetadata.named("hunter_number").withIndex(21).ofType(Types.VARCHAR).withSize(8));
        addMetadata(huntingBanEnd, ColumnMetadata.named("hunting_ban_end").withIndex(29).ofType(Types.DATE).withSize(13));
        addMetadata(huntingBanStart, ColumnMetadata.named("hunting_ban_start").withIndex(28).ofType(Types.DATE).withSize(13));
        addMetadata(huntingCardEnd, ColumnMetadata.named("hunting_card_end").withIndex(25).ofType(Types.DATE).withSize(13));
        addMetadata(huntingCardStart, ColumnMetadata.named("hunting_card_start").withIndex(24).ofType(Types.DATE).withSize(13));
        addMetadata(huntingPaymentOneDay, ColumnMetadata.named("hunting_payment_one_day").withIndex(36).ofType(Types.DATE).withSize(13));
        addMetadata(huntingPaymentOneYear, ColumnMetadata.named("hunting_payment_one_year").withIndex(37).ofType(Types.INTEGER).withSize(10));
        addMetadata(huntingPaymentTwoDay, ColumnMetadata.named("hunting_payment_two_day").withIndex(38).ofType(Types.DATE).withSize(13));
        addMetadata(huntingPaymentTwoYear, ColumnMetadata.named("hunting_payment_two_year").withIndex(39).ofType(Types.INTEGER).withSize(10));
        addMetadata(invoiceReferenceCurrent, ColumnMetadata.named("invoice_reference_current").withIndex(41).ofType(Types.VARCHAR).withSize(255));
        addMetadata(invoiceReferenceCurrentYear, ColumnMetadata.named("invoice_reference_current_year").withIndex(43).ofType(Types.INTEGER).withSize(10));
        addMetadata(invoiceReferencePrevious, ColumnMetadata.named("invoice_reference_previous").withIndex(42).ofType(Types.VARCHAR).withSize(255));
        addMetadata(invoiceReferencePreviousYear, ColumnMetadata.named("invoice_reference_previous_year").withIndex(44).ofType(Types.INTEGER).withSize(10));
        addMetadata(isFinnishCitizen, ColumnMetadata.named("is_finnish_citizen").withIndex(17).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(languageCode, ColumnMetadata.named("language_code").withIndex(13).ofType(Types.CHAR).withSize(2));
        addMetadata(lastName, ColumnMetadata.named("last_name").withIndex(11).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(lhPersonId, ColumnMetadata.named("lh_person_id").withIndex(18).ofType(Types.VARCHAR).withSize(255));
        addMetadata(magazineLanguageCode, ColumnMetadata.named("magazine_language_code").withIndex(30).ofType(Types.CHAR).withSize(2));
        addMetadata(modificationTime, ColumnMetadata.named("modification_time").withIndex(7).ofType(Types.TIMESTAMP).withSize(35).withDigits(6).notNull());
        addMetadata(modifiedByUserId, ColumnMetadata.named("modified_by_user_id").withIndex(5).ofType(Types.BIGINT).withSize(19));
        addMetadata(mrAddressId, ColumnMetadata.named("mr_address_id").withIndex(22).ofType(Types.BIGINT).withSize(19));
        addMetadata(mrSyncTime, ColumnMetadata.named("mr_sync_time").withIndex(23).ofType(Types.TIMESTAMP).withSize(35).withDigits(6));
        addMetadata(otherAddressId, ColumnMetadata.named("other_address_id").withIndex(19).ofType(Types.BIGINT).withSize(19));
        addMetadata(personId, ColumnMetadata.named("person_id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(phoneNumber, ColumnMetadata.named("phone_number").withIndex(15).ofType(Types.VARCHAR).withSize(255));
        addMetadata(rhyMembershipId, ColumnMetadata.named("rhy_membership_id").withIndex(20).ofType(Types.BIGINT).withSize(19));
        addMetadata(ssn, ColumnMetadata.named("ssn").withIndex(9).ofType(Types.CHAR).withSize(11).notNull());
    }

}

