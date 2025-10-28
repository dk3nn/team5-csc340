package com.example.Backend_api.dealer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("dealer")
    private List<Vehicle> vehicles = new ArrayList<>();

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    public String getEmail() {
        return email;
    }
}
