package com.example.bioproject.controller;

import org.springframework.stereotype.Controller;
import com.example.bioproject.service.ScreenService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bioproject.service.ScreenService;

@Controller
@RequestMapping("/user")
public class ScreenController {

    private ScreenService screenService;


    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }


    @GetMapping("/reserveTicket")
    public String reserveTicket() {
        screenService.reserveTickets(null, 0);
        return "";
    }

    @PostMapping("/reserveTicket/{userEmail}") 
    public String postTicket() {
        
        return "";
    }

    
    
}
