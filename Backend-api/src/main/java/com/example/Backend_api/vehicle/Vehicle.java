package com.example.Backend_api.vehicle;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.Backend_api.dealer.Dealer;
import com.example.Backend_api.deal.Deal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@Table(name = "vehicle")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String make;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false)
    private Integer year;
    
    @Column(nullable = false)
    private String color;
    
    @Column(nullable = false)
    private String vin;
    
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double cost;
    
    @Column(nullable = false)
    private Integer mileage;
    
    @Column(nullable = false)
    private String transmission;
    
    @Column
    private String description;
    
    @Column(nullable = false)
    private String fuelType;
    
    @Column(nullable = false)
    private String bodyType;
    
    @Column(nullable = false)
    private Integer numberOfDoors;
    
    @Column(nullable = false)
    private String driveType;
    
    @Column(nullable = false)
    private String engineSize;

    @Column
    private String imageUrl;

    @Column
    private Boolean sold = false;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("vehicle")
    private Deal deal;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)  
    @JsonIgnoreProperties("vehicles") 
    private Dealer dealer;

    public Vehicle(Long id) {
        this.id = id;
    }
}
