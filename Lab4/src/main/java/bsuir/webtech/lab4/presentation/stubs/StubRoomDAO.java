package bsuir.webtech.lab4.presentation.stubs;

import bsuir.webtech.lab4.business.Room;
import bsuir.webtech.lab4.business.RoomsRepository;

import java.util.ArrayList;
import java.util.List;

public class StubRoomDAO extends RoomsRepository {

    private final List<Room> rooms = new ArrayList<>();

    public StubRoomDAO() {
        rooms.add(new Room(
                0,
                false,
                "name1",
                "description1",
                "/pictures/pic1",
                50,
                2
        ));
    }

    @Override
    public List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }

    @Override
    public Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getId() == roomId) {
                return  room;
            }
        }
        return null;
    }
}
