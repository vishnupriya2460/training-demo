package com.demo.train.ticket.booking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.train.ticket.booking.model.BookingRequest;
import com.demo.train.ticket.booking.model.BookingResponse;
import com.demo.train.ticket.booking.service.TrainTicketBookingService;

@RestController
@RequestMapping("/api/train-ticket-booking")
public class TrainTicketBookingController {

	private static final Logger log = LoggerFactory.getLogger(TrainTicketBookingController.class);

	@Autowired
	private TrainTicketBookingService trainTicketBookingService;

	@PostMapping(value = "/book-ticket")
	public ResponseEntity<BookingResponse> bookTicket(@RequestBody BookingRequest bookingRequest) {
		BookingResponse response = trainTicketBookingService.bookTicket(bookingRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get-ticket/{ticketNo}")
	public ResponseEntity<BookingResponse> getTicket(@PathVariable("ticketNo") Integer ticketNo) {
		BookingResponse response = trainTicketBookingService.getTicket(ticketNo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get-bookings")
	public ResponseEntity<List<BookingResponse>> getAllTickets() {
		List<BookingResponse> response = trainTicketBookingService.getAllBookings();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}