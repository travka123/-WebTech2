package bsuir.webtech.lab3.server.persistence;

import bsuir.webtech.lab3.server.business.Account;
import bsuir.webtech.lab3.server.business.AccountService;
import bsuir.webtech.lab3.shared.AccessRights;
import bsuir.webtech.lab3.shared.Cryptography;

import java.util.Arrays;
import java.util.List;

public class SimpleAccountDao extends AccountService {

    List<Account> accounts = Arrays.asList(
            new Account(
                    "admin",
                    Cryptography.getPasswordHash("admin"),
                    new AccessRights(AccessRights.CREATE | AccessRights.READ | AccessRights.UPDATE)
            ),
            new Account(
                    "user123",
                    Cryptography.getPasswordHash("123"),
                    new AccessRights(AccessRights.READ)
            ),
            new Account(
                    "redactor",
                    Cryptography.getPasswordHash("333"),
                    new AccessRights(AccessRights.UPDATE | AccessRights.CREATE)
            ),
            new Account(
                    "a_create",
                    Cryptography.getPasswordHash("qwerty"),
                    new AccessRights(AccessRights.CREATE)
            )
    );

    @Override
    public Account getAccountByUsername(String userName) {
        for(Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }
}
