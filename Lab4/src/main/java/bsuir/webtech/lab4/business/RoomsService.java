package bsuir.webtech.lab4.business;

import java.util.ArrayList;
import java.util.List;

public class RoomsService {

    private final RoomsRepository roomsRepository;

    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public List<Room> getAllRooms() {
        return roomsRepository.getRooms();
    }

    public List<Room> getVisibleRooms() {
        List<Room> visibleRooms = new ArrayList<>();

        for (Room room : roomsRepository.getRooms()) {
            if (!room.isHidden()) {
                visibleRooms.add(room);
            }
        }

        return visibleRooms;
    }

    public Room getRoomById(int roomId) {
        return roomsRepository.getRoomById(roomId);
    }
}
