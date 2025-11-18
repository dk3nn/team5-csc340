package com.example.Backend_api.dealer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

    

@RestController
@RequestMapping("/api/dealers")
@RequiredArgsConstructor
public class DealerController {
    private final DealerService dealerService;

    @PostMapping
    public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
        return ResponseEntity.ok(dealerService.createDealer(dealer));
    }

    @GetMapping
    public List<Dealer> getAllDealers() {
        return dealerService.getAllDealers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable Long id, @RequestBody Dealer dealer) {
        return ResponseEntity.ok(dealerService.updateDealer(id, dealer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        return ResponseEntity.ok(dealerService.getDealerById(id));
    }

    @GetMapping("dealer/signin")
    public ResponseEntity<Dealer> authenticateDealer(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(dealerService.authenticate(email, password));
    }
}
