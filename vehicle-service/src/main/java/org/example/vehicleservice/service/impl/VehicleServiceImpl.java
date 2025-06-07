package org.example.vehicleservice.service.impl;

import org.example.vehicleservice.entity.Vehicle;
import org.example.vehicleservice.repo.VehicleRepository;
import org.example.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicle.setInsideParking(false);
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getVehiclesByUserId(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }

    public Vehicle updateVehicle(Long id, Vehicle updated) {
        Vehicle existing = vehicleRepository.findById(id).orElseThrow();
        existing.setLicensePlate(updated.getLicensePlate());
        existing.setModel(updated.getModel());
        existing.setType(updated.getType());
        return vehicleRepository.save(existing);
    }

    public Vehicle simulateEntry(Long id) {
        Vehicle v = vehicleRepository.findById(id).orElseThrow();
        v.setInsideParking(true);
        return vehicleRepository.save(v);
    }

    public Vehicle simulateExit(Long id) {
        Vehicle v = vehicleRepository.findById(id).orElseThrow();
        v.setInsideParking(false);
        return vehicleRepository.save(v);
    }
}

