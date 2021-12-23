package bsuir.webtech.lab3.client.business;

import bsuir.webtech.lab3.shared.AccessRights;

import java.io.IOException;

public abstract class AuthorizationService {
    public abstract AccessRights authorize(String userName, String password) throws IOException;
}
