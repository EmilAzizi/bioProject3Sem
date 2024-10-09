package com.example.bioproject.controller;

import java.util.*;
import com.example.bioproject.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bioproject.service.BioService;

@RestController
public class BioController {
    
    private final BioService bioService;

    // Constructor-based injection
    public BioController(BioService bioService) {
        this.bioService = bioService;
    }

    @GetMapping("/api/cinema/movies")
    public List<Movie> parseMovieToJson(){
        List<Movie> movieList = bioService.getMovieListFromRepository();
        return movieList;
    }

    @PostMapping("/api/cinema/movies")
    public Movie createMovie(@RequestBody Movie newMovie){
        bioService.createMovie(newMovie);
        return newMovie;
    }

    @GetMapping("/api/cinema/movies/{ID}")
    public Movie getMovieByID(@PathVariable int ID){
        Movie movieFound = bioService.findMovieByID(ID);
        return movieFound;
    }

    @DeleteMapping("/api/cinema/movies/{ID}")
    public void deleteMovie(@PathVariable int ID){
        bioService.deleteMovieFromRepository(ID);
    }

    @PutMapping("/api/cinema/movies/{ID}")
    public Movie updateMovie(@PathVariable int ID, @RequestBody Movie movieToBeUpdated){
        bioService.updateMovie(ID, movieToBeUpdated);
        System.out.println(movieToBeUpdated.toString());
        return movieToBeUpdated;
    }

    @PostMapping("/api/cinema/movies/{ID}/reserve")
    public ResponseEntity<?> reserveTickets(@PathVariable int ID, @RequestBody Map<String, Object> payload) {
        String email = (String) payload.get("email");

        // Get the numberOfSeats as a String and then convert it to Integer
        String numberOfSeatsString = (String) payload.get("numberOfSeats");
        int numberOfSeats = Integer.parseInt(numberOfSeatsString); // Convert to Integer

        try {
            bioService.reserveTickets(ID, numberOfSeats); // Call your existing method
            return ResponseEntity.ok(Collections.singletonMap("reservedSeats", numberOfSeats));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to reserve tickets: " + e.getMessage());
        }
    }



}