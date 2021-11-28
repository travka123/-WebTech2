package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.business.UserRole;
import bsuir.webtech.lab4.business.UserSession;
import jakarta.servlet.http.HttpSession;

public class ServletSession extends UserSession {

    private final HttpSession session;

    public ServletSession(HttpSession session) {
        this.session = session;
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
    public UserRole getUserRole() {
        Object value = session.getAttribute("role");
        if (value == null) {
            return UserRole.NONE;
        } else {
            return (UserRole) value;
        }
    }

    @Override
    public void setUserRole(UserRole userRole) {
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
