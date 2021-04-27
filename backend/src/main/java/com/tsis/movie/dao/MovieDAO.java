package com.tsis.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tsis.movie.dto.Movie;

@Mapper
public interface MovieDAO {
	public List<Movie> getMovies();
	public List<Movie> getMovieById(int id);
}
