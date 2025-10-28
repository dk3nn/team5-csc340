package com.example.Backend_api.Review;

import com.example.Backend_api.Customer.customerService;
import com.example.Backend_api.dealer.dealerService;
import com.example.Backend_api.vehicle.vehicleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Review> createReview(@Valid @RequestBody Review review){
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @postMapping("/{rId}/response")
    public ResponseEntity<Review> addResponse(@PathVariable Long rId, @RequestBody Strign response){
        return ResponseEntity.ok(reviewService.addResponse(rId, response));
    }

    @deleteMapping("/{rId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long rId){
        reviewService.deleteReview(rId);
        return ResponseEntity.ok().build();
    }

    @getMapping("/dealer/{id}")
    public ResponseEntity<List<Review>> getReviewsByDealer(@PathVariable Long id){
        returm ResponseEntity.ok(reviewService.getReviewsByDealer(DealerService.getDealerById(id)));
    }

    @GetMapping("/customer/{cId}")
    public ResponseEntity<List<Review>> getReviewsByCustomer(@PathVariable Long cId){
        return ResponseEntity.ok(reviewService.getReviewsByCustomer(customerService.getCustomerById(cId)));
    }

    @GetMapping("/dealer/{id}/ratings")
    public ResponseEntity<Map<String, Double>> getAverageRatingForDealer(@PathVariable Long id){
        Double avgRating = reviewService.getAverageRatingForDealer(dealerService.getDealerById(id));
        Map<String, Double> ratings = new HashMap<>();
        ratings.put("averageRating", avgRating);
        return ResponseEntity.ok(ratings);

    }

    
}
    