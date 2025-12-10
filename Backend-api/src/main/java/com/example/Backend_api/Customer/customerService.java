package com.example.Backend_api.Customer;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Backend_api.vehicle.Vehicle;
import com.example.Backend_api.vehicle.VehicleService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class customerService {

    private final customerRepository customerRepository;

    public customer getCustomerById(@PathVariable Long cId) {
        return customerRepository.findById(cId).orElse(null);
    }

    public customer newCustomer(customer cust) {
        return customerRepository.save(cust);
    }

    public customer updateCustomer(Long cId, customer cust) {
        cust.setcId(cId);
        return customerRepository.save(cust);
    }

    public void deleteCustomer(Long cId) {
        customerRepository.deleteById(cId);
    }

    public List<customer> getAllCustomers() {
        return customerRepository.findAll();
    public customer authenticate(String username, String password) {
        customer customer = customerRepository.findByUsername(username)
        .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        if (!customer.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return customer;
    }

    public List getSavedVehicles(Long cId) {
        return customerRepository.findSavedVehiclesBycId(cId);

    }

    public List<Vehicle> saveVehicletoList(Long cId, List<Vehicle> savedVehicles, long id) {
        Vehicle vehicle = VehicleService.getVehicleById(id);
        savedVehicles.add(vehicle);  
        customer customer = getCustomerById(cId);
        customer.setSavedVehicles(savedVehicles);
        customerRepository.save(customer);
        return savedVehicles;
    }

  
}
