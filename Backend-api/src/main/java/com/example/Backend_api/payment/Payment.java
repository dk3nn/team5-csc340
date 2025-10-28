package com.example.Backend_api.payment;

import java.time.LocalDate;

import com.example.Backend_api.deal.Deal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private Boolean paid = false;

    @ManyToOne
    @JoinColumn(name = "deal_id", nullable = false)
    @JsonIgnoreProperties({"payments", "vehicle"})
    private Deal deal;

    public Payment(Long id) {
        this.id = id;
    }

}
