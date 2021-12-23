package bsuir.webtech.lab4.presentation.html;
import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.content.Body;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class View {

    private static final Head head = new Head();
    private static final String encoding = "UTF-8";

    private final Content body;

    public View(Content header, Content main) {
        this.body = new Body(header, main);
    }

    public String get(UserSession session) {

        ResourceBundle bundle = ResourceBundle.getBundle("localization/localization", session.getUserLocale());

        return "<!DOCTYPE html><html>" +
                head.get(encoding, body.getStyles()) +
                body.get(session, bundle) +
                "</html>";
    }
}
