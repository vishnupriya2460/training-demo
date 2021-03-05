package com.demo.train.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.train.ticket.booking.entity.Booking;

public interface TrainTicketBookingRepository extends JpaRepository<Booking, Long> {

	Booking findByTicketId(Integer ticketId);
}
