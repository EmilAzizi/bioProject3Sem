package com.example.bioproject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.bioproject.model.MovieModel;

@Repository
public class MovieRepository_HC {
    private int movieID;

    private ArrayList<MovieModel> movieList;

    public MovieRepository_HC(int movieID, List<MovieModel> movieList) {
        this.movieID = movieID;
                
        this.movieList = new ArrayList<>();

        movieList.add(new MovieModel(1, "Hobitten", Arrays.asList("Peter Jackson"), "bla bla", true, LocalDate.of(2010, 7, 16), LocalDate.of(2010, 7, 17), 233));
    }

    public ArrayList<MovieModel> showMovies() {
        return movieList;

    }
        

    public void createMovie(MovieModel movieModel) { 
        movieModel.setMovieID(movieModel.getMovieID());
        movieList.add(movieModel);
    }

    public void updateMovie(MovieModel movieModel) {
        int index = 0;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieID() == movieModel.getMovieID())
                index = i;
        }

        movieList.set(index, movieModel);
    }

    public MovieModel deleteMovie(int movieID) {
        MovieModel removeMovie = null;
                
        for (MovieModel movie : movieList) {
            if (movie.getMovieID() == movieID) 
                removeMovie = movie;
        }

        if (removeMovie != null) {
            movieList.remove(removeMovie);
        }

        return removeMovie;
    }
}
