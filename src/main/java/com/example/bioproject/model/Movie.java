package com.example.bioproject.model;

import java.util.Date;

public class Movie {
    private String name;
    private String description;
    private int ageRequirement;
    private String actorFullName;
    private String genre;
    private int duration;
    private String startDate;
    private String endDate;
    private int ID;
    private int maxSeats;
    private int remainingSeats;
    private int theaterID;

    public Movie (){
    }

    public Movie (int ID, String name, String genre, String actorFullName, String description, int ageRequirement, String startDate, String endDate, int duration, int maxSeats, int theaterID){
        this.ID = ID;
        this.name = name;
        this.genre = genre;
        this.actorFullName = actorFullName;
        this.description = description;
        this.ageRequirement = ageRequirement;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.maxSeats = maxSeats;
        this.theaterID = theaterID;
    }

    // to do: generator til kunden.

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequirement(int ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ageRequirement=" + ageRequirement +
                ", actorFullName='" + actorFullName + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", ID=" + ID +
                '}';
    }
}