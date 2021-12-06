package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.business.Beans.Reservation;

import java.util.List;

public abstract class ReservationRepository {
    public abstract void add(Reservation reservation);
    public abstract List<Reservation> getReservationsByUserId(int userId);
}
