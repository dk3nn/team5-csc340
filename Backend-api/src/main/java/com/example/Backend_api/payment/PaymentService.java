package com.example.Backend_api.payment;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository PaymentRepository;
    
    public List<Payment> getPaymentsByDealId(Long dealId) {
        return PaymentRepository.findByDealId(dealId);
    }

    public Payment savePayment(Payment payment) {
        return PaymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return PaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = PaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setMethod(payment.getMethod());
        existingPayment.setPaid(payment.getPaid());
        existingPayment.setDeal(payment.getDeal());
        return PaymentRepository.save(existingPayment);
    }

    public void deletePayment(Long id) {
        if (!PaymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found with id: " + id);
        }
        PaymentRepository.deleteById(id);
    }

    public List<Payment> getAllPayments() {
        return PaymentRepository.findAll();
    }

    public List<Payment> getPaymentsByDealerId(Long dealerId) {
        return PaymentRepository.findByDeal_Vehicle_Dealer_id(dealerId);
    }
}
