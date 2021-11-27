package bsuir.webtech.lab4.persistence.html.content;

import bsuir.webtech.lab4.persistence.html.Content;
import bsuir.webtech.lab4.persistence.html.HtmlUtils;

import java.util.Collections;
import java.util.List;

public class Header extends Content {

    private final boolean authorized;

    public Header(boolean authorized) {
        this.authorized = authorized;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        StringBuilder content = new StringBuilder();

        content.append("<div>");
        content.append("<div>");
        content.append(HtmlUtils.createLink("/", "Гостиница #1"));
        content.append(HtmlUtils.createLink("/catalog", "ПРЕДЛОЖЕНИЯ"));
        content.append("<div>");
        if (authorized) {
            content.append(HtmlUtils.createLink("/account", "Аккаунт"));
            content.append(" | ");
            content.append(HtmlUtils.createLink("/exit", "Выход"));
        } else {
            content.append(HtmlUtils.createLink("/signin", "Вход"));
            content.append(" | ");
            content.append(HtmlUtils.createLink("/signup", "Регистрация"));
        }
        content.append(" | ");
        content.append(HtmlUtils.createLink("/", "Сменить язык"));
        content.append("</div>");
        content.append("</div>");
        content.append("</div>");

        return content.toString();
    }
}
