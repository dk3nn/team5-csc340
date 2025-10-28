package com.example.Backend_api.Review;

import com.example.Backend_api.Customer.customer;
import com.example.Backend_api.dealer.Dealer;
import com.example.Backend_api.vehicle.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCustomer(customer cust);
    List<Review> findByDealer(Dealer dealer);
    List<Review> findByVehicle(Vehicle vehicle);
}

