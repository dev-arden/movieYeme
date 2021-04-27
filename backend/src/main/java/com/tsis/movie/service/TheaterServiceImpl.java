package com.tsis.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsis.movie.dao.TheaterDAO;
import com.tsis.movie.dao.YemeDAO;
import com.tsis.movie.dto.Theater;
import com.tsis.movie.dto.Yeme;

@Service
public class TheaterServiceImpl implements TheaterService{
	@Autowired
	private TheaterDAO theaterdao;
	@Autowired
	private YemeDAO yemedao;

	@Override
	public List<Theater> getSeatsByTime(String id, String time) {
		return theaterdao.getSeatsByTime(id, time);
	}
	
	@Override
	public List<Yeme> getYeme(String id, String time) {
		return yemedao.getYeme(id, time);
	}
}
