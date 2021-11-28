package bsuir.webtech.lab4.persistence.html.content;

import bsuir.webtech.lab4.business.Room;
import bsuir.webtech.lab4.business.RoomsService;

import java.util.List;

public class SuggestionsAdmin extends Suggestions{

    public SuggestionsAdmin(RoomsService roomsService) {
        super(roomsService);
    }

    @Override
    protected List<Room> getRooms() {
        return roomsService.getAllRooms();
    }

    @Override
    protected void appendRoomCardOptions(StringBuilder content, Room room) {
        if (room.isHidden()) {
            content.append("<a href=\"/admin/?action=show&room=" + room.getId() + "\">" + "Разрешить бронировать" + "</a>");
        }
        else {
            content.append("<a href=\"/admin/?action=hide&room=" + room.getId() + "\">" + "Запретить бронировать" + "</a>");
        }
    }

    @Override
    protected void appendRoomCardContent(StringBuilder content, Room room) {
        super.appendRoomCardContent(content, room);
        if (room.isHidden()) {
            content.append("Бронирование номера запрещено");
        }
        else {
            content.append("Бронирование номера разрешено");
        }
    }
}
