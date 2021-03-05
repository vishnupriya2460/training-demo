package com.demo.train.ticket.booking.service.impl;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.train.ticket.booking.entity.Booking;
import com.demo.train.ticket.booking.exception.TrainTicketBookingException;
import com.demo.train.ticket.booking.model.BookingResponse;
import com.demo.train.ticket.booking.repository.TrainTicketBookingRepository;

@SpringBootTest
public class TrainTicketBookingServiceImplTest {

	@Mock
	TrainTicketBookingRepository trainTicketBookingRepository;

	@InjectMocks
	TrainTicketBookingServiceImpl trainTicketBookingServiceImplMcok;

	@Test
	public void getTicket() {
		when(trainTicketBookingRepository.findByTicketId(1))
				.thenReturn(new Booking(1L, 1, "demo", "demo", "demo", 152.0, "demo", 1, "demo", "demo"));
		BookingResponse res = trainTicketBookingServiceImplMcok.getTicket(1);
		Assertions.assertEquals(1, res.getTicketId());
	}

	@Test
	public void getTickeException() {
		when(trainTicketBookingRepository.findByTicketId(1)).thenReturn(null);

		Assertions.assertThrows(TrainTicketBookingException.class, () -> {
			trainTicketBookingServiceImplMcok.getTicket(1);
		});
	}
}
