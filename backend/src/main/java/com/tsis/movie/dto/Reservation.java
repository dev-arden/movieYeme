package com.tsis.movie.dto;

public class Reservation {
	private int reservation_id;
	private String phone_number;
	private String movie_title;
	private int ticket_count;
	private String theater_id;
	private String play_time;
	private Long row;
	private Long col;
	
	public Long getCol() {
		return col;
	}
	public void setCol(Long col) {
		this.col = col;
	}
	private String seats;
	


	public String getSeats() {
		return seats;
	}
	public Long getRow() {
		return row;
	}
	public void setRow(Long long1) {
		this.row = long1;
	}
	
	
	public void setSeats(String seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservation_id + ", phone_number=" + phone_number + ", movie_title="
				+ movie_title + ", ticket_count=" + ticket_count + ", theater_id=" + theater_id + ", play_time="
				+ play_time + ", row=" + row + ", col=" + col + ", seats=" + seats + "]";
	}
	
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public int getTicket_count() {
		return ticket_count;
	}
	public void setTicket_count(int ticket_count) {
		this.ticket_count = ticket_count;
	}
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
}
