package com.tsis.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsis.movie.dao.MovieDAO;
import com.tsis.movie.dto.Movie;
import com.tsis.movie.dto.Reservation;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDAO moviedao;
	
	@Override
	public List<Movie> getMovies() {		
		return moviedao.getMovies();
	}
	

	@Override
	public List<Movie> getMovieById(int id) {
		return moviedao.getMovieById(id);
	}	
}