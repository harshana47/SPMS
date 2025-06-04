package org.example.bookingservice.service;

import org.example.bookingservice.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getBookingsByUserId(Long userId);

    Booking saveBooking(Booking booking);
}
