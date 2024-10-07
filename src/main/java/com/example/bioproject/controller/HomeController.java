package com.example.bioproject.controller;

import com.example.bioproject.model.Movie;
import com.example.bioproject.service.BioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/movieDetails/{ID}")
    public String movieDetails(@PathVariable int ID){
        return "movieDetails";
    }

    @GetMapping("/editMovie/{ID}")
    public String editMovie(@PathVariable int ID){
        return "editMovie";
    }
}
