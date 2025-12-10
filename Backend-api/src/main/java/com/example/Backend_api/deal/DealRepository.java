package com.example.Backend_api.deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    List<Deal> findByVehicle_Dealer_id(Long dealerId);
    Deal findByVehicleId(Long vehicleId);

    @Query("SELECT COALESCE(SUM(d.dealAmount - v.cost), 0) FROM Deal d JOIN d.vehicle v JOIN v.dealer dealer WHERE dealer.id = :dealerId")
    Double calculateTotalProfitByDealerId(Long dealerId);

    @Query("SELECT COALESCE(SUM(d.dealAmount - v.cost), 0) FROM Deal d JOIN d.vehicle v JOIN v.dealer dealer WHERE dealer.id = :dealerId and d.dealDate >= :startDate")
    Double calculateTotalSalesByDealerIdAndDateRange(Long dealerId, String startDate);

    @Query("SELECT count(d) FROM Deal d JOIN d.vehicle v JOIN v.dealer dealer WHERE dealer.id = :dealerId and d.dealDate >= :startDate")
    Long countDealsByDealerIdAndDateRange(Long dealerId, String startDate);
} 
