package com.example.bioproject.repository;
import com.example.bioproject.model.Movie;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BioRepository {
    private List<Movie> movieList;

    public BioRepository(){
        movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList(){
        return movieList;
    }

    public void createMovie(String name, int duration, String genre){
        Movie newMovie = new Movie(name, genre, duration);
        movieList.add(newMovie);
    }
}
