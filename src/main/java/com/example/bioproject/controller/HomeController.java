package com.example.bioproject.controller;

import com.example.bioproject.model.Movie;
import com.example.bioproject.service.BioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String home() {
        return "movieHomepage";
    }

    @GetMapping("/movieForm")
    public String movieForm() {
        return "movieForm";
    }

    @GetMapping("/movieDetails/view/{ID}")
    public String movieDetails(@PathVariable int ID) {
        return "movieDetails";
    }

    @GetMapping("/editMovie/view/{ID}")
    public String editMovie(@PathVariable int ID) {
        return "editMovie";
    }

    @GetMapping("/editSnack/view/{ID}")
    public String editSnack(@PathVariable int ID) {
        return "editKiosk";
    }

    @GetMapping("/user/reserveTicket")
    public String reserveTicket() {
        return "userHomePage";
    }

    @GetMapping("/userHomepage")
    public String getMovies() {
        return "userHomePage";
    }

    @GetMapping("userMovieDetails/view/{ID}")
    public String getSpecificMovie(@PathVariable int ID) {
        return "userMovieDetails";
    }

    @GetMapping("/kioskHomepage")
    public String kioskHome() {
        return "kioskHomepage";
    }

    @GetMapping("/kioskForm")
    public String createKiosk() {
        return "kioskForm";
    }

    @GetMapping("/kioskDetails/view/{ID}")
    public String showKioskDetails(@PathVariable int ID) {
        return "kioskDetails";
    }
}
