package com.example.Backend_api.deal;

import org.springframework.web.bind.annotation.RestController;

import com.example.Backend_api.payment.Payment;
import com.example.Backend_api.payment.PaymentRepository;
import com.example.Backend_api.vehicle.VehicleService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/deals")
public class DealController {

    private final DealService dealService;
    private final PaymentRepository PaymentRepository;
    private final VehicleService vehicleService;

    @GetMapping
    public List<Deal> getDeals() {
        return dealService.getAllDeals();
    }

    @PostMapping
    public Deal createDeal(@RequestBody Deal deal) {
        Deal newDeal = dealService.saveDeal(deal);
        vehicleService.markVehicleAsSold(newDeal.getVehicle().getId());
        LocalDate currentDate = LocalDate.now();
        if (newDeal.getIsFinanced()){
            Double paymentAmount = (newDeal.getDealAmount() - newDeal.getDownPayment()) / 12; 
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
        dealService.deleteDeal(id);
    }

    @GetMapping("/dealer/totalprofit/{dealerId}")
    public Double calculateTotalProfitByDealerId(@PathVariable Long dealerId) {
        return dealService.calculateTotalProfitByDealerId(dealerId);
    }

    @GetMapping("/dealer/yearlysales/{dealerId}")
    public Double calculateTotalProfitOfyearSalesByDealerId(@PathVariable Long dealerId) {
        return dealService.calculateTotalProfitOfyearSalesByDealerId(dealerId);
    }

    @GetMapping("/dealer/monthlydeals/{dealerId}")
    public Long countDealsOfMonthByDealerId(@PathVariable Long dealerId) {
        return dealService.countDealsOfMonthByDealerId(dealerId);
    }

}
