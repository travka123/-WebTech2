package bsuir.webtech.lab4.servlets.pages;

import bsuir.webtech.lab4.business.Beans.User;
import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.presentation.html.content.*;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();
    private final View userView = new View(new Header(), new Account(servicesAccessPoint));
    private final View adminView = new View(new Header(), new AccountAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        switch (session.getUserRole()) {
            case User.UserRole.user:
                resp.getWriter().write(userView.get(session));
                break;

            case User.UserRole.admin:
                resp.getWriter().write(adminView.get(session));
                break;
        }
    }
}
