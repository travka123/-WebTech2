package bsuir.webtech.lab3.server.business;

import bsuir.webtech.lab3.shared.AccessRights;

public class Account {
    private final String userName;
    private final String passwordHash;
    private final  AccessRights accessRights;

    public Account(String userName, String passwordHash, AccessRights accessRights) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.accessRights = accessRights;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public AccessRights getAccessRights() {
        return accessRights;
    }
}
