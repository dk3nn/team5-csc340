package com.example.Backend_api.CustomerClientSide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.List;

import com.example.Backend_api.Customer.customer;
import com.example.Backend_api.Customer.customerService;
import com.example.Backend_api.deal.Deal;
import com.example.Backend_api.deal.DealService;
import com.example.Backend_api.dealer.Dealer;
import com.example.Backend_api.dealer.DealerService;
import com.example.Backend_api.payment.PaymentService;
import com.example.Backend_api.payment.Payment;
import com.example.Backend_api.Review.review;
import com.example.Backend_api.Review.reviewRepository;
import com.example.Backend_api.Review.reviewService;
import com.example.Backend_api.vehicle.Vehicle;
import com.example.Backend_api.vehicle.VehicleService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/customer")
public class CustomerMvcController {
    private final customerService customerService;
    private final VehicleService vehicleService;
    private final DealService dealService;
    private final DealerService dealerService;
    private final PaymentService paymentService;
    private final reviewService reviewService;

    public CustomerMvcController(customerService customerService, VehicleService vehicleService,
            DealService dealService, DealerService dealerService, PaymentService paymentService,
            reviewService reviewService) {
        this.customerService = customerService;
        this.vehicleService = vehicleService;
        this.dealService = dealService;
        this.dealerService = dealerService;
        this.paymentService = paymentService;
        this.reviewService = reviewService;
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("customer", new customer());
        return "customer/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String username, @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model,
            HttpSession session) {

        model.addAttribute("name", name);
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        model.addAttribute("state", state);

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "customer/signup";
        }

        try {
            customer newCustomer = new customer();
            newCustomer.setName(name);
            newCustomer.setUsername(username);
            newCustomer.setEmail(email);
            newCustomer.setPhone(phone);
            newCustomer.setAddress(address);
            newCustomer.setCity(city);
            newCustomer.setState(state);
            newCustomer.setPassword(password);

            customer savedCustomer = customerService.newCustomer(newCustomer);
            session.setAttribute("customerID", savedCustomer.getcId());

            return "redirect:/customer/dashboard";

        } catch (Exception e) {
            model.addAttribute("error", "Could not create account: ");
            return "customer/signup";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "customer/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model,
            HttpSession session) {
        try {
            customer cust = customerService.authenticate(username, password);
            session.setAttribute("customerID", cust.getcId());
            return "redirect:/customer/dashboard";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "customer/login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long customerId = (Long) session.getAttribute("customerID");
        if (customerId == null) {
            return "redirect:customer/login";
        }
        customer cust = customerService.getCustomerById(customerId);
        List<Vehicle> availableVehicles = vehicleService.getAllVehicles();
        model.addAttribute("customer", cust);
        model.addAttribute("vehicles", availableVehicles);
        return "customer/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("customerID");
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String editProfileForm(HttpSession session, Model model) {
        Long customerId = (Long) session.getAttribute("customerID");
        if (customerId == null) {
            return "redirect:customer/login";
        }

        customer cust = customerService.getCustomerById(customerId);
        model.addAttribute("customer", cust);
        return "customer/profile";
    }

    @PostMapping("/profile")
    public String editProfile(@RequestParam(required = false) String name,
            @RequestParam String username,
            @RequestParam(required = false) String newUsername,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam String currentPassword,
            @RequestParam(required = false) String newPassword,
            HttpSession session, Model model) {

        Long customerId = (Long) session.getAttribute("customerID");
        if (customerId == null) {
            return "redirect:/customer/login";
        }

        customer cust = customerService.getCustomerById(customerId);

        try {
            customerService.authenticate(cust.getUsername(), currentPassword);

            if (name != null && !name.trim().isEmpty()) {
                cust.setName(name);
            }

            if (newUsername != null && !newUsername.trim().isEmpty() && !newUsername.equals(cust.getUsername())) {
                cust.setUsername(newUsername);
            }

            if (address != null && !address.trim().isEmpty()){
                cust.setAddress(address);
            }
            if (city != null && !city.trim().isEmpty()){
                cust.setCity(city);
            }
            if (state != null && !state.trim().isEmpty()){
                cust.setState(state);
            }
            if (email != null && !email.trim().isEmpty()){
                cust.setEmail(email);
            }
            if (phone != null && !phone.trim().isEmpty()){
                cust.setPhone(phone);
            }

            if (newPassword != null && !newPassword.trim().isEmpty() && !newPassword.equals(currentPassword)) {
                cust.setPassword(newPassword);
            }

            customerService.updateCustomer(customerId, cust);

            return "redirect:/customer/dashboard";
        } catch (Exception e) {
            customer originalCust = customerService.getCustomerById(customerId);
            model.addAttribute("customer", originalCust);
            model.addAttribute("error", "Invalid Password: " + e.getMessage());
            return "customer/profile";
        }
    }

    @GetMapping("/delete/{cid}")
    public String deleteAccount(@PathVariable Long cid, HttpSession session) {
        Long customerId = (Long) session.getAttribute("customerID");
        if (customerId == null || !customerId.equals(cid)) {
            return "redirect:/customer/dashboard";
        }

        customerService.deleteCustomer(cid);
        session.removeAttribute("customerID");
        return "redirect:/";
    }

    @GetMapping("/vehicles")
    public String browseVehicles(Model model) {
        List<Vehicle> availableVehicles = vehicleService.getAllVehicles();
        model.addAttribute("Vehicles", availableVehicles);
        return "Customer/vehicles";
    }

    @GetMapping("/vehicles/{id}")
    public String vehicleDetails(@PathVariable Long id, Model model) {
        // Long customerId = (Long) session.getAttribute("customerID");
        // if (customerId == null) {
        //     return "redirect:/customer/login";
        // }
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "customer/vehicleDetails";
    }

    // @GetMapping("/vehicles/saved")
    // public String savedVehicles(HttpSession session, Model model) {
    //     Long customerId = (Long) session.getAttribute("customerID");
    //     if (customerId == null) {
    //         return "redirect:/customer/login";
    //     }
    //     customer cust = customerService.getCustomerById(customerId);
    //     List<Vehicle> savedVehicles = cust.getSavedVehicles();
    //     model.addAttribute("vehicles", savedVehicles);
    //     return "customer/savedVehicles";
    // }

    @GetMapping("/vehicles/{dealerId}/reviews")
    public String dealerReviews(@PathVariable Long dealerId, Model model, HttpSession session)
    {
        Long customerId = (Long) session.getAttribute("customerID");
        if (customerId == null) {
            return "redirect:/customer/login";
        }
        Dealer dealer1 = dealerService.getDealerById(dealerId);
        List<review> reviews = reviewService.getReviewsByDealer(dealer1);
        model.addAttribute("reviews", reviews);
        return "customer/dealerReviews";
    }

    @GetMapping("/vehicles/{dealerId}/reviews/new")
    public String newReviewForm(@PathVariable Long dealerId, Model model, HttpSession session){
        Long customerId = (Long) session.getAttribute("customerID");
        if (customerId == null) {
            return "redirect:/customer/login";
        }
        customer cust1 = customerService.getCustomerById(customerId);
        Dealer dealer1 = dealerService.getDealerById(dealerId);
        model.addAttribute("dealer", dealer1);
        model.addAttribute("review", new review());
        return "customer/newReviewForm";
    }

}
