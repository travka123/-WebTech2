package bsuir.webtech.lab4.business;

import java.sql.Date;
import java.util.List;

public class BookingService {

    private final RoomsService roomsService;
    private final ReservationRepository reservationRepository;

    public BookingService(RoomsService roomsService, ReservationRepository reservationRepository) {
        this.roomsService = roomsService;
        this.reservationRepository = reservationRepository;
    }

    public BookingError canBook(UserSession session, int roomId) {
        UserRole role = session.getUserRole();

        if (role == UserRole.NONE) {
            return BookingError.NOT_AUTHORIZED;
        }

        if (role != UserRole.USER) {
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

        if (reservationRepository.tryReserv(new Reservation(session.getUserId(), roomId, start, end))) {
            return BookingError.OK;
        } else {
            return BookingError.ALREADY_BOOKED;
        }
    }

    public List<Reservation> getReservationsOf(int userId) {
        return reservationRepository.getReservationsByUserId(userId);
    }
}
