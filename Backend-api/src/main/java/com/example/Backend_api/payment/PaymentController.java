package com.example.Backend_api.payment;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public Payment createPayment(Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("deal/{dealId}")
    public List<Payment> getPaymentsByDealId(@PathVariable Long dealId) {
        return paymentService.getPaymentsByDealId(dealId);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    @GetMapping("dealer/{dealerId}")
    public List<Payment> getPaymentsByDealerId(@PathVariable Long dealerId) {
        return paymentService.getPaymentsByDealerId(dealerId);
    }

}
