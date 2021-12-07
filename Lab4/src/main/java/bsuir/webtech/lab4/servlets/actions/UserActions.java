package bsuir.webtech.lab4.servlets.actions;

import bsuir.webtech.lab4.business.BookingService;
import bsuir.webtech.lab4.servlets.ServletSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class UserActions extends Actions {

    @Override
    public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        new ServletSession(req).clear();
        resp.sendRedirect("/");
    }

    @Override
    public String book(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String roomStr = req.getParameter("room");
        String starDateStr = req.getParameter("start");
        String endDateStr = req.getParameter("end");

        if ((roomStr == null) || (starDateStr == null) || (endDateStr == null)) {
            return "/404";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start, end;
        int room;

        try {
            room = Integer.parseInt(req.getParameter("room"));

            try {
                start = new Date(sdf.parse(req.getParameter("start")).getTime());
                end = new Date(sdf.parse(req.getParameter("end")).getTime());
            } catch (Exception ex) {
                resp.sendRedirect("/booking?room=" + room + "&err=dateErr");
                return null;
            }

        } catch (NumberFormatException ignored) {
            return "/404";
        }

        BookingService.BookingError bookingError = servicesAccessPoint.getBookingService().tryBook(
                new ServletSession(req),
                room,
                start,
                end
        );

        switch (bookingError) {
            case OK:
                resp.sendRedirect("/account");
                break;

            case INCORRECT_DATE_PARAMETERS:
                resp.sendRedirect("/booking?room=" + room + "&err=dateErr");
                break;

            default:
                return "/404";
        }

        return null;
    }
}
