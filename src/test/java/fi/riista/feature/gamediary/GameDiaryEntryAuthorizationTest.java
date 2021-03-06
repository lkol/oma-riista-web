package fi.riista.feature.gamediary;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import fi.riista.feature.EmbeddedDatabaseTest;
import fi.riista.feature.account.user.SystemUser;
import fi.riista.feature.account.user.UserRepository;
import fi.riista.feature.common.entity.GeoLocation;
import fi.riista.feature.gamediary.GameDiaryEntry;
import fi.riista.feature.gamediary.GameSpecies;
import fi.riista.feature.huntingclub.HuntingClub;
import fi.riista.feature.huntingclub.group.HuntingClubGroup;
import fi.riista.feature.huntingclub.hunting.day.GroupHuntingDay;
import fi.riista.feature.organization.occupation.Occupation;
import fi.riista.feature.organization.occupation.OccupationType;
import fi.riista.feature.organization.person.Person;
import fi.riista.util.DateUtil;
import fi.riista.util.F;
import org.joda.time.LocalDate;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.EnumSet;
import java.util.Set;

import static fi.riista.security.EntityPermission.CREATE;
import static fi.riista.security.EntityPermission.DELETE;
import static fi.riista.security.EntityPermission.READ;
import static fi.riista.security.EntityPermission.UPDATE;

/**
 * Common base class for testing hunting club group related functions for game
 * diary entries.
 */
public abstract class GameDiaryEntryAuthorizationTest<T extends GameDiaryEntry> extends EmbeddedDatabaseTest {

    protected static final ImmutableSet<Enum<?>> NO_PERMS = ImmutableSet.of(CREATE);

    @Resource
    private UserRepository userRepo;

    protected abstract ImmutableSet<Enum<?>> getAllPermissions();

    protected abstract Enum<?> getPermissionForLinkingDiaryEntryToGroupHuntingDay();

    protected abstract T create();

    protected abstract T create(final GameSpecies species, final Person author);

    protected abstract void addGroupRejection(final HuntingClubGroup group, final T diaryEntry);

    @Test
    public void testAdminPermissions() {
        final T diaryEntry = create();
        onSavedAndAuthenticated(createNewAdmin(), tx(() -> assertPermissions(diaryEntry, getAllPermissions())));
    }

