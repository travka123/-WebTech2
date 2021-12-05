package bsuir.webtech.lab4.servlets;


import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.business.UserRole;
import bsuir.webtech.lab4.presentation.html.Content;
import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.presentation.html.content.Account;
import bsuir.webtech.lab4.presentation.html.content.AccountAdmin;
import bsuir.webtech.lab4.presentation.html.content.Header;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req.getSession());
        UserRole role = session.getUserRole();

        if (role == UserRole.NONE) {
            resp.sendRedirect("/signin");
            return;
        }

        Content content;
        if (role == UserRole.ADMIN) {
            content = new AccountAdmin(session);
        }
        else {
            content = new Account(session, servicesAccessPoint);
        }

        resp.getWriter().write(new View().get(new Header(session.isAuthorized()), content));
    }
}
