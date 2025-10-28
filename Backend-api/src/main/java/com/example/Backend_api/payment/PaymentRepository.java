package com.example.Backend_api.payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByDealId(Long dealId);
    List<Payment> findByDeal_Vehicle_Dealer_id(Long dealerId);
} 
