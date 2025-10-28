package com.example.Backend_api.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController{

    @Autowired
    private customerService customerService;

    @GetMapping("/customer/{cId}")
    public customer getCustomerById(@PathVariable Long cId) {
        return customerService.getCustomerById(cId);
    }

    @PostMapping("/customer")
    public customer newCustomer(@RequestBody customer cust) {
        return customerService.newCustomer(cust);
    }

    @PutMapping("/customer/{cId}")
    public customer updateCustomer(@PathVariable Long cId, @RequestBody customer cust) {
        return customerService.updateCustomer(cId, cust);
    }

    @DeleteMapping("/customer/{cId}/delete")
    public void deleteCustomer(@PathVariable Long cId) {
        customerService.deleteCustomer(cId);
        System.out.println("Customer deleted successfully");
    }



}