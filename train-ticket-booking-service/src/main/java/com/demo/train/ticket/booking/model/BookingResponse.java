package com.demo.train.ticket.booking.model;

public class BookingResponse {

	private Integer ticketId;

	private String passengerName;

	private String source;

	private String destination;

	private Double price;

	private String bookedBy;

	private Integer seatNo;

	private String departDate;

	private String status;

	public BookingResponse(Integer ticketId, String passengerName, String source, String destination, Double price,
			String bookedBy, Integer seatNo, String departDate, String status) {
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.bookedBy = bookedBy;
		this.seatNo = seatNo;
		this.departDate = departDate;
		this.status = status;
	}

	public BookingResponse() {
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
