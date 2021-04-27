package com.tsis.movie.service;

import java.util.List;

import com.tsis.movie.dto.Movie;
import com.tsis.movie.dto.Reservation;


public interface MovieService {
	public List<Movie> getMovies();
	public List<Movie> getMovieById(int id);
}
