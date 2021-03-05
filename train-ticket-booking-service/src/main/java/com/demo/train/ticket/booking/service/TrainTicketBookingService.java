package com.demo.train.ticket.booking.service;

import java.util.List;

import com.demo.train.ticket.booking.model.BookingRequest;
import com.demo.train.ticket.booking.model.BookingResponse;

public interface TrainTicketBookingService {

	BookingResponse bookTicket(BookingRequest request);

	List<BookingResponse> getAllBookings();

	BookingResponse getTicket(Integer ticketNo);
}
