package com.example.Backend_api.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface customerRepository extends JpaRepository<customer, Long> {
 
    @Query("select c from customer c where c.username = ?1")
    List<customer> findByUsernameAndPassword(String username);

    Optional<customer> findByUsername(String username);

    @Query("select sv from savedVehicles sv where sv.customer.cId = ?1")
    List<customer> findSavedVehiclesBycId(Long cId);
    
}