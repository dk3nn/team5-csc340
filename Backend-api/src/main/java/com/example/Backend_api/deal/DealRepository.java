package com.example.Backend_api.deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    List<Deal> findByVehicle_Dealer_id(Long dealerId);
    Deal findByVehicleId(Long vehicleId);
} 
