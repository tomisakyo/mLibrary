package com.example.mylibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User implements Parcelable {

    private String userUID;
    private String email;
    private String userName, fullName;
    private String companyId;
    private Boolean enabled;
    private String phone;

    private long createdAt, lastUpdate;

    private ArrayList<UserAccess> userAccesses;
    private ArrayList<String> wallets;

    public User(String userUID, String email, String userName, String fullName, String companyId, Boolean enabled, String phone, long createdAt, long lastUpdate, ArrayList<UserAccess> userAccesses, ArrayList<String> wallets) {
        this.userUID = userUID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.companyId = companyId;
        this.enabled = enabled;
        this.phone = phone;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.userAccesses = userAccesses;
        this.wallets = wallets;
    }

    public User() {
        this.userUID = "";
        this.email = "";
        this.userName = "";
        this.companyId = "";
        this.enabled = true;
        this.phone = "";
        this.userAccesses = new ArrayList<>();
        this.wallets = new ArrayList<>();
    }

    protected User(Parcel in) {
        userUID = in.readString();
        email = in.readString();
        userName = in.readString();
        fullName = in.readString();
        companyId = in.readString();
        byte tmpIsEnabled = in.readByte();
        enabled = tmpIsEnabled == 0 ? null : tmpIsEnabled == 1;
        phone = in.readString();
        createdAt = in.readLong();
        lastUpdate = in.readLong();
        wallets = in.createStringArrayList();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<UserAccess> getUserAccesses() {
        return userAccesses;
    }

    public void setUserAccesses(ArrayList<UserAccess> userAccesses) {
        this.userAccesses = userAccesses;
    }

    public ArrayList<String> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<String> wallets) {
        this.wallets = wallets;
    }

    public String getUserAccessesPreviewString() {
        StringBuilder result = new StringBuilder();
        if (userAccesses != null && !userAccesses.isEmpty()) {
            for (int i = 0; i < userAccesses.size(); i++) {
                UserAccess userAccess = userAccesses.get(i);
                String accessType = "";
                if (userAccess.getAccessType() == UserAccess.TYPE_KITCHEN) accessType = "Kitchen";
                if (userAccess.getAccessType() == UserAccess.TYPE_OUTLET) accessType = "Outlet";
                result.append(i + 1).append(". ").append(accessType).append(" - ").append(userAccess.getAccessName());
                if (i + 1 != userAccesses.size()) {
                    result.append("\n");
                }
            }
        } else {
            result = new StringBuilder("No User Accesses");
        }
        return result.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userUID);
        parcel.writeString(email);
        parcel.writeString(userName);
        parcel.writeString(fullName);
        parcel.writeString(companyId);
        parcel.writeByte((byte) (enabled == null ? 0 : enabled ? 1 : 2));
        parcel.writeString(phone);
        parcel.writeLong(createdAt);
        parcel.writeLong(lastUpdate);
        parcel.writeStringList(wallets);
    }
}
