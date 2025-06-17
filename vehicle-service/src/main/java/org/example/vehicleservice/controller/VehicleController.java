package org.example.vehicleservice.controller;

import org.example.vehicleservice.entity.Vehicle;
import org.example.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/register")
    public ResponseEntity<Vehicle> register(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.registerVehicle(vehicle));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Vehicle>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicle));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PutMapping("/{id}/enter")
    public ResponseEntity<Vehicle> simulateEntry(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.simulateEntry(id));
    }

    @PutMapping("/{id}/exit")
    public ResponseEntity<Vehicle> simulateExit(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.simulateExit(id));
    }
}

