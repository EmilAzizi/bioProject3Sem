package com.example.bioproject.controller;

import java.util.*;
import com.example.bioproject.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bioproject.service.BioService;

@RestController
public class BioController {
    BioService bioService = new BioService();

    @GetMapping("/api/cinema/movies")
    public List<Movie> parseMovieToJson(){
        List<Movie> movieList = bioService.getMovieListFromRepository();
        return movieList;
    }

    @PostMapping("/api/cinema/movies")
    public Movie createMovie(@RequestBody Movie newMovie){
        bioService.createMovie(newMovie);
        bioService.setMovieID();
        return newMovie;
    }

    @GetMapping("/api/cinema/movies/{ID}")
    public Movie getMovieByID(@PathVariable int ID){
        Movie movieFound = bioService.findMovieByID(ID);
        return movieFound;
    }
}