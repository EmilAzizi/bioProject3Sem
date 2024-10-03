package com.example.bioproject.service;

import java.util.ArrayList;
import java.util.List;
import com.example.bioproject.model.MovieModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bioproject.repository.MovieRepository_DB;
import com.example.bioproject.repository.MovieRepository_HC;

@Service
public class MovieService {

    private MovieRepository_HC movieRepository_HC;
    private MovieRepository_DB movieRepository_DB;


    @Autowired
    public MovieService(MovieRepository_HC movieRepository_HC) {
        this.movieRepository_HC = movieRepository_HC;
    }

    public List<MovieModel> showMovies() {
        return movieRepository_DB.showMovies();
        //return movieRepository_HC.showMovies();
    }

    public void createMovie(MovieModel movieModel) {
        movieRepository_HC.createMovie(movieModel);
    }

    public void updateMovie(MovieModel movieModel) {
        movieRepository_HC.updateMovie(movieModel);
    }

    public void deleteMovie(int movieID) {
        movieRepository_HC.deleteMovie(movieID);
    }
}
