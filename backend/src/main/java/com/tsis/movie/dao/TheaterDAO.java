package com.tsis.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tsis.movie.dto.Theater;

@Mapper
public interface TheaterDAO {
	public List<Theater> getSeatsByTime(String id, String time);
}
