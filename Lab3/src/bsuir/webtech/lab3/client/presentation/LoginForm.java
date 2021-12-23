package bsuir.webtech.lab3.client.presentation;

import bsuir.webtech.lab3.client.business.AuthorizationService;
import bsuir.webtech.lab3.shared.AccessRights;

import java.io.IOException;

public class LoginForm {

    private final UserIO userIO;
    private final AuthorizationService authorizationService;

    public LoginForm(UserIO userIO, AuthorizationService authorizationAlgorithm) {
        this.userIO = userIO;
        this.authorizationService = authorizationAlgorithm;
    }

    public AccessRights show() throws IOException {

            userIO.print("Введите имя:\n");
            String userName = userIO.getString();

            userIO.print("Введите пароль:\n");
            String password = userIO.getString();

            AccessRights accessRights = authorizationService.authorize(userName, password);
            while (accessRights == null) {

                userIO.print("Пользователя с таким именем и паролем не существует.\n");

                userIO.print("Введите имя:\n");
                userName = userIO.getString();

                userIO.print("Введите пароль:\n");
                password = userIO.getString();

                accessRights = authorizationService.authorize(userName, password);
            }

            return accessRights;
    }
}
