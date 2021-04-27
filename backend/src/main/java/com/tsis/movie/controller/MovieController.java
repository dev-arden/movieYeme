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
import org.springframework.web.bind.annotation.RestController;

import com.tsis.movie.dto.Movie;
import com.tsis.movie.dto.Reservation;
import com.tsis.movie.service.MovieService;

import io.swagger.annotations.ApiOperation;


//http://localhost:8080/swagger-ui.html#/
@CrossOrigin(origins = { "http://localhost:8080" }, maxAge = 6000)
@RestController
@RequestMapping("/movie")
public class MovieController {
   private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    
   @Autowired
   private MovieService movieservice;

   @ApiOperation(value = "모든 상영 목록", notes = "모든 영화 목록을 불러온다")
   @GetMapping("/movies")
   public ResponseEntity<List<Movie>> getAllMoives() throws Exception {
      return new ResponseEntity<List<Movie>>(movieservice.getMovies(), HttpStatus.OK);
   } 
   
   
   @ApiOperation(value = "Movie테이블과 Theater테이블", notes = "특정 영화의 정보를 불러온다")
   @GetMapping("/showmovie/{id}")
   public ResponseEntity<List<Movie>> getMovieById(@PathVariable int id) throws Exception {
      return new ResponseEntity<List<Movie>> (movieservice.getMovieById(id), HttpStatus.OK);
   } 
   
}