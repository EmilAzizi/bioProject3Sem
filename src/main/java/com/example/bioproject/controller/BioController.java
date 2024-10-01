package com.example.bioproject.controller;

import java.util.*;
import com.example.bioproject.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bioproject.service.BioService;

@RestController
public class BioController {
    BioService bioService;

    @GetMapping("/api/cinema/movies")
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "science Fiction", 148));
        return movies;
    }
}
