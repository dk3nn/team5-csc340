package com.example.Backend_api.Review;

import com.example.Backend_api.Customer.customer;
import com.example.Backend_api.dealer.Dealer;
import com.example.Backend_api.vehicle.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reviewRepository extends JpaRepository<review, Long> {
    List<review> findByCustomer(customer cust);
    List<review> findByDealer(Dealer dealer);
}

