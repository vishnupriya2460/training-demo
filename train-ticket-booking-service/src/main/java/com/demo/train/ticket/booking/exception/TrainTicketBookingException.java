package com.demo.train.ticket.booking.exception;

public class TrainTicketBookingException extends RuntimeException {

	private static final long serialVersionUID = 3291473686813059267L;

	public String message;

	public TrainTicketBookingException() {
		super();
	}

	public TrainTicketBookingException(String message) {
		super(message);
		this.message = message;
	}
}
