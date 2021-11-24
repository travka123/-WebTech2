package bsuir.webtech.lab3.server.business;

import bsuir.webtech.lab3.shared.AccessRights;

public class Account {
    private String userName;
    private String passwordHash;
    private int accessCode;

    public Account() {

    }

    public Account(String userName, String passwordHash, AccessRights accessRights) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.accessCode = accessRights.getCode();
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public int getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(int accessCode) {
        this.accessCode = accessCode;
    }

    public AccessRights getAccessRights() {
        return new AccessRights(accessCode);
    }
}
