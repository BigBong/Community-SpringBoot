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
     * �У�1��Ů��0
     */
    private Integer gender;

    /**
     * ��������
     */
    private Date birthday;

    /**
     * ͷ��url
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    private String email;

    private String phone;

    private String location;

    private Boolean archived;

    /**
     * ����ʱ��
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * ��Ϣ����ʱ��
     */
    @Column(name = "update_at")
    private Date updateAt;

    /**
     * ����¼ʱ��
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
     * ��ȡ�У�1��Ů��0
     *
     * @return gender - �У�1��Ů��0
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * �����У�1��Ů��0
     *
     * @param gender �У�1��Ů��0
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * ��ȡ��������
     *
     * @return birthday - ��������
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * ���ó�������
     *
     * @param birthday ��������
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * ��ȡͷ��url
     *
     * @return avatar_url - ͷ��url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * ����ͷ��url
     *
     * @param avatarUrl ͷ��url
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
     * ��ȡ����ʱ��
     *
     * @return created_at - ����ʱ��
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createdAt ����ʱ��
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * ��ȡ��Ϣ����ʱ��
     *
     * @return update_at - ��Ϣ����ʱ��
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * ������Ϣ����ʱ��
     *
     * @param updateAt ��Ϣ����ʱ��
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * ��ȡ����¼ʱ��
     *
     * @return last_login_at - ����¼ʱ��
     */
    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    /**
     * ��������¼ʱ��
     *
     * @param lastLoginAt ����¼ʱ��
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