package bsuir.webtech.lab4.servlets.actions;

import bsuir.webtech.lab4.business.ServicesAccessPoint;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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

    protected void doNotImplemented(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/404");
    }
}
