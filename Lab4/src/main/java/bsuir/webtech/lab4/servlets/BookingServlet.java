package bsuir.webtech.lab4.servlets;

import bsuir.webtech.lab4.business.BookingError;
import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.persistence.html.content.Booking;
import bsuir.webtech.lab4.persistence.html.content.Header;
import bsuir.webtech.lab4.persistence.views.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    ServicesAccessPoint servicesAccessPoint = new ServicesAccessPoint();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserSession session = new ServletSession(req.getSession());
            int room = Integer.parseInt(req.getParameter("room"));

            BookingError error = servicesAccessPoint.getBookingService().canBook(session, room);

            if (error == BookingError.OK) {

                resp.getWriter().write(new View().get(
                        new Header(session.isAuthorized()),
                        new Booking(room)
                ));

            } else if (error == BookingError.NOT_AUTHORIZED) {

                resp.sendRedirect("/signin");

            } else {

                getServletContext().getRequestDispatcher("/404").forward(req, resp);

            }
        }
        catch (NumberFormatException e) {

            getServletContext().getRequestDispatcher("/404").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookingError bookingError = BookingError.INCORRECT_PARAMETERS;

        String roomStr = req.getParameter("room");
        String starDateStr = req.getParameter("start");
        String endDateStr = req.getParameter("end");

        if ((roomStr == null) || (starDateStr == null) || (endDateStr == null)) {
            getServletContext().getRequestDispatcher("/404").forward(req, resp);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start, end;
        int room;

        try {
            start = new Date(sdf.parse(req.getParameter("start")).getTime());
            end = new Date(sdf.parse(req.getParameter("end")).getTime());
            room = Integer.parseInt(req.getParameter("room"));

        } catch (ParseException | NumberFormatException ignored) {
            getServletContext().getRequestDispatcher("/404").forward(req, resp);
            return;
        }

        bookingError = servicesAccessPoint.getBookingService().tryBook(
                new ServletSession(req.getSession()),
                room,
                start,
                end
        );

        switch (bookingError) {
            case OK:
                resp.sendRedirect("/account");
                break;

            case INCORRECT_DATE_PARAMETERS:
                resp.sendRedirect(req.getRequestURL().append("?room=").append(room).append("&err=dateErr").toString());
                break;

            case INCORRECT_PARAMETERS:
            case NOT_AUTHORIZED:
                getServletContext().getRequestDispatcher("/404").forward(req, resp);
                break;
        }
    }
}
