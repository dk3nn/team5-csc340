package com.example.Backend_api.vehicle;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByDealerId(Long dealerId);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findByMakeContainingIgnoreCase(String make);
}
