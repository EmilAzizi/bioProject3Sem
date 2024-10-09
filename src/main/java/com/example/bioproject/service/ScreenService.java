package com.example.bioproject.service;

import com.example.bioproject.repository.BioRepository;
import com.example.bioproject.repository.ScreenRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    private ScreenRepository screenRepository;
    private BioRepository bioRepository;

    public ScreenService() {
        this.screenRepository = new ScreenRepository();
        this.bioRepository = new BioRepository();
    }

    public String reserveTickets(String userEmail, int amountReserved) {
        return screenRepository.reserveTicket(userEmail, amountReserved);
    }

    public int getRemainingSeats(int seatsReserved, int movietheaterID){
        int remainingSeats = bioRepository.calculateNewRemainingSeats(seatsReserved, movietheaterID);

        return remainingSeats;
    }
    
}
