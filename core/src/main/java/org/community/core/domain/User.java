package org.community.core.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    private Integer id;

    private String uid;

    private String username;

    private String password;

    private String name;

    /**
     * 男：1，女：0
     */
    private Integer gender;

    /**
     * 出生年月
     */
    private Date birthday;

    /**
     * 头像url
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    private String email;

    private String phone;

    private String location;

    private Boolean archived;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 信息更新时间
     */
    @Column(name = "update_at")
    private Date updateAt;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_at")
    private Date lastLoginAt;

    private String description;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取男：1，女：0
     *
     * @return gender - 男：1，女：0
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置男：1，女：0
     *
     * @param gender 男：1，女：0
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取出生年月
     *
     * @return birthday - 出生年月
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生年月
     *
     * @param birthday 出生年月
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取头像url
     *
     * @return avatar_url - 头像url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置头像url
     *
     * @param avatarUrl 头像url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return archived
     */
    public Boolean getArchived() {
        return archived;
    }

    /**
     * @param archived
     */
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取信息更新时间
     *
     * @return update_at - 信息更新时间
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * 设置信息更新时间
     *
     * @param updateAt 信息更新时间
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_at - 最后登录时间
     */
    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginAt 最后登录时间
     */
    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}