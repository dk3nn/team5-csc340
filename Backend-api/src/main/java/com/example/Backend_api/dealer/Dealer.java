package com.example.Backend_api.dealer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.Backend_api.Review.review;
import com.example.Backend_api.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "dealer")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dealer", "review", "deal"})
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dealer", "vehicle", "customer"})
    private List<review> dealerReviews = new ArrayList<>();

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    public String getEmail() {
        return email;
    }
}
