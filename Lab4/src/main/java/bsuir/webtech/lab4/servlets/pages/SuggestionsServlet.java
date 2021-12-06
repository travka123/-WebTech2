package bsuir.webtech.lab4.servlets.pages;

import bsuir.webtech.lab4.business.Beans.User;
import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.presentation.html.content.Header;
import bsuir.webtech.lab4.presentation.html.content.Suggestions;
import bsuir.webtech.lab4.presentation.html.content.SuggestionsAdmin;
import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/suggestions")
public class SuggestionsServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();
    private final View userView = new View(new Header(), new Suggestions(servicesAccessPoint.getRoomsService()));
    private final View adminView = new View(new Header(), new SuggestionsAdmin(servicesAccessPoint.getRoomsService()));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        resp.getWriter().write(Objects.equals(session.getUserRole(), User.UserRole.admin) ?
                adminView.get(session) : userView.get(session));
    }
}
