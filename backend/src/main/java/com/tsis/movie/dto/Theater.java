package com.tsis.movie.dto;

public class Theater {
	private String theater_id;
	private String play_time;
	private String movie_title;
	private int all_seats;
	private int rows;
	private int cols;
	private int movie_id;
	private int counted;
	
	public int getCounted() {
		return counted;
	}
	public void setCounted(int counted) {
		this.counted = counted;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String price;
	
	public String getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}
	public String getPlay_time() {
		return play_time;
	}
	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public int getAll_seats() {
		return all_seats;
	}
	public void setAll_seats(int all_seats) {
		this.all_seats = all_seats;
	}
}
