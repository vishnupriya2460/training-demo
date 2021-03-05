package com.demo.train.ticket.booking.model;

public class BookingRequest {

	private String passengerName;

	private String source;

	private String destination;

	private Integer seatNo;

	private String departDate;

	public BookingRequest() {
	}

	public BookingRequest(String passengerName, String source, String destination, Integer seatNo,
			String departDate) {
		this.passengerName = passengerName;
		this.source = source;
		this.destination = destination;
		this.seatNo = seatNo;
		this.departDate = departDate;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

}
