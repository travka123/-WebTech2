package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class AccountAdmin extends Content {
    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder();
        content.append("<div>");
        content.append("<h2>" + bundle.getString("language.hello") + ", " + session.getUserName() + "</h2>");
        content.append("<h3>" + bundle.getString("language.accountadmin") + "</h3>");
        content.append("</div>");
        return content.toString();
    }
}
