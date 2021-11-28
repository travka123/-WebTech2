package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.business.UserRole;
import bsuir.webtech.lab4.persistence.html.content.Header;
import bsuir.webtech.lab4.persistence.html.content.Suggestions;
import bsuir.webtech.lab4.persistence.html.content.SuggestionsAdmin;
import bsuir.webtech.lab4.persistence.views.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/suggestions")
public class SuggestionsServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req.getSession());

        Suggestions content;
        if (session.getUserRole() == UserRole.ADMIN) {
            content = new SuggestionsAdmin(servicesAccessPoint.getRoomsService());
        } else {
            content = new Suggestions(servicesAccessPoint.getRoomsService());
        }

        resp.getWriter().write(new View().get(
                new Header(session.isAuthorized()),
                content
        ));
    }
}
