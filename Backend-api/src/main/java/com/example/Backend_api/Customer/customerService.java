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
    private final VehicleService vehicleService;

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
        if(customerRepository.existsById(cId)){
        customerRepository.deleteById(cId);
        }
    }

    public List<customer> getAllCustomers() {
        return customerRepository.findAll();

    }
    public customer authenticate(String username, String password) {
        customer customer = customerRepository.findByUsername(username)
        .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        if (!customer.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return customer;
    }

    public void addVehicleToSaved(Long cId, Integer vehicleId) {
        customer cust = getCustomerById(cId);
        List<Integer> savedVehicleIds = cust.getSavedVehicleIds();
        if (!savedVehicleIds.contains(vehicleId)) {
            savedVehicleIds.add(vehicleId);
            cust.setSavedVehicles(savedVehicleIds);
            customerRepository.save(cust);
        }
    }

    public void removeVehicleFromSaved(Long cId, Integer vehicleId) {
        customer cust = getCustomerById(cId);
        List<Integer> savedVehicleIds = cust.getSavedVehicleIds();
        if (savedVehicleIds.contains(vehicleId)) {
            savedVehicleIds.remove(vehicleId);
            cust.setSavedVehicles(savedVehicleIds);
            customerRepository.save(cust);
        }
    }

    public List<Vehicle> getSavedVehicleIds(Long cId) {
        customer cust = getCustomerById(cId);
        List<Integer> savedVehicleIds = cust.getSavedVehicleIds();
        List<Vehicle> savedVehicles = new java.util.ArrayList<>();
        for (Integer vehicleId : savedVehicleIds) {
            Vehicle vehicle = vehicleService.getVehicleById(Long.valueOf(vehicleId));
            if (vehicle != null) {
                savedVehicles.add(vehicle);
            }
        }
        return savedVehicles;
    }

    public boolean isVehicleSaved(Long cId, Long vehicleId) {
        customer cust = getCustomerById(cId);
        List<Integer> savedVehicleIds = cust.getSavedVehicleIds();
        return savedVehicleIds.contains(vehicleId.intValue());
    }

}
