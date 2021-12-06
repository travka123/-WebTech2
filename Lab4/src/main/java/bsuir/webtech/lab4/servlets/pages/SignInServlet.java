package bsuir.webtech.lab4.servlets.pages;

import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.presentation.html.Content;
import bsuir.webtech.lab4.presentation.html.content.Header;
import bsuir.webtech.lab4.presentation.html.content.SignIn;
import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    private final ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        if (session.isAuthorized()) {
            resp.sendRedirect("/");
        }

        Content content = req.getParameter("err") == null ?
                new SignIn(false, servicesAccessPoint.getAuthorizationService().createSalt()) :
                new SignIn(true, servicesAccessPoint.getAuthorizationService().createSalt());

        resp.getWriter().write(new View(new Header(), content).get(session));
    }
}
