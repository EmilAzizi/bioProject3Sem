package com.example.bioproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bioproject.model.MovieModel;
import com.example.bioproject.service.MovieService;

@Controller
@RequestMapping("")
public class MovieController1 {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }  

    @GetMapping("/show movie html")
    public String showMovies(Model model) {
        model.addAttribute("movieList", movieService.showMovies);

        return "movie html"
    }

    @PostMapping("/create movie html")
    public String createMovie(@ModelAttribute("movieName") MovieModel movieModel) {
        movieService.createMovie(movieModel);
    }
    
}
