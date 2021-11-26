package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.persistence.html.content.Header;
import bsuir.webtech.lab4.persistence.html.content.NotFound;
import bsuir.webtech.lab4.persistence.views.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/404")
public class NotFoundServlet extends HttpServlet {

    private final View view = new View();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(view.get(new Header(), new NotFound()));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
