package com.example.bioproject.controller;

import java.util.*;

import com.example.bioproject.model.Kiosk;
import com.example.bioproject.model.Movie;
import com.example.bioproject.service.KioskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bioproject.service.BioService;

@RestController
public class BioController {
    
    private final BioService bioService;
    private final KioskService kioskService;

    // Constructor-based injection
    public BioController(BioService bioService, KioskService kioskService) {
        this.bioService = bioService;
        this.kioskService = kioskService;
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

    @GetMapping("/api/cinema/snacks")
    public List<Kiosk> parseKioskToJson(){
        List<Kiosk> kioskList = kioskService.getKioskList();
        return kioskList;
    }

    @PostMapping("/api/cinema/snacks")
    public Kiosk createSnack(@RequestBody Kiosk newKioskItem){
        kioskService.createKioskItem(newKioskItem);
        return newKioskItem;
    }

    @DeleteMapping("/api/cinema/snacks/{ID}")
    public void deleteKioskItem(@PathVariable int ID){
        kioskService.deleteKioskItem(ID);
    }

    @PutMapping("/api/cinema/snacks/{ID}")
    public Kiosk updateKioskItem(@PathVariable int ID, Kiosk kioskToBeUpdated){
        kioskService.updateKiosk(ID, kioskToBeUpdated);
        return kioskToBeUpdated;
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