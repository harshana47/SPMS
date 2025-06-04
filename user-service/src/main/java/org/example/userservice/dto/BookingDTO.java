package org.example.userservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;
    private String parkingSpace;
    private String vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
}
