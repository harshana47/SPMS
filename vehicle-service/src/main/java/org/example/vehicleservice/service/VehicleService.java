package org.example.vehicleservice.service;

import org.example.vehicleservice.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle registerVehicle(Vehicle vehicle);

    List<Vehicle> getVehiclesByUserId(Long userId);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    Vehicle simulateEntry(Long id);

    Vehicle simulateExit(Long id);
}
