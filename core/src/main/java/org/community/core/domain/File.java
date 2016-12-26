package org.community.core.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "file")
public class File {
    @Id
    private Integer id;

    @Column(name = "file_name")
    private String fileName;

    private String path;

    /**
     * ��ǰ�ļ���С�����24λ-16MB��
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * �ļ��ܴ�С�����24λ-16MB��
     */
    @Column(name = "file_total_size")
    private Long fileTotalSize;

    private Integer status;

    private String md5;

    /**
     * ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * ���һ���ϴ�ʱ��
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * @return file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * ��ȡ��ǰ�ļ���С�����24λ-16MB��
     *
     * @return file_size - ��ǰ�ļ���С�����24λ-16MB��
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * ���õ�ǰ�ļ���С�����24λ-16MB��
     *
     * @param fileSize ��ǰ�ļ���С�����24λ-16MB��
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * ��ȡ�ļ��ܴ�С�����24λ-16MB��
     *
     * @return file_total_size - �ļ��ܴ�С�����24λ-16MB��
     */
    public Long getFileTotalSize() {
        return fileTotalSize;
    }

    /**
     * �����ļ��ܴ�С�����24λ-16MB��
     *
     * @param fileTotalSize �ļ��ܴ�С�����24λ-16MB��
     */
    public void setFileTotalSize(Long fileTotalSize) {
        this.fileTotalSize = fileTotalSize;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return create_time - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��ȡ���һ���ϴ�ʱ��
     *
     * @return update_time - ���һ���ϴ�ʱ��
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * �������һ���ϴ�ʱ��
     *
     * @param updateTime ���һ���ϴ�ʱ��
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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