package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class SignUp extends Content {

    private final boolean error;

    public SignUp(boolean error) {
        this.error = error;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder("<form action=\"signup\" method=\"post\">" +
                "<h2>Регистрация</h2>" +
                "<span>Логин:</span>" +
                "<input id=\"form-login\" name=\"login\" placeholder=\"login\">" +
                "<span>Имя:</span>" +
                "<input id=\"form-name\" name=\"name\" placeholder=\"name\">" +
                "<span>Пароль:</span>" +
                "<input id=\"form-password\" name=\"password\" type=\"password\" placeholder=\"password\">" +
                "<button id=\"form-btn\"type=\"submit\">Зарегестрироваться</button>");

        if (error) {
            content.append("Имя пользователя слишком короткое, или уже занято");
        }

        content.append("<script type=\"text/javascript\" src=\"/js/MD5.js\"></script>");
        content.append("<script type=\"text/javascript\" src=\"/js/signupbtn.js\"></script>");

        return content.toString();
    }
}
