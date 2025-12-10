package com.example.Backend_api.CustomerClientSide;


import com.example.Backend_api.deal.Deal;
import com.example.Backend_api.deal.DealService;

import com.example.Backend_api.vehicle.Vehicle;
import com.example.Backend_api.vehicle.VehicleService;
import com.example.Backend_api.deal.Deal;
import com.example.Backend_api.deal.DealService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeMvcController {
    private final VehicleService vehicleService;
    private final DealService dealService;

    public HomeMvcController(VehicleService vehicleService, DealService dealService){
        this.vehicleService = vehicleService;
        this.dealService = dealService;
    }

    @GetMapping("/")
    public String home(Model model){
        return "redirect:home.html";
    }

    @GetMapping("/dealerSignup")
    public String dealerSignup(){
        return "redirect:provider/signup.html";
    }

    @GetMapping("/dealerSignin")
    public String dealerSignin(){
        return "redirect:provider/login.html";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    
}
