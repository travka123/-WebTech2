package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.business.Beans.Reservation;
import bsuir.webtech.lab4.business.Beans.Room;
import bsuir.webtech.lab4.business.ServicesAccessPoint;
import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Account extends Content {

    private final ServicesAccessPoint servicesAccessPoint;

    public Account(ServicesAccessPoint servicesAccessPoint) {
        this.servicesAccessPoint = servicesAccessPoint;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
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
