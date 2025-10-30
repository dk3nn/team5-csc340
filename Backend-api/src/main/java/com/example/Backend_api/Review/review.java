package com.example.Backend_api.Review;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import com.example.Backend_api.Customer.customer;
import com.example.Backend_api.dealer.Dealer;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rId;

    
    @ManyToOne
    @JoinColumn(name = "customer_cId", nullable = false)
    @JsonIgnoreProperties({"reviews", "deals", "vehicles"})
    private customer customer;

   
    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    @JsonIgnoreProperties({"reviews", "deals", "vehicles"})
    private Dealer dealer;

    
    private Double rating;

    @Column(columnDefinition="TEXT")
    private String comment;

   
    private LocalDateTime reviewDate = LocalDateTime.now();

    @Column(columnDefinition="TEXT")
    private String response;

    private LocalDateTime responseDate;
}
