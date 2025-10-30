package com.example.Backend_api.Review;

import com.example.Backend_api.Customer.customer;
import com.example.Backend_api.dealer.Dealer;
import com.example.Backend_api.vehicle.Vehicle;

import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
//import java.util.OptionalDouble;

@Service
@lombok.RequiredArgsConstructor
@Transactional
public class reviewService {

    private final com.example.Backend_api.Review.reviewRepository reviewRepository;

    public Double getAverageRatingForDealer(Dealer dealer) {
        List<review> reviews = reviewRepository.findByDealer(dealer);
        if (reviews.isEmpty()) {
            return 0.0;
        }
        Double sum = 0.0;
        for (review rev : reviews) {
            sum += rev.getRating();
        }
        return sum / reviews.size();
    }

    public review createReview(review rev) {
        return reviewRepository.save(rev);
    }

    public review addResponse(Long rId, String response) {
        review rev = reviewRepository.findById(rId).orElseThrow(() -> new EntityNotFoundException("Review not found"));
        rev.setResponse(response);
        rev.setResponseDate(LocalDateTime.now());
        return reviewRepository.save(rev);
    }

    public void deleteReview(Long rId) {
        if (!reviewRepository.existsById(rId)) {
            throw new EntityNotFoundException("Review not found");
        }
        reviewRepository.deleteById(rId);
    }

    public List<review> getReviewsByDealer(Dealer dealer) {
        return reviewRepository.findByDealer(dealer);
    }

    public List<review> getReviewsByCustomer(customer cust) {
        return reviewRepository.findByCustomer(cust);
    }

}
