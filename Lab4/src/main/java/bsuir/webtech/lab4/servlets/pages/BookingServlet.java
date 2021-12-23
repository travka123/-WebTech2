package bsuir.webtech.lab4.servlets.pages;

import bsuir.webtech.lab4.business.Beans.User;
import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.View;
import bsuir.webtech.lab4.presentation.html.content.Booking;
import bsuir.webtech.lab4.presentation.html.content.Header;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSession session = new ServletSession(req);

        if (Objects.equals(session.getUserRole(), User.UserRole.user)) {

            try {
                resp.getWriter().write(new View(new Header(), new Booking(
                        Integer.parseInt(req.getParameter("room")),
                        req.getParameter("err") != null
                )).get(session));
            }
            catch (Exception ignore) {
                getServletContext().getRequestDispatcher("/404").forward(req, resp);
            }

        } else {
            resp.sendRedirect("/signin");
        }
    }
}
