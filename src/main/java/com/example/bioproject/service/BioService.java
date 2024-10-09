package com.example.bioproject.service;

import com.example.bioproject.repository.DBRepository;
import org.springframework.stereotype.Service;
import com.example.bioproject.model.Movie;
import com.example.bioproject.repository.BioRepository;
import java.util.*;

@Service
public class BioService {
    private final BioRepository bioRepository;

    // Constructor-based injection
    public BioService(BioRepository bioRepository) {
        this.bioRepository = bioRepository;
    }
    
    public List<Movie> getMovieListFromRepository() {
        return bioRepository.getMovieList();
    }

    public void createMovie(Movie newMovie) {
        bioRepository.createMovie(newMovie);
    }

    public Movie findMovieByID(int ID) {
        Movie movieToBeFound = bioRepository.getMovieByID(ID);
        return movieToBeFound;
    }

    public void deleteMovieFromRepository(int ID) {
        bioRepository.deleteMovie(ID);
    }

    public void updateMovie(int id, Movie updatedMovie) {
        bioRepository.updateMovie(id, updatedMovie);
    }

    public void reserveTickets(int movieID, int wishedAmountOfSeats) {
        //bioRepository.reserveTicket(amountReserved, movieTheaterID);
        try {
            bioRepository.reserveTickets(movieID, wishedAmountOfSeats);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
