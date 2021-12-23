package bsuir.webtech.lab4.servlets.pages;

import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.presentation.html.content.Header;
import bsuir.webtech.lab4.presentation.html.content.SignUp;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletSession session = new ServletSession(req);

        if (session.isAuthorized()) {
            resp.sendRedirect("/");
        }

        resp.getWriter().write(new View(new Header(), new SignUp(req.getParameter("err") != null)).get(session));
    }
}
