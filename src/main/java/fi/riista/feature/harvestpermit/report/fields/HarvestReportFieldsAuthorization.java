package fi.riista.feature.harvestpermit.report.fields;

import fi.riista.security.EntityPermission;
import fi.riista.security.authorization.AbstractEntityAuthorization;
import org.springframework.stereotype.Component;

import static fi.riista.feature.account.user.SystemUser.Role.ROLE_ADMIN;
import static fi.riista.feature.account.user.SystemUser.Role.ROLE_MODERATOR;
import static fi.riista.feature.account.user.SystemUser.Role.ROLE_USER;

@Component
public class HarvestReportFieldsAuthorization extends AbstractEntityAuthorization<HarvestReportFields> {
    public HarvestReportFieldsAuthorization() {
        allow(EntityPermission.READ, ROLE_ADMIN, ROLE_MODERATOR, ROLE_USER);
        allow(EntityPermission.CREATE, ROLE_ADMIN);
        allow(EntityPermission.UPDATE, ROLE_ADMIN);
    }
}
