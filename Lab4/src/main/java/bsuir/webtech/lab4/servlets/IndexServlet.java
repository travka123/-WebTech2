package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.persistence.html.content.Header;
import bsuir.webtech.lab4.persistence.html.content.Welcome;
import bsuir.webtech.lab4.persistence.views.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    private final View view = new View();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(view.get(new Header(new ServletSession(req.getSession()).isAuthorized()), new Welcome()));
    }
}
