package org.example.parkingspaceservice.service;

import org.example.parkingspaceservice.entity.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {
    ParkingSpace addSpace(ParkingSpace space);

    List<ParkingSpace> getAllSpaces();

    List<ParkingSpace> getAvailableSpaces();

    ParkingSpace reserveSpace(Long id);

    ParkingSpace releaseSpace(Long id);
}
