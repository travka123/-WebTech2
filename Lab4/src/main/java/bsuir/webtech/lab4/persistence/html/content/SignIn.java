package bsuir.webtech.lab4.persistence.html.content;

import bsuir.webtech.lab4.persistence.html.Content;

import java.util.Collections;
import java.util.List;

public class SignIn extends Content {
    private final boolean error;
    private final String salt;

    public SignIn(boolean error, String salt) {
        this.error = error;
        this.salt = salt;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        StringBuilder content = new StringBuilder("<form action=\"signin\" method=\"post\">" +
                "<h2>ВОЙТИ</h2>" +
                "<span>Электронная почта:</span>" +
                "<input id=\"form-email\"name=\"email\" placeholder=\"email\">" +
                "<span>Пароль:</span>" +
                "<input id=\"form-password\"name=\"password\" type=\"password\" placeholder=\"password\">" +
                "<input id=\"form-salt\" name=\"salt\" type=\"hidden\" value=\"" + salt + "\">" +
                "<button id=\"form-btn\" type=\"submit\">Войти</button>"
                );

        if (error) {
            content.append("<span>Неврное имя пользователя или пароль</span>");
        }

        content.append("</form>");

        content.append("<script type=\"text/javascript\" src=\"/js/MD5.js\"></script>");
        content.append("<script type=\"text/javascript\" src=\"/js/signinbtn.js\"></script>");

        return content.toString();
    }
}
