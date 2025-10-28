package com.example.Backend_api.deal;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/deals")
public class DealController {

    private final DealService dealService;

    @GetMapping("")
    public List<Deal> getDeals() {
        return dealService.getAllDeals();
    }

    @PostMapping("")
    public Deal createDeal(@RequestBody Deal deal) {
        return dealService.saveDeal(deal);
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
        return deal;
    }

}
