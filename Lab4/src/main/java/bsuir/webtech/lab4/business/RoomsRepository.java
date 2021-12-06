package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.business.Beans.Room;

import java.util.List;

public abstract class RoomsRepository {
    public abstract List<Room> getRooms();
    public abstract List<Room> getVisibleRooms();
    public abstract Room getRoomById(int roomId);
    public abstract void save(Room room);
}
