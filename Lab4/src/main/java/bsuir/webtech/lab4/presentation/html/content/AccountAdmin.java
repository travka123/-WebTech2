package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;

public class AccountAdmin extends Content {

    private final UserSession session;

    public AccountAdmin(UserSession session) {
        this.session = session;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        StringBuilder content = new StringBuilder();
        content.append("<div>");
        content.append("<h2>Здравствуйте, " + session.getUserName() + "</h2>");
        content.append("<h3>У аккаунта есть права администратора!</h3>");
        content.append("</div>");
        return content.toString();
    }
}
