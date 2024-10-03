package com.example.bioproject.service;

import org.springframework.stereotype.Service;
import com.example.bioproject.model.Movie;
import com.example.bioproject.repository.BioRepository;
import java.util.*;

@Service
public class BioService {
    BioRepository bioRepository = new BioRepository();

    public List<Movie> getMovieListFromRepository(){
        return bioRepository.getMovieList();
    }

    public void createMovie(Movie newMovie){
        bioRepository.createMovie(newMovie);
    }

    public Movie findMovieByID(int ID){
        Movie movieToBeFound = bioRepository.getMovieByID(ID);
        return movieToBeFound;
    }

    public void setMovieID(){
        bioRepository.setIDForMovie();
    }
}
