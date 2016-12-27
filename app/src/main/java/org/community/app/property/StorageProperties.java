package org.community.app.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by frodoking on 2016/12/27.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
