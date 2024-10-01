package com.example.bioproject.service;

import org.springframework.stereotype.Service;
import com.example.bioproject.model.Movie;
import com.example.bioproject.repository.BioRepository;
import java.util.*;

@Service
public class BioService {
    BioRepository bioRepository;

    public List<Movie> movieCreator(){
        return bioRepository.movieCreator();
    }
}
