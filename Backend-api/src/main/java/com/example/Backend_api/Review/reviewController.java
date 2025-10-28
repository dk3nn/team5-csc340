package com.example.Backend_api.Review;

import com.example.Backend_api.Customer.customerService;
import com.example.Backend_api.dealer.dealerService;
import com.example.Backend_api.vehicle.vehicleService;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.annotations.ReviewBeforeRelease;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class reviewController {

    private final reviewService reviewService;
    private final customerService customerService;
    private final dealerService dealerService;
    private final vehicleService vehicleService;

    @PostMapping
    public ResponseEntity<review> createReview(@Validated@RequestBody review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @PostMapping("/{rId}/response")
    public ResponseEntity<review> addResponse(@PathVariable Long rId, @RequestBody String response){
        return ResponseEntity.ok(reviewService.addResponse(rId, response));
    }

    @DeleteMapping("/{rId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long rId){
        reviewService.deleteReview(rId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dealer/{id}")
    public ResponseEntity<List<review>> getReviewsByDealer(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getReviewsByDealer(DealerService.getDealerById(id)));
    }

    @GetMapping("/customer/{cId}")
    public ResponseEntity<List<review>> getReviewsByCustomer(@PathVariable Long cId){
        return ResponseEntity.ok(reviewService.getReviewsByCustomer(customerService.getCustomerById(cId)));
    }

    @GetMapping("/dealer/{id}/ratings")
    public ResponseEntity<Map<String, Double>> getAverageRatingForDealer(@PathVariable Long id){
        Double avgRating = reviewService.getAverageRatingForDealer(DealerService.getDealerById(id));
        Map<String, Double> ratings = new HashMap<>();
        ratings.put("averageRating", avgRating);
        return ResponseEntity.ok(ratings);

    }

    
}
    