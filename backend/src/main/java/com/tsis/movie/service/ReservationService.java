package com.tsis.movie.service;

import java.util.List;

import com.tsis.movie.dto.Reservation;

public interface ReservationService {
	public int insertReservation(Reservation rese);
	public List<Reservation> getReservation(String phone);
}
