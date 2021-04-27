package com.tsis.movie.service;

import java.util.List;

import com.tsis.movie.dto.Theater;
import com.tsis.movie.dto.Yeme;

public interface TheaterService {
	public List<Theater> getSeatsByTime(String id, String time);
	public List<Yeme> getYeme(String id, String time);
}
