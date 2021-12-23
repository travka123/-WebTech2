package bsuir.webtech.lab3.server.protocols;

import bsuir.webtech.lab3.server.business.AuthorizationService;
import bsuir.webtech.lab3.shared.AccessRights;

import java.io.*;

public class AuthorizationProtocol {

    private final AuthorizationService authorizationService;

    public AuthorizationProtocol(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public AccessRights Communicate(DataInputStream in, DataOutputStream out) throws IOException {

        AccessRights accessRights = authorizationService.tryAuthorizeUser(in.readUTF(), in.readUTF());

        while (accessRights == null) {
            out.writeInt(0);
            accessRights = authorizationService.tryAuthorizeUser(in.readUTF(), in.readUTF());
        }

        out.writeInt(accessRights.getCode());

        return accessRights;
    }
}
