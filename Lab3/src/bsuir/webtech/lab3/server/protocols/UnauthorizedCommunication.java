package bsuir.webtech.lab3.server.protocols;

import bsuir.webtech.lab3.server.business.AuthorizationService;
import bsuir.webtech.lab3.shared.AccessRights;

import java.io.*;

public class UnauthorizedCommunication {

    private final AuthorizationService authorizationService;
    private final AuthorizedCommunication authorizedCommunication;

    public UnauthorizedCommunication(AuthorizationService authorizationService,
                                     AuthorizedCommunication authorizedCommunication) {

        this.authorizationService = authorizationService;
        this.authorizedCommunication = authorizedCommunication;
    }

    public void Communicate(DataInputStream in, DataOutputStream out) throws IOException {

        AccessRights accessRights = authorizationService.tryAuthorizeUser(in.readUTF(), in.readUTF());

        while (accessRights == null) {
            out.writeInt(0);
            accessRights = authorizationService.tryAuthorizeUser(in.readUTF(), in.readUTF());
        }

        out.writeInt(accessRights.getCode());

        authorizedCommunication.Communicate(in, out, accessRights);
    }
}
