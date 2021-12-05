package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.presentation.html.Content;
import bsuir.webtech.lab4.presentation.html.content.Header;
import bsuir.webtech.lab4.presentation.html.content.SignIn;
import bsuir.webtech.lab4.presentation.html.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    private final View view = new View();

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Content content;

        if (req.getParameter("err") == null) {
            content = new SignIn(false, servicesAccessPoint.getAuthorizationService().createSalt());
        }
        else {
            content = new SignIn(true, servicesAccessPoint.getAuthorizationService().createSalt());
        }

        if (new ServletSession(req.getSession()).isAuthorized()) {
            resp.sendRedirect("/");
        }
        else {
            resp.getWriter().write(view.get(new Header(false), content));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (servicesAccessPoint.getAuthorizationService().tryAuthorize(
                new ServletSession(req.getSession()),
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("salt"))) {

            resp.sendRedirect("/");
        }
        else {
            resp.sendRedirect("/signin?err=true");
        }
    }
}
