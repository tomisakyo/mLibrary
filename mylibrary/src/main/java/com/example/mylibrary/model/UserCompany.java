package com.example.mylibrary.model;

import java.io.Serializable;

public class UserCompany implements Serializable {
    private String userName;
    private String userId;
    private String email;
    private boolean isEnabled;
    private String contact;
    //    Todo : On Company Updated, update user company name too
    private String companyName;

    public UserCompany(String userName, String userId, String email, boolean isEnabled, String contact, String companyId, String companyName) {
        this.userName = userName;
        this.userId = userId;
        this.email = email;
        this.isEnabled = isEnabled;
        this.contact = contact;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public UserCompany() {
        this.userName = "";
        this.userId = "";
        this.email = "";
        this.isEnabled = false;
        this.contact = "";
        this.companyId = "";
        this.companyName = "";
    }

    private String companyId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
