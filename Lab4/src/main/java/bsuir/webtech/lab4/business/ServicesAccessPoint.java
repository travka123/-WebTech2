package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.persistence.sql.DatabaseController;
import bsuir.webtech.lab4.persistence.sql.SQLReservationDAO;
import bsuir.webtech.lab4.persistence.sql.SQLRoomDAO;
import bsuir.webtech.lab4.persistence.sql.SQLUserDAO;

public class ServicesAccessPoint {

    private static final DatabaseController databaseController = new DatabaseController(
            "jdbc:mysql://localhost/hotel?serverTimezone=Europe/Moscow&useSSL=false",
            "root",
            "admin"
    );

    private static final AuthorizationService authorizationService = new AuthorizationService(
            new SQLUserDAO(databaseController),
            new SaltShaker(60000)
    );

    private static final RoomsService roomsService = new RoomsService(
            new SQLRoomDAO(databaseController)
    );

    private static final BookingService bookingService = new BookingService(
            roomsService,
            new SQLReservationDAO(databaseController)
    );

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public RoomsService getRoomsService() {
        return roomsService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }
}
