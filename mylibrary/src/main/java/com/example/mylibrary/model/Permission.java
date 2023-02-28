package com.example.mylibrary.model;

import java.io.Serializable;

public class Permission implements Serializable {
    private int permissionCode;
    private String name;

    public Permission(int permissionCode, String name) {
        this.permissionCode = permissionCode;
        this.name = name;
    }

    public Permission() {
        this.permissionCode = -1;
        this.name = "";
    }

    public int getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(int permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
