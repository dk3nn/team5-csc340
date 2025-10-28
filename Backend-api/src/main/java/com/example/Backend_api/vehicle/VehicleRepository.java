package com.example.Backend_api.vehicle;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByDealerId(Long dealerId);
    List<Vehicle> findByMakeContainingIgnoreCase(String make);
}
