package bsuir.webtech.lab4.presentation.stubs;

import bsuir.webtech.lab4.business.Account;
import bsuir.webtech.lab4.business.AccountsRepository;
import bsuir.webtech.lab4.business.Cryptography;
import bsuir.webtech.lab4.business.UserRole;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class StubAccountRepository extends AccountsRepository {

    private final List<Account> accounts = new ArrayList<>();

    public StubAccountRepository() {
        try {
            accounts.add(new Account(
                    0,
                    "admin",
                    "admin",
                    Cryptography.getHash("admin"),
                    UserRole.ADMIN
            ));

            accounts.add(new Account(
                    0,
                    "user",
                    "user",
                    Cryptography.getHash("user"),
                    UserRole.USER
            ));

        } catch (NoSuchAlgorithmException ignored) {

        }
    }

    @Override
    public Account getAccountBy(String email) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }
}
