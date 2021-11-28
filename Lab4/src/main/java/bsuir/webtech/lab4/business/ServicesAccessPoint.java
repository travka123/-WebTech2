package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.presentation.stubs.StubAccountRepository;
import bsuir.webtech.lab4.presentation.stubs.StubReservationDAO;
import bsuir.webtech.lab4.presentation.stubs.StubRoomDAO;

public class ServicesAccessPoint {
    private static final AuthorizationService authorizationService = new AuthorizationService(
            new StubAccountRepository(),
            new SaltShaker(60000)
    );

    private static final RoomsService roomsService = new RoomsService(
            new StubRoomDAO()
    );

    private static final BookingService bookingService = new BookingService(
            roomsService,
            new StubReservationDAO()
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
