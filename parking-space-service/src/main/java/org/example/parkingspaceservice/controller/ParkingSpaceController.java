package org.example.parkingspaceservice.controller;

import org.example.parkingspaceservice.entity.ParkingSpace;
import org.example.parkingspaceservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-spaces")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService service;

    @PostMapping("/add")
    public ResponseEntity<ParkingSpace> add(@RequestBody ParkingSpace space) {
        return ResponseEntity.ok(service.addSpace(space));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingSpace>> all() {
        return ResponseEntity.ok(service.getAllSpaces());
    }

    @GetMapping("/available")
    public ResponseEntity<List<ParkingSpace>> available() {
        return ResponseEntity.ok(service.getAvailableSpaces());
    }

    @PutMapping("/reserve/{id}")
    public ResponseEntity<ParkingSpace> reserve(@PathVariable Long id) {
        return ResponseEntity.ok(service.reserveSpace(id));
    }

    @PutMapping("/release/{id}")
    public ResponseEntity<ParkingSpace> release(@PathVariable Long id) {
        return ResponseEntity.ok(service.releaseSpace(id));
    }
}

