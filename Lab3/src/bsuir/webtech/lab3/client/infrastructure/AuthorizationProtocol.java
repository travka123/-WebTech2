package bsuir.webtech.lab3.client.infrastructure;

import bsuir.webtech.lab3.client.business.AuthorizationService;
import bsuir.webtech.lab3.shared.AccessRights;
import bsuir.webtech.lab3.shared.Cryptography;

import java.io.IOException;

public class AuthorizationProtocol extends AuthorizationService {
    private final ServerIO serverIO;

    public AuthorizationProtocol(ServerIO serverIO) {
        this.serverIO = serverIO;
    }

    @Override
    public AccessRights authorize(String userName, String password) throws IOException {
        serverIO.out.writeUTF(userName);
        serverIO.out.writeUTF(Cryptography.getPasswordHash(password));

        int code = serverIO.in.readInt();

        if (code == 0) {
            return null;
        }

        return new AccessRights(code);
    }
}
