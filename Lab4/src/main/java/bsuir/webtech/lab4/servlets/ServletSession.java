package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.business.Beans.User;
import bsuir.webtech.lab4.business.UserSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Locale;

public class ServletSession extends UserSession {

    private final HttpSession session;
    private final Locale locale;

    public ServletSession(HttpServletRequest req) {
        this.session = req.getSession();
        locale = req.getLocale();
    }

    @Override
    public boolean isAuthorized() {
        return session.getAttribute("id") != null;
    }

    @Override
    public void setUserId(int userId) {
        session.setAttribute("id", userId);
        session.setMaxInactiveInterval(-1);
    }

    @Override
    public String getUserRole() {
        Object value = session.getAttribute("role");
        if (value == null) {
            return User.UserRole.guest;
        } else {
            return (String) value;
        }
    }

    @Override
    public void setUserRole(String userRole) {
        session.setAttribute("role", userRole);
    }

    @Override
    public String getUserName() {
        return (String) session.getAttribute("name");
    }

    @Override
    public void setUserName(String name) {
        session.setAttribute("name", name);
    }

    @Override
    public Locale getUserLocale() {

        Locale lang = (Locale) session.getAttribute("lang");

        if (lang != null) {
            return lang;
        }

        return locale;
    }

    @Override
    public void setUserLocale(Locale locale) {
        session.setAttribute("lang", locale);
    }

    @Override
    public int getUserId() {
        Object id = session.getAttribute("id");

        if (id == null) {
            return -1;
        }

        return (int)id;
    }

    @Override
    public void clear() {
        session.invalidate();
    }
}
