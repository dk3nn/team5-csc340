package com.example.Backend_api.dealer;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerService {
    private final DealerRepository dealerRipository;

    public Dealer createDealer(Dealer dealer){
        if(dealerRipository.existsByEmail(dealer.getEmail())){
            throw new IllegalArgumentException("Dealer with email " + dealer.getEmail() + " already exists.");
        }
        return dealerRipository.save(dealer);
    }

    public Dealer updateDealer(Long id, Dealer updatedDealer){
        Dealer existingDealer = dealerRipository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dealer with id " + id + " not found."));

        existingDealer.setName(updatedDealer.getName());
        if(!existingDealer.getEmail().equals(updatedDealer.getEmail()) &&
           dealerRipository.existsByEmail(updatedDealer.getEmail())){
            throw new IllegalArgumentException("Dealer with email " + updatedDealer.getEmail() + " already exists.");
        }
        existingDealer.setPhoneNumber(updatedDealer.getPhoneNumber());
        existingDealer.setAddress(updatedDealer.getAddress());

        return dealerRipository.save(existingDealer);
    }

    public Dealer getDealerById(Long id){
        return dealerRipository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dealer with id " + id + " not found."));
    }

    public Dealer getDealerByEmail(String email){
        return dealerRipository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Dealer with email " + email + " not found."));
    }

    public void deleteDealer(Long id){
        if(!dealerRipository.existsById(id)){
            throw new IllegalArgumentException("Dealer with id " + id + " not found.");
        }
        dealerRipository.deleteById(id);
    }

    public List<Dealer> getAllDealers(){
        return dealerRipository.findAll();
    }

    public Dealer authenticate(String email, String password){
        Dealer dealer = dealerRipository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Dealer with email " + email + " not found."));
        if(!dealer.getPassword().equals(password)){
            throw new IllegalArgumentException("Invalid password for dealer with email " + email + ".");
        }
        return dealer;
    }

}
