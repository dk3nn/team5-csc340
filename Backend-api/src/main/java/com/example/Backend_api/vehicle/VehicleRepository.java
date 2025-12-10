package com.example.Backend_api.vehicle;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByDealerId(Long dealerId);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findByMakeContainingIgnoreCaseAndSold(String make, boolean sold);
    List<Vehicle> findByModelContainingIgnoreCaseAndSoldAndDealerId(String make, boolean sold, Long dealerId);
    List<Vehicle> findByDealerIdAndSold(Long dealerId, Boolean sold);
    // List<Vehicle> findByDealerIdAndMakeMakeContainingIgnoreCase(Long dealerId, String make);

    @Query("SELECT count(v) FROM Vehicle v where v.dealer.id = :dealerId AND v.sold = :soldStatus")
    long countByDealerIdAndSoldStatus(Long dealerId, Boolean soldStatus);

    @Query("SELECT v FROM Vehicle v WHERE v.sold = :soldStatus")
    List<Vehicle> getVehiclesBySoldStatus(Boolean soldStatus);

    

}
