package com.example.bioproject.controller;

import com.example.bioproject.model.Movie;
import com.example.bioproject.service.BioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    BioService bioService;

    @GetMapping("/homepage")
    public String home() {
        return "movieHomepage";
    }

    @GetMapping("/movieForm")
    public String movieForm() {
        return "movieForm";
    }

    @GetMapping("/movieDetails/{ID}")
    public String movieDetails(@PathVariable int ID) {
        return "movieDetails";
    }

    @GetMapping("/editMovie/{ID}")
    public String editMovie(@PathVariable int ID) {
        return "editMovie";
    }

    @GetMapping("/user/reserveTicket")
    public String reserveTicket() {
        return "userHomePage";
    }

    @PostMapping("/user/reserveTicket/{userEmail}")
    public String postTicket() {
        //bioService.reserveTickets();
        return "";
    }
}
