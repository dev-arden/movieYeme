package com.tsis.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tsis.movie.dto.Reservation;

@Mapper
public interface ReservationDAO {
	public int insertReservation(Reservation rese);
	public List<Reservation> getReservation(String phone);
}
