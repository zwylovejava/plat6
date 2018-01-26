package net.northking.cloudplatform.dto.cust;

import net.northking.cloudplatform.domain.project.CltCustomer;
import net.northking.cloudplatform.query.user.OrgQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
public class CustomerDTO {
    private CltCustomer cust;
    private UserAndLoginQuery userAndLoginQuery;
    private OrgQuery orgQuery;

    public CltCustomer getCust() {
        return cust;
    }

    public UserAndLoginQuery getUserAndLoginQuery() {
        return userAndLoginQuery;
    }

    public OrgQuery getOrgQuery() {
        return orgQuery;
    }

    public void setCust(CltCustomer cust) {
        this.cust = cust;
    }

    public void setUserAndLoginQuery(UserAndLoginQuery userAndLoginQuery) {
        this.userAndLoginQuery = userAndLoginQuery;
    }

    public void setOrgQuery(OrgQuery orgQuery) {
        this.orgQuery = orgQuery;
    }
}
