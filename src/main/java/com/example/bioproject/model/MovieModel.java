package com.example.bioproject.model;

import java.time.LocalDate;
import java.util.List;

public class MovieModel {
    private int movieID;
    private String movieName;
    private List<String> movieActors;
    private String movieDescription;
    private Boolean moveiAgeRes;
    private LocalDate movieStartDate;
    private LocalDate movieEndDate;
    private int movieLength;

    public MovieModel(String movieName, List<String> movieActors, String movieDescription, Boolean moveiAgeRes,
            LocalDate movieStartDate, LocalDate movieEndDate, int movieLength) {
        this.movieName = movieName;
        this.movieActors = movieActors;
        this.movieDescription = movieDescription;
        this.moveiAgeRes = moveiAgeRes;
        this.movieStartDate = movieStartDate;
        this.movieEndDate = movieEndDate;
        this.movieLength = movieLength;
    }

    

    public MovieModel(int movieID, String movieName, List<String> movieActors, String movieDescription,
            Boolean moveiAgeRes, LocalDate movieStartDate, LocalDate movieEndDate, int movieLength) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieActors = movieActors;
        this.movieDescription = movieDescription;
        this.moveiAgeRes = moveiAgeRes;
        this.movieStartDate = movieStartDate;
        this.movieEndDate = movieEndDate;
        this.movieLength = movieLength;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }



    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<String> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<String> movieActors) {
        this.movieActors = movieActors;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Boolean getMoveiAgeRes() {
        return moveiAgeRes;
    }

    public void setMoveiAgeRes(Boolean moveiAgeRes) {
        this.moveiAgeRes = moveiAgeRes;
    }

    public LocalDate getMovieStartDate() {
        return movieStartDate;
    }

    public void setMovieStartDate(LocalDate movieStartDate) {
        this.movieStartDate = movieStartDate;
    }

    public LocalDate getMovieEndDate() {
        return movieEndDate;
    }

    public void setMovieEndDate(LocalDate movieEndDate) {
        this.movieEndDate = movieEndDate;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    

       
}
