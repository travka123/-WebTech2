package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.business.Beans.Reservation;
import bsuir.webtech.lab4.business.Beans.User;

import java.sql.Date;
import java.util.List;

public class BookingService {

    public enum BookingError {
        OK,
        NOT_AUTHORIZED,
        INCORRECT_PARAMETERS,
        INCORRECT_DATE_PARAMETERS,
    }

    private final RoomsService roomsService;
    private final ReservationRepository reservationRepository;

    public BookingService(RoomsService roomsService, ReservationRepository reservationRepository) {
        this.roomsService = roomsService;
        this.reservationRepository = reservationRepository;
    }

    public BookingError canBook(UserSession session, int roomId) {
        String role = session.getUserRole();

        if (role.equals(User.UserRole.guest)) {
            return BookingError.NOT_AUTHORIZED;
        }

        if (!role.equals(User.UserRole.user)) {
            return BookingError.INCORRECT_PARAMETERS;
        }

        if (roomsService.getRoomById(roomId) == null) {
            return BookingError.INCORRECT_PARAMETERS;
        }

        return BookingError.OK;
    }

    public BookingError tryBook(UserSession session, int roomId, Date start, Date end) {
        BookingError error = canBook(session, roomId);
        if (error != BookingError.OK) {
            return error;
        }

        if (start.after(end) || start.before(new Date(System.currentTimeMillis()))) {
            return BookingError.INCORRECT_DATE_PARAMETERS;
        }

        reservationRepository.add(new Reservation(session.getUserId(), roomId, start, end));

        return error;
    }

    public List<Reservation> getReservationsOf(int userId) {
        return reservationRepository.getReservationsByUserId(userId);
    }
}
