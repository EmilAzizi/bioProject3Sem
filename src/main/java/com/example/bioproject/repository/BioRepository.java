package com.example.bioproject.repository;

import com.example.bioproject.model.Movie;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BioRepository {
    private List<Movie> movieList;

    public BioRepository() {
        movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void createMovie(Movie newMovie) {
        movieList.add(newMovie);
    }

    public void setIDForMovie(){
        int ID = 0;
        for(Movie movie : movieList){
            movie.setID(ID);
            ID++;
        }
    }

    public Movie getMovieByID(int ID) {
        for (Movie movie : movieList) {
            if (movie.getID() == ID) {
                return movie;
            }
        }
        return null;
    }


    public Movie deleteMovie(String name) {
        Movie removeMovie = null;

        for (Movie movie : movieList) {
            if (movie.getName() == movie.getName())
                removeMovie = movie;
        }

        if (removeMovie != null) {
            movieList.remove(removeMovie);
        }

        return removeMovie;
    }

    public void updateMovie(Movie Movie) {
        int index = 0;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getName() == Movie.getName())
                index = i;
        }

        movieList.set(index, Movie);
    }

}
