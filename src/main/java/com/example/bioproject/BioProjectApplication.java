package com.example.bioproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bioproject.model.Movie;
import com.example.bioproject.repository.BioRepository;

@SpringBootApplication
public class BioProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BioProjectApplication.class, args);
    }
}