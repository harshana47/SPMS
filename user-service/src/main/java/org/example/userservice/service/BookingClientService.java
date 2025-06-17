package org.example.userservice.service;

import org.example.userservice.dto.BookingDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookingClientService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<BookingDTO> getBookingHistory(Long userId) {
        String url = "http://localhost:8082/users/" + userId + "/bookings";
        BookingDTO[] bookings = restTemplate.getForObject(url, BookingDTO[].class);
        return Arrays.asList(bookings);
    }
}
