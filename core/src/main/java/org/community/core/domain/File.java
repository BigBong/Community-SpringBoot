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
     * 当前文件大小（最大24位-16MB）
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * 文件总大小（最大24位-16MB）
     */
    @Column(name = "file_total_size")
    private Long fileTotalSize;

    private Integer status;

    private String md5;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后一次上传时间
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
     * 获取当前文件大小（最大24位-16MB）
     *
     * @return file_size - 当前文件大小（最大24位-16MB）
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 设置当前文件大小（最大24位-16MB）
     *
     * @param fileSize 当前文件大小（最大24位-16MB）
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取文件总大小（最大24位-16MB）
     *
     * @return file_total_size - 文件总大小（最大24位-16MB）
     */
    public Long getFileTotalSize() {
        return fileTotalSize;
    }

    /**
     * 设置文件总大小（最大24位-16MB）
     *
     * @param fileTotalSize 文件总大小（最大24位-16MB）
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后一次上传时间
     *
     * @return update_time - 最后一次上传时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后一次上传时间
     *
     * @param updateTime 最后一次上传时间
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