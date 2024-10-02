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
        Movie newMovie = new Movie("Inception", "Sci-Fi", 12);
        Movie newMovieOne = new Movie("Titanic", "Romans", 200);
        movieList.add(newMovie);
        movieList.add(newMovieOne);
        return movieList;
    }

    public void createMovie(String name, int duration, String genre) {
        Movie newMovie = new Movie(name, genre, duration);
        movieList.add(newMovie);
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
