package bsuir.webtech.lab4.persistence.stubs;

import bsuir.webtech.lab4.business.Reservation;
import bsuir.webtech.lab4.business.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

public class StubReservationDAO extends ReservationRepository {

    List<Reservation> reservations = new ArrayList<>();

    @Override
    public boolean tryReserv(Reservation reservation) {
        reservations.add(reservation);
        return true;
    }

    @Override
    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getUserId() == userId) {
                userReservations.add(reservation);
            }
        }
        return userReservations;
    }
}
