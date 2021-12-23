package bsuir.webtech.lab4.servlets.actions;

import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

public abstract class Actions {

    protected static ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/");
    }

    public void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/");
    }

    public void signUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/");
    }

    public String book(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/");
        return null;
    }

    public void changeRoomStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/");
    }

    public void changeLang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String lang = req.getParameter("lang");
        if ((Objects.equals(lang, "ru")) || (Objects.equals(lang, "en"))) {
            new ServletSession(req).setUserLocale(new Locale(lang));
        }
        resp.sendRedirect("/");
    }
}
