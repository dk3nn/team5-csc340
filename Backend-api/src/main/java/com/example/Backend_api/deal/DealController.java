package com.example.Backend_api.deal;

import org.springframework.web.bind.annotation.RestController;
import com.example.Backend_api.payment.Payment;
import com.example.Backend_api.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/deals")
public class DealController {

    private final DealService dealService;
    private final PaymentRepository PaymentRepository;

    @GetMapping("")
    public List<Deal> getDeals() {
        return dealService.getAllDeals();
    }

    @PostMapping("")
    public Deal createDeal(@RequestBody Deal deal) {
        Deal newDeal = dealService.saveDeal(deal);
        LocalDate currentDate = LocalDate.now();
        if (newDeal.getIsFinanced()){
            Double paymentAmount = newDeal.getDealAmount() / 12; 
            for (int i = 0; i < 12; i++) {
                Payment newPayment = new Payment();
                newPayment.setDeal(newDeal);
                newPayment.setAmount(paymentAmount);
                newPayment.setMethod("cash");
                newPayment.setDueDate(currentDate.plusMonths(i+1));
                PaymentRepository.save(newPayment);
            }
        }else{
            Payment newPayment = new Payment();
            newPayment.setDeal(newDeal);
            newPayment.setAmount(newDeal.getDealAmount());
            newPayment.setMethod("cash");
            newPayment.setDueDate(currentDate.plusMonths(1));
            PaymentRepository.save(newPayment);
        }
        return newDeal;
    }

    @GetMapping("/vehicle/{vehicleId}")
    public Deal getDealByVehicleId(@PathVariable Long vehicleId) {
        return dealService.getDealByVehicleId(vehicleId);
    }

    @GetMapping("/dealer/{dealerId}")
    public List<Deal> getDealsByDealerId(@PathVariable Long dealerId) {
        return dealService.getDealsByDealerId(dealerId);
    }   

    @PutMapping("/{id}")
    public Deal updateDeal(@PathVariable Long id, @RequestBody Deal deal) {
        Deal existingDeal = dealService.getDealById(id);
        existingDeal.setDealDate(deal.getDealDate());
        existingDeal.setDealAmount(deal.getDealAmount()); 
        existingDeal.setVehicle(deal.getVehicle());
        dealService.saveDeal(existingDeal);
        return existingDeal;
    }

    @DeleteMapping("/{id}")
    public void deleteDeal(@PathVariable Long id) {
        Deal existingDeal = dealService.getDealById(id);
        dealService.deleteDeal(existingDeal);
    }

}
