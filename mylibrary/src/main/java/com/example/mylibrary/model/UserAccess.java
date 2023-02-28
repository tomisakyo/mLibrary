package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.List;

public class UserAccess implements Serializable {
    private int accessType;
    private String accessId;
    private String accessName;
    private List<Permission> permissions;

    public UserAccess(int accessType, String accessId, String accessName, List<Permission> permissions) {
        this.accessType = accessType;
        this.accessId = accessId;
        this.accessName = accessName;
        this.permissions = permissions;
    }

    public UserAccess() {
        this.accessType = 0;
        this.accessId = "";
        this.accessName = "";
        this.permissions = null;
    }

    public int getAccessType() {
        return accessType;
    }

    public void setAccessType(int accessType) {
        this.accessType = accessType;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public static int TYPE_KITCHEN = 200;
    public static int TYPE_OUTLET = 300;


}