    @Test
    public void testAuthorPermissions() {
        withPerson(author -> {
            final T diaryEntry = create();
            diaryEntry.setAuthor(author);

            onSavedAndAuthenticated(
                    createUser(author),
                    tx(() -> assertPermissions(diaryEntry, EnumSet.of(CREATE, READ, UPDATE, DELETE))));
        });
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenUnlinkedDiaryEntryWithinGroupArea() {
        final GeoLocation location = geoLocation();
        final HuntingClub club = model().newHuntingClub();
        final HuntingClubGroup group = model().newHuntingClubGroupWithAreaContaining(club, location);
        model().newHarvestPermitForHuntingGroup(group);

        final Occupation clubOccupation = model().newHuntingClubMember(club, OccupationType.SEURAN_JASEN);
        final Occupation groupOccupation = model().newHuntingClubGroupMember(clubOccupation.getPerson(), group);
        final Person author = groupOccupation.getPerson();

        final T diaryEntry = create(group.getSpecies(), author);
        diaryEntry.setGeoLocation(location);

        final Enum<?> linkPerm = getPermissionForLinkingDiaryEntryToGroupHuntingDay();

        assertPermissions(
                diaryEntry,
                group,
                ImmutableSet.of(CREATE, READ, UPDATE, linkPerm),
                ImmutableSet.of(CREATE, READ),
                ImmutableSet.of(CREATE, READ, UPDATE, linkPerm),
                ImmutableSet.of(CREATE, READ));
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenUnlinkedDiaryEntryNotWithinGroupArea() {
        final GeoLocation location = geoLocation();
        final HuntingClub club = model().newHuntingClub();
        final HuntingClubGroup group = model().newHuntingClubGroupWithAreaNotContaining(club, location);
        model().newHarvestPermitForHuntingGroup(group);

        final Occupation clubOccupation = model().newHuntingClubMember(club, OccupationType.SEURAN_JASEN);
        final Occupation groupOccupation = model().newHuntingClubGroupMember(clubOccupation.getPerson(), group);
        final Person author = groupOccupation.getPerson();

        final T diaryEntry = create(group.getSpecies(), author);
        diaryEntry.setGeoLocation(location);

        assertPermissions(diaryEntry, group, NO_PERMS, NO_PERMS, NO_PERMS, NO_PERMS);
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenDiaryEntryLinkedToHuntingDayOfGroup() {
        final GeoLocation location = geoLocation();
        final HuntingClub club = model().newHuntingClub();
        final HuntingClubGroup group = model().newHuntingClubGroupWithAreaContaining(club, location);
        model().newHarvestPermitForHuntingGroup(group);

        final Occupation clubOccupation = model().newHuntingClubMember(club, OccupationType.SEURAN_JASEN);
        final Occupation groupOccupation = model().newHuntingClubGroupMember(clubOccupation.getPerson(), group);
        final Person author = groupOccupation.getPerson();

        final GroupHuntingDay huntingDay = model().newGroupHuntingDay(group, DateUtil.today());

        final T diaryEntry = create(group.getSpecies(), author);
        diaryEntry.updateHuntingDayOfGroup(huntingDay, null);

        final Enum<?> linkPerm = getPermissionForLinkingDiaryEntryToGroupHuntingDay();

        assertPermissions(
                diaryEntry,
                group,
                ImmutableSet.of(CREATE, READ, UPDATE, linkPerm),
                ImmutableSet.of(CREATE, READ),
                ImmutableSet.of(CREATE, READ, UPDATE, linkPerm),
                ImmutableSet.of(CREATE, READ));
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenUnlinkedDiaryEntryRejectedFromGroup() {
        final GeoLocation location = geoLocation();
        final HuntingClub club = model().newHuntingClub();
        final HuntingClubGroup group = model().newHuntingClubGroupWithAreaContaining(club, location);
        model().newHarvestPermitForHuntingGroup(group);

        final Occupation clubOccupation = model().newHuntingClubMember(club, OccupationType.SEURAN_JASEN);
        final Occupation groupOccupation = model().newHuntingClubGroupMember(clubOccupation.getPerson(), group);
        final Person author = groupOccupation.getPerson();

        final T diaryEntry = create(group.getSpecies(), author);
        diaryEntry.setGeoLocation(location);
        addGroupRejection(group, diaryEntry);

        final Enum<?> linkPerm = getPermissionForLinkingDiaryEntryToGroupHuntingDay();

        assertPermissions(diaryEntry, group,
                ImmutableSet.of(CREATE, READ, UPDATE, linkPerm),
                ImmutableSet.of(CREATE, READ),
                ImmutableSet.of(CREATE, READ, UPDATE, linkPerm),
                ImmutableSet.of(CREATE, READ));
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenPersonInvitedToClubAndMarkedAsGroupMember() {
        testNoPermissions(false, TriConsumer.NOOP());
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenGroupMemberIsSoftDeleted() {
        testNoPermissions(true, (clubOcc, groupOcc, harvestDate) -> groupOcc.softDelete());
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenClubMemberIsSoftDeleted() {
        testNoPermissions(true, (clubOcc, groupOcc, harvestDate) -> clubOcc.softDelete());
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenGroupMemberIsNotValid() {
        testNoPermissions(true, (clubOcc, groupOcc, harvestDate) -> groupOcc.setEndDate(harvestDate.minusDays(1)));
    }

    @Test
    public void testHuntingClubGroupBasedPermissions_whenClubMemberIsNotValid() {
        testNoPermissions(true, (clubOcc, groupOcc, harvestDate) -> clubOcc.setBeginDate(harvestDate.plusDays(1)));
    }

    private interface TriConsumer<A, B, C> {
        void accept(A a, B b, C c);

        static <A, B, C> TriConsumer<A, B, C> NOOP() {
            return (a, b, c) -> {};
        }
    }

    private void testNoPermissions(boolean createClubOCcupation, TriConsumer<Occupation, Occupation, LocalDate> modifyOccupations) {
        final GeoLocation location = geoLocation();
        final HuntingClub club = model().newHuntingClub();
        final HuntingClubGroup group = model().newHuntingClubGroupWithAreaContaining(club, location);
        model().newHarvestPermitForHuntingGroup(group);

        final Occupation clubOccupation = createClubOCcupation ? model().newHuntingClubMember(club, OccupationType.SEURAN_JASEN) : null;
        final Occupation groupOccupation = model().newHuntingClubGroupMember(clubOccupation != null ? clubOccupation.getPerson() : model().newPerson(), group);

        final Person author = groupOccupation.getPerson();

        final T diaryEntry = create(group.getSpecies(), author);
        diaryEntry.setGeoLocation(location);

        modifyOccupations.accept(clubOccupation, groupOccupation, LocalDate.fromDateFields(diaryEntry.getPointOfTime()));

        assertPermissions(diaryEntry, group, NO_PERMS, NO_PERMS, NO_PERMS, NO_PERMS);
    }

    protected void assertPermissions(final T diaryEntry, final Set<? extends Enum<?>> allowedPermissions) {
        assertHasPermissions(diaryEntry, allowedPermissions);
        assertNoPermissions(diaryEntry, Sets.difference(getAllPermissions(), allowedPermissions));
    }

    private void assertPermissions(
            final T persistentDiaryEntry, final SystemUser user, final Set<? extends Enum<?>> userPermissions) {

        Preconditions.checkArgument(F.hasId(user), "SystemUser-ID must not be null");

        // Firstly, refresh detached SystemUser from database.

        final SystemUser persistentUser = userRepo.getOne(user.getId());

        authenticate(persistentUser);
        assertPermissions(persistentDiaryEntry, userPermissions);
    }

    protected void assertPermissions(
            final T diaryEntry,
            final HuntingClubGroup group,
            final Set<? extends Enum<?>> groupLeaderPermissions,
            final Set<? extends Enum<?>> groupMemberPermissions,
            final Set<? extends Enum<?>> clubContactPermissions,
            final Set<? extends Enum<?>> clubMemberPermissions) {

        Preconditions.checkArgument(diaryEntry.isNew(), "GameDiaryEntry must be transient entity (not yet persisted)");
        Preconditions.checkArgument(group.isNew(), "HuntingClubGroup must be transient entity (not yet persisted)");

        runInTransaction(() -> {
            final HuntingClub club = (HuntingClub) group.getParentOrganisation();

            final SystemUser clubContact = createNewUser(
                    "clubContact",
                    model().newHuntingClubMember(club, OccupationType.SEURAN_YHDYSHENKILO).getPerson());

            final SystemUser clubMember = createNewUser(
                    "clubMember", model().newHuntingClubMember(club, OccupationType.SEURAN_JASEN).getPerson());

            final SystemUser groupLeader = createNewUser(
                    "groupLeader",
                    model().newHuntingClubGroupMember(
                            group, OccupationType.RYHMAN_METSASTYKSENJOHTAJA).getPerson());

            final SystemUser groupMember = createNewUser(
                    "groupMember",
                    model().newHuntingClubGroupMember(group, OccupationType.RYHMAN_JASEN).getPerson());

            persistInCurrentlyOpenTransaction();

            assertPermissions(diaryEntry, groupLeader, groupLeaderPermissions);
            assertPermissions(diaryEntry, groupMember, groupMemberPermissions);
            assertPermissions(diaryEntry, clubContact, clubContactPermissions);
            assertPermissions(diaryEntry, clubMember, clubMemberPermissions);
        });
    }

}
