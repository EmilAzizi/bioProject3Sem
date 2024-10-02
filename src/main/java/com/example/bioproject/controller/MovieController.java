package com.example.bioproject.controller;

@Controller
@RequestMapping("")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }   

    @GetMapping("/show movie html")
    public String showMovies(Model model) {
            model.addAttribute("movieList", movieService.showMovies)

            return "movie html"
    }

    @PostMapping("/create movie html")
    public String createMovie(@ModelAttribute("movieName") MovieModel movieModel) {
        movieService.createMovie(movieModel);
    }

}
