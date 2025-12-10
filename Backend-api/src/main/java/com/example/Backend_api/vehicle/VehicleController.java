package com.example.Backend_api.vehicle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.updatVehicle(id, vehicle));
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }


    @GetMapping("/dealer/{dealerId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByDealerId(@PathVariable Long dealerId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByDealerId(dealerId));
    }

    @GetMapping("/dealer/soldCount/{dealerId}")
    public ResponseEntity<Long> dealerSoldVehicleCount(@PathVariable Long dealerId) {
        Long count = vehicleService.countVehiclesByDealerIdAndSoldStatus(dealerId, true);
        return ResponseEntity.ok(count);
    }
    
    @GetMapping("/dealer/unsoldCount/{dealerId}")
    public ResponseEntity<Long> dealerUnsoldVehicleCount(@PathVariable Long dealerId) {
        Long count = vehicleService.countVehiclesByDealerIdAndSoldStatus(dealerId, false);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/unsold")
    public ResponseEntity<List<Vehicle>> getUnsoldVehicles() {
        return ResponseEntity.ok(vehicleService.getVehiclesBySoldStatus(false));
    }

    @GetMapping("/unsold/search")
    public ResponseEntity<List<Vehicle>> searchUnsoldVehiclesByMake(@RequestParam String make) {
        return ResponseEntity.ok(vehicleService.findByMakeContainingIgnoreCaseAndUnSold(make, false));
    }

    @GetMapping("/dealer/sold/{dealerId}")
    public ResponseEntity<List<Vehicle>> getSoldVehiclesByDealerId(@PathVariable Long dealerId) {
        return ResponseEntity.ok(vehicleService.findByDealerIdAndSold(dealerId, true));
    }

    @GetMapping("/dealer/unsold/{dealerId}")
    public ResponseEntity<List<Vehicle>> getUnsoldVehiclesByDealerId(@PathVariable Long dealerId) {
        return ResponseEntity.ok(vehicleService.findByDealerIdAndSold(dealerId, false));
    }

    @GetMapping("/dealer/unsold/search")
    public ResponseEntity<List<Vehicle>> searchUnsoldVehiclesByModelAndDealerId(@RequestParam String model, @RequestParam Long dealerId) {
        return ResponseEntity.ok(vehicleService.findByModelContainingIgnoreCaseAndSoldAndDealerId(model, false, dealerId));
    }

    @GetMapping("/dealer/sold/search")
    public ResponseEntity<List<Vehicle>> searchSoldVehiclesByModelAndDealerId(@RequestParam String model, @RequestParam Long dealerId) {
        return ResponseEntity.ok(vehicleService.findByModelContainingIgnoreCaseAndSoldAndDealerId(model, true, dealerId));
    }

    @GetMapping("/dealer/make/search/{dealerId}")
    public ResponseEntity<List<Vehicle>> searchVehiclesByMakeAndDealerId(@PathVariable Long dealerId, @RequestParam String make) {
        return ResponseEntity.ok(vehicleService.findByDealerIdAndMakeMakeContainingIgnoreCase(dealerId, make));
    }

}
