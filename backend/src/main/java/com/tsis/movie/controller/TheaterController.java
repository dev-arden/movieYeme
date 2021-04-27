package com.tsis.movie.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsis.movie.dto.Theater;
import com.tsis.movie.dto.Yeme;
import com.tsis.movie.service.TheaterService;

import io.swagger.annotations.ApiOperation;



//http://localhost:8080/swagger-ui.html#/
@CrossOrigin(origins = { "http://localhost:8080" }, maxAge = 6000)
@RestController
@RequestMapping("/theater")
public class TheaterController {
 private static final Logger logger = LoggerFactory.getLogger(TheaterController.class);
  
 @Autowired
 private TheaterService theaterservice;

 @ApiOperation(value = "좌석", notes = "각 상영관의 시간대에 맞는 좌석을 불러온다")
 @GetMapping("/timeseats/{id}/{time:.+}")
 public ResponseEntity<List<Theater>> getSeatsByTime(@PathVariable String id, String time) throws Exception {
	 System.out.println("id >>> " + id + " / time >>> " + time);
	 return new ResponseEntity<List<Theater>>(theaterservice.getSeatsByTime(id, time), HttpStatus.OK);
 } 
 
 @ApiOperation(value = "좌석과 예약좌석 확인", notes = "각 상영관의 시간대에 맞는 좌석을 불러온다")
 @GetMapping("/getseats")
 public ResponseEntity<List<Yeme>> getYeme(@RequestParam(value = "id") String id, @RequestParam(value = "time") String time) throws Exception {
	 System.out.println("id >>> " + id + " / time >>> " + time);
	 return new ResponseEntity<List<Yeme>>(theaterservice.getYeme(id, time), HttpStatus.OK);
 } 
}