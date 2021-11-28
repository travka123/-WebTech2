package bsuir.webtech.lab4.business;

import java.util.List;

public abstract class ReservationRepository {
    public abstract boolean tryReserv(Reservation reservation);
    public abstract List<Reservation> getReservationsByUserId(int userId);
}
