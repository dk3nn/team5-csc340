package com.example.Backend_api.Customer;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

  
}
