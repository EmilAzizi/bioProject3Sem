package com.example.bioproject.service;

import com.example.bioproject.repository.ScreenRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    private ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public String reserveTickets(String userEmail, int amountReserved) {
        return userEmail;
    }


    
}
