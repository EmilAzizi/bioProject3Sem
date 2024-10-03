package com.example.bioproject.controller;

import java.util.*;
import com.example.bioproject.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bioproject.service.MovieService;
import com.example.bioproject.model.MovieModel;
import com.example.bioproject.service.BioService;

@RestController
public class BioController {
    private BioService bioService;
    private MovieService movieService;

    @GetMapping("/api/cinema/movies")
    public List<MovieModel> parseMovieToJson(){
        //List<Movie> movieList = bioService.getMovieListFromRepository();
        List<MovieModel> movieModelList = movieService.showMovies();
        return movieModelList;
    }
}