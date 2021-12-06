package bsuir.webtech.lab4.business;

import java.util.Locale;

public abstract class UserSession {
    public abstract boolean isAuthorized();

    public abstract int getUserId();
    public abstract void setUserId(int userId);

    public abstract String getUserRole();
    public abstract void setUserRole(String userRole);

    public abstract String getUserName();
    public abstract void setUserName(String name);

    public abstract Locale getUserLocale();
    public abstract void setUserLocale(Locale locale);

    public abstract void clear();
}
