package com.tsis.movie.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsis.movie.dto.Movie;
import com.tsis.movie.dto.Reservation;
import com.tsis.movie.service.ReservationService;

import io.swagger.annotations.ApiOperation;



@CrossOrigin(origins = "*", maxAge = 6000) //{"http://localhost:8080"}
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService reservationservice;

	@ApiOperation(value = "insert", notes = "파라미터들을 다 넘긴다")
	@PostMapping("/insert")
	public int insertReservation(@Param("Reservation") Reservation rese) throws Exception {	
		JSONParser parser = new JSONParser();
		JSONObject selectedseats = (JSONObject) parser.parse(rese.getSeats());
		Iterator<String> keys = (selectedseats.keySet()).iterator();
		while(keys.hasNext()) {
			JSONObject selectedseat = (JSONObject) selectedseats.get(keys.next());
			System.out.println(selectedseat.get("row") + "/" + selectedseat.get("column"));
			rese.setRow((Long)selectedseat.get("row"));
			rese.setCol((Long)selectedseat.get("column"));
			System.out.println(rese);
			reservationservice.insertReservation(rese);
		}
		return 1;
	} 
	
   @ApiOperation(value = "예약 조회", notes = "예매 내역 목록을 불러온다")
   @GetMapping("/checkres")
   public ResponseEntity<List<Reservation>> getReservation(String phone) throws Exception {
      return new ResponseEntity<List<Reservation>>(reservationservice.getReservation(phone), HttpStatus.OK);
   } 

}