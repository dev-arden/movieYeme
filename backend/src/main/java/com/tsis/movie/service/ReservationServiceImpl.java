package com.tsis.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsis.movie.dao.ReservationDAO;
import com.tsis.movie.dto.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDAO reservationdao;
	
	@Override
	public int insertReservation(Reservation rese){
		return reservationdao.insertReservation(rese);
	}
	
	@Override
	public List<Reservation> getReservation(String phone){
		return reservationdao.getReservation(phone);
	}
}
