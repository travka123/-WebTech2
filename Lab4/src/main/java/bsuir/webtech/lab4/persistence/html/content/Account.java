package bsuir.webtech.lab4.persistence.html.content;

import bsuir.webtech.lab4.business.Reservation;
import bsuir.webtech.lab4.business.Room;
import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.persistence.html.Content;

import java.util.Collections;
import java.util.List;

public class Account extends Content {

    private final UserSession session;
    private final ServicesAccessPoint servicesAccessPoint;

    public Account(UserSession session, ServicesAccessPoint servicesAccessPoint) {
        this.session = session;
        this.servicesAccessPoint = servicesAccessPoint;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get() {
        StringBuilder content = new StringBuilder();

        content.append("<div>");
        content.append("<h2>Здравствуйте, " + session.getUserName() + "</h2>");
        content.append("<h3>Ваши бронирования:</h3>");
        content.append("</div>");

        content.append("<div>");
        for (Reservation reservation : servicesAccessPoint.getBookingService().getReservationsOf(session.getUserId())) {
            appendReservationCard(
                    content, 
                    reservation, 
                    servicesAccessPoint.getRoomsService().getRoomById(reservation.getRoomId())
            );
        }
        content.append("</div>");

        return content.toString();
    }

    protected void appendReservationCard(StringBuilder content, Reservation reservation, Room room) {
        content.append("<div>");

        content.append("<div>");
        content.append(room.getName());
        content.append(room.getDescription());
        content.append("</div>");

        content.append("<div>");
        content.append("<span>Дата заезда:</span>");
        content.append(reservation.getStart());
        content.append("<span>Дата выезда:</span>");
        content.append(reservation.getEnd());
        content.append("</div>");

        content.append("</div>");
    }
}
