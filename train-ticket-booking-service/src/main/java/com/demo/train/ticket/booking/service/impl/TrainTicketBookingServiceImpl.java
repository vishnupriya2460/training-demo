package com.demo.train.ticket.booking.service.impl;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.train.ticket.booking.entity.Booking;
import com.demo.train.ticket.booking.exception.TrainTicketBookingException;
import com.demo.train.ticket.booking.model.BookingRequest;
import com.demo.train.ticket.booking.model.BookingResponse;
import com.demo.train.ticket.booking.repository.TrainTicketBookingRepository;
import com.demo.train.ticket.booking.service.TrainTicketBookingService;

@Service
public class TrainTicketBookingServiceImpl implements TrainTicketBookingService {

	private static final Logger log = LoggerFactory.getLogger(TrainTicketBookingServiceImpl.class);

	@Autowired
	TrainTicketBookingRepository trainTicketBookingRepository;

	Map<Integer, String> tickets = new HashMap<Integer, String>() {
		{
			put(1, "WL");
			put(2, "CNF");
			put(3, "CNF");
			put(4, "WL");
			put(5, "WL");
			put(6, "CNF");
			put(7, "WL");
			put(8, "CNF");
		}
	};

	Map<Integer, Double> ticketsPrice = new HashMap<Integer, Double>() {
		{
			put(1, 100.0);
			put(2, 100.0);
			put(3, 100.0);
			put(4, 100.0);
			put(5, 323.0);
			put(6, 323.0);
			put(7, 323.0);
			put(8, 323.0);
		}
	};

	@Autowired
	TrainTicketBookingRepository userRepository;

	@Override
	public BookingResponse bookTicket(BookingRequest request) {
		if (tickets.containsKey(request.getSeatNo())) {
			Booking booking = new Booking();
			booking.setBookedBy(request.getDepartDate());
			booking.setDepartDate(request.getDepartDate());
			booking.setPassengerName(request.getPassengerName());
			booking.setSeatNo(request.getSeatNo());
			booking.setSource(request.getSource());
			booking.setDestination(request.getDestination());
			booking.setPrice(ticketsPrice.get(request.getSeatNo()));
			booking.setTicketId(new SecureRandom().nextInt(999999999));
			booking.setStatus(tickets.get(request.getSeatNo()));
			booking = trainTicketBookingRepository.save(booking);

			BookingResponse response = new BookingResponse(booking.getTicketId(), booking.getPassengerName(),
					booking.getSource(), booking.getDestination(), booking.getPrice(), booking.getBookedBy(),
					booking.getSeatNo(), booking.getDepartDate(), booking.getStatus());

			return response;
		}
		throw new TrainTicketBookingException("No Tickets Available");
	}

	@Override
	public List<BookingResponse> getAllBookings() {
		return trainTicketBookingRepository.findAll().stream()
				.map(booking -> new BookingResponse(booking.getTicketId(), booking.getPassengerName(),
						booking.getSource(), booking.getDestination(), booking.getPrice(), booking.getBookedBy(),
						booking.getSeatNo(), booking.getDepartDate(), booking.getStatus()))
				.collect(Collectors.toList());
	}

	@Override
	public BookingResponse getTicket(Integer ticketNo) {
		Booking booking = trainTicketBookingRepository.findByTicketId(ticketNo);
		if (booking != null) {
			BookingResponse response = new BookingResponse(booking.getTicketId(), booking.getPassengerName(),
					booking.getSource(), booking.getDestination(), booking.getPrice(), booking.getBookedBy(),
					booking.getSeatNo(), booking.getDepartDate(), booking.getStatus());
			return response;
		}
		throw new TrainTicketBookingException("Ticket Not Found");
	}
}
