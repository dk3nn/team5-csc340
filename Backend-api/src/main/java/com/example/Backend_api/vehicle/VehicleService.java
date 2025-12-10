package com.example.Backend_api.vehicle;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updatVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        existingVehicle.setMake(vehicle.getMake());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setColor(vehicle.getColor());
        existingVehicle.setVin(vehicle.getVin());
        existingVehicle.setPrice(vehicle.getPrice());
        existingVehicle.setCost(vehicle.getCost());
        existingVehicle.setMileage(vehicle.getMileage());
        existingVehicle.setTransmission(vehicle.getTransmission());
        existingVehicle.setDescription(vehicle.getDescription()); 
        existingVehicle.setFuelType(vehicle.getFuelType());
        existingVehicle.setBodyType(vehicle.getBodyType());
        existingVehicle.setNumberOfDoors(vehicle.getNumberOfDoors());
        existingVehicle.setDriveType(vehicle.getDriveType());
        existingVehicle.setEngineSize(vehicle.getEngineSize());
        existingVehicle.setSold(vehicle.getSold());
        existingVehicle.setDealer(vehicle.getDealer());
        existingVehicle.setImageUrl(vehicle.getImageUrl());   
        
        return vehicleRepository.save(existingVehicle);
    }

    public void deleteVehicle(Long id) {
        if(!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> getVehiclesByDealerId(Long dealerId) {
        return vehicleRepository.findByDealerId(dealerId);
    }

    public void markVehicleAsSold(Long vehicleId) {
        Vehicle vehicle = getVehicleById(vehicleId);
        vehicle.setSold(true);
        vehicleRepository.save(vehicle);
    }

    public Long countVehiclesByDealerIdAndSoldStatus(Long dealerId, Boolean soldStatus) {
        return vehicleRepository.countByDealerIdAndSoldStatus(dealerId, soldStatus);
    }

    public List<Vehicle> getVehiclesBySoldStatus(Boolean soldStatus) {
        return vehicleRepository.getVehiclesBySoldStatus(soldStatus);
    }

    public List<Vehicle> findByMakeContainingIgnoreCaseAndUnSold(String make, boolean sold) {
        return vehicleRepository.findByMakeContainingIgnoreCaseAndSold(make, sold);
    }

    public List<Vehicle> findByModelContainingIgnoreCaseAndSoldAndDealerId(String make, boolean sold, Long dealerId) {
        return vehicleRepository.findByModelContainingIgnoreCaseAndSoldAndDealerId(make, sold, dealerId);
    }

    public List<Vehicle> findByDealerIdAndSold(Long dealerId, Boolean sold) {
        return vehicleRepository.findByDealerIdAndSold(dealerId, sold);
    }

    public List<Vehicle> findByDealerIdAndMakeMakeContainingIgnoreCase(Long dealerId, String make) {
        return vehicleRepository.findByDealerIdAndMakeMakeContainingIgnoreCase(dealerId, make);
    }

}
