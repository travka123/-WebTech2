package bsuir.webtech.lab4.presentation.stubs;

import bsuir.webtech.lab4.business.Account;
import bsuir.webtech.lab4.business.AccountsRepository;
import bsuir.webtech.lab4.business.Cryptography;
import bsuir.webtech.lab4.business.UserRole;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class StubAccountRepository extends AccountsRepository {
    @Override
    public Account getAccountBy(String email) {
        if (!Objects.equals(email, "admin")) {
            return null;
        }

        try {
            return new Account(
                    0,
                    "admin",
                    "admin",
                    Cryptography.getHash("admin"),
                    UserRole.Guest
            );
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
