package com.example.bioproject.controller;

import com.example.bioproject.model.Movie;
import com.example.bioproject.service.BioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String home() {
        return "movieHomepage";
    }

    @GetMapping("/movieForm")
    public String movieForm() {
        return "movieForm";
    }

    @GetMapping("/movieDetails")
    public String movieDetails(){
        return "movieDetails";
    }
}
