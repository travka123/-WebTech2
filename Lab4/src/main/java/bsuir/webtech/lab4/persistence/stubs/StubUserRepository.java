package bsuir.webtech.lab4.persistence.stubs;

import bsuir.webtech.lab4.business.Beans.User;
import bsuir.webtech.lab4.business.UsersRepository;
import bsuir.webtech.lab4.business.Cryptography;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class StubUserRepository extends UsersRepository {

    private final List<User> users = new ArrayList<>();

    public StubUserRepository() {
        try {
            users.add(new User(
                    0,
                    "admin",
                    "admin",
                    Cryptography.getHash("admin"),
                    User.UserRole.admin
            ));

            users.add(new User(
                    0,
                    "user",
                    "user",
                    Cryptography.getHash("user"),
                    User.UserRole.user
            ));

        } catch (NoSuchAlgorithmException ignored) {

        }
    }

    @Override
    public User getAccountByLogin(String login) {
        for (User user : users) {
            if (user.getEmail().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
