package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.Content;
import bsuir.webtech.lab4.presentation.html.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Header extends Content {

    @Override
    public List<String> getStyles() {
        List<String> styles = new ArrayList<>();
        styles.add("css/header.css");
        return styles;
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder();

        content.append("<div>");
        content.append("<div class=\"title\">");
        content.append(HtmlUtils.createLink("/", "<h1>Гостиница #1</h1></a>"));
        content.append("</div>");

        content.append("<div class=\"menu\">");
        content.append(HtmlUtils.createLink("/suggestions", "Предложения"));
        content.append("</div>");

        content.append("<div class=\"options\">");
        if (session.isAuthorized()) {
            content.append(HtmlUtils.createLink("/account", "Аккаунт"));
            content.append(" | ");
            content.append(HtmlUtils.createLink("/action?type=exit", "Выход"));
        } else {
            content.append(HtmlUtils.createLink("/signin", "Вход"));
            content.append(" | ");
            content.append(HtmlUtils.createLink("/signup", "Регистрация"));
        }
        content.append(" | ");
        content.append(HtmlUtils.createLink("/", "Сменить язык"));
        content.append("</div>");

        content.append("</div>");

        return content.toString();
    }
}
