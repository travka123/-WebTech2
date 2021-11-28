package bsuir.webtech.lab4.business;

import java.util.List;

public abstract class RoomsRepository {
    public abstract List<Room> getRooms();
    public abstract Room getRoomById(int roomId);
}
