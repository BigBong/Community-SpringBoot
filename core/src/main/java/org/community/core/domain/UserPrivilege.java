package org.community.core.domain;

import javax.persistence.*;

@Table(name = "user_privilege")
public class UserPrivilege {
    @Column(name = "user_id")
    private Integer userId;

    private String privilege;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return privilege
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}