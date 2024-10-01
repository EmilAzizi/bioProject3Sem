package com.example.bioproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bioproject.service.BioService;

@Controller
public class BioController {
    BioService bioService;

    @GetMapping("/homepage")
    public String displayMovies(Model model) {
        model.addAttribute("movieList", bioService.movieCreator());
        return "homepage";
    }
}
