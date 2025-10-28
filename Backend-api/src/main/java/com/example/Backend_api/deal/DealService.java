package com.example.Backend_api.deal;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DealService {
    private final DealRepository dealRipository;

    
    public Deal getDealByVehicleId(Long vehicleId) {
        return dealRipository.findByVehicleId(vehicleId);
    }

    public List<Deal> getDealsByDealerId(Long dealerId) {
        return dealRipository.findByVehicle_Dealer_id(dealerId);
    }


    public Deal saveDeal(Deal deal) {
        return dealRipository.save(deal);
    }

    public List<Deal> getAllDeals() {
        return dealRipository.findAll();
    }

    public Deal getDealById(Long id) {
        return dealRipository.findById(id).orElseThrow(() -> new RuntimeException("Deal not found"));
    }
    
}
