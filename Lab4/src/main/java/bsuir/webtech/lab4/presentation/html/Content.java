package bsuir.webtech.lab4.presentation.html;

import bsuir.webtech.lab4.business.UserSession;

import java.util.List;
import java.util.ResourceBundle;

public abstract class Content {
    public abstract List<String> getStyles();
    public abstract String get(UserSession session, ResourceBundle bundle);
}
