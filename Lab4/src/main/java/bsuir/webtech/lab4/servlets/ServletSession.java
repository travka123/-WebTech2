package bsuir.webtech.lab4.servlets;

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
