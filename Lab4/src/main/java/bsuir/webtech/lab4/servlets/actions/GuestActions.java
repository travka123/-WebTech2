package bsuir.webtech.lab4.servlets.actions;

import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GuestActions extends Actions {

    @Override
    public void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (servicesAccessPoint.getAuthorizationService().tryAuthorize(
                new ServletSession(req),
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("salt"))) {

            resp.sendRedirect("/");
        }
        else {
            resp.sendRedirect("/signin?err=true");
        }
    }

    @Override
    public void signUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (servicesAccessPoint.getAuthorizationService().tryRegister(
                new ServletSession(req),
                req.getParameter("login"),
                req.getParameter("name"),
                req.getParameter("password"))) {

            resp.sendRedirect("/signin");
        } else {
            resp.sendRedirect("/signup?err=true");
        }
    }

    @Override
    public String book(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/action&type=signin");
        return null;
    }
}
