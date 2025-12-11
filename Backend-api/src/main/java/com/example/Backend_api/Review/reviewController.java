package com.example.Backend_api.Review;

import com.example.Backend_api.Customer.customerService;
import com.example.Backend_api.dealer.DealerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class reviewController {

    private final reviewService reviewService;
    private final customerService customerService;
    private final DealerService dealerService;

    @PostMapping
    public ResponseEntity<review> createReview(@Validated@RequestBody review review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }


    @DeleteMapping("/{rId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long rId){
        reviewService.deleteReview(rId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dealer/{id}")
    public ResponseEntity<List<review>> getReviewsByDealer(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getReviewsByDealer(dealerService.getDealerById(id)));
    }

    @GetMapping("/customer/{cId}")
    public ResponseEntity<List<review>> getReviewsByCustomer(@PathVariable Long cId){
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
    