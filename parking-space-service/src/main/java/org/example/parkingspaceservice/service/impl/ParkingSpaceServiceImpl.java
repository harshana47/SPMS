package org.example.parkingspaceservice.service.impl;

import org.example.parkingspaceservice.entity.ParkingSpace;
import org.example.parkingspaceservice.repo.ParkingSpaceRepository;
import org.example.parkingspaceservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository repository;

    public ParkingSpace addSpace(ParkingSpace space) {
        return repository.save(space);
    }

    public List<ParkingSpace> getAllSpaces() {
        return repository.findAll();
    }

    public List<ParkingSpace> getAvailableSpaces() {
        return repository.findByAvailableTrue();
    }

    public ParkingSpace reserveSpace(Long id) {
        ParkingSpace space = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Space not found"));
        space.setAvailable(false);
        space.setOccupied(true);
        return repository.save(space);
    }

    public ParkingSpace releaseSpace(Long id) {
        ParkingSpace space = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Space not found"));
        space.setAvailable(true);
        space.setOccupied(false);
        return repository.save(space);
    }
}

