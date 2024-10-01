package com.example.bioproject.repository;
import com.example.bioproject.model.Movie;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BioRepository {
    private List<Movie> movieList;

    public List<Movie> movieCreator(){
        movieList = new ArrayList<>();
        Movie movie = new Movie("en god film", true, "mark jessing", "i dag", 120);

        movieList.add(movie);
        movieList.add(movie1);
        movieList.add(movie2);
    
        return movieList;
    }
}
