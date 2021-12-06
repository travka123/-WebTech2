package bsuir.webtech.lab4.presentation.html.content;

import bsuir.webtech.lab4.business.Beans.Room;
import bsuir.webtech.lab4.business.RoomsService;
import bsuir.webtech.lab4.business.UserSession;
import bsuir.webtech.lab4.presentation.html.Content;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Suggestions extends Content {
    protected final RoomsService roomsService;

    public Suggestions(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @Override
    public List<String> getStyles() {
        return Collections.emptyList();
    }

    @Override
    public String get(UserSession session, ResourceBundle bundle) {
        StringBuilder content = new StringBuilder();

        for (Room room : getRooms()) {
            appendRoomCardContent(content, room);
        }

        return content.toString();
    }

    protected List<Room> getRooms() {
        return roomsService.getVisibleRooms();
    }

    protected void appendRoomCardContent(StringBuilder content, Room room) {
        content.append("<div>");

        content.append("<div>");

        content.append("<div>");
        content.append(room.getName());
        appendRoomCardOptions(content, room);
        content.append("</div>");

        content.append("<div>");
        content.append(room.getDescription());
        content.append("</div>");

        content.append("</div>");

        content.append("<div>");
        content.append("<img src=\"" + room.getPicture() + "\">");
        content.append("</div>");

        content.append("</div>");
    }

    protected void appendRoomCardOptions(StringBuilder content, Room room) {
        content.append("<a href=\"/booking?room=" + room.getId() + "\">" + "Забронировать номер" + "</a>");
    }
}
