package com.tsis.movie.dto;

public class Movie {
	//데이터를 받을 객체 생성
	//패키지에 각 디비 테이블개수로 생성
	private int movie_id;
	private String movie_title;
	private String movie_comment;
	private String movie_poster;
	
	public String getMovie_poster() {
		return movie_poster;
	}
	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_comment() {
		return movie_comment;
	}
	public void setMovie_comment(String movie_comment) {
		this.movie_comment = movie_comment;
	}
	
	
}
