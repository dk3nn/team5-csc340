package com.example.Backend_api.deal;

import com.example.Backend_api.vehicle.Vehicle;
import com.example.Backend_api.Customer.customer;

import java.util.List;
import com.example.Backend_api.payment.Payment;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
public class Deal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dealDate;

    @Column(nullable = false)
    private Double dealAmount;

    @Column(nullable = false)
    private Boolean isFinanced;

    @Column(nullable = false)
    private double downPayment;

    @Transient
    private double profit;


    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)  
    @JsonIgnoreProperties({"deal", "dealer"})
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "customer_cId", nullable = false)
    @JsonIgnoreProperties("deal")
    private customer customer;


    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("deal")
    private List<Payment> payments;

}
