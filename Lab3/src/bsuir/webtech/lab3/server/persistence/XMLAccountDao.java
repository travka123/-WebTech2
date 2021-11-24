package bsuir.webtech.lab3.server.persistence;

import bsuir.webtech.lab3.server.business.Account;
import bsuir.webtech.lab3.server.business.AccountService;
import bsuir.webtech.lab3.shared.AccessRights;
import bsuir.webtech.lab3.shared.Cryptography;
import bsuir.webtech.lab3.shared.Student;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLAccountDao extends AccountService {

    private final String filePath;
    private final List<Account> accounts = new ArrayList<>();

    public XMLAccountDao(String filePath) {
        this.filePath = filePath;

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
            while (true) {
                try {
                    Account account = (Account) decoder.readObject();
                    accounts.add(account);
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        } catch (FileNotFoundException ignored) {

        }
    }

    @Override
    public Account getAccountByUsername(String username) {
        for(Account account : accounts) {
            if (account.getUserName().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public void fillWithDefault() {
        accounts.clear();
        accounts.add(new Account(
                "admin",
                Cryptography.getPasswordHash("admin"),
                new AccessRights(AccessRights.CREATE | AccessRights.READ | AccessRights.UPDATE)
        ));

        accounts.add(new Account(
                "user123",
                Cryptography.getPasswordHash("123"),
                new AccessRights(AccessRights.READ)
        ));

        accounts.add(new Account(
                "redactor",
                Cryptography.getPasswordHash("333"),
                new AccessRights(AccessRights.READ | AccessRights.UPDATE)
        ));

        accounts.add(new Account(
                "a_create",
                Cryptography.getPasswordHash("qwerty"),
                new AccessRights(AccessRights.CREATE)
        ));
    }

    public void saveAll() {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)));
            for (Account account : accounts) {
                encoder.writeObject(account);
            }
            encoder.close();
        } catch (FileNotFoundException ignored) {

        }
    }
}
