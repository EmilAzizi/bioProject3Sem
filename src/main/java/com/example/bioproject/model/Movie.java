package com.example.bioproject.model;

import java.util.Date;

public class Movie {
    private String name;
    private String description;
    private int ageRestrction;
    private String actorFullName;
    private String genre;
    private int duration;
    private Date startDate;
    private Date endDate;
    private int ID;

    public Movie (){
    }

    public Movie (String name, String genre,String actorFullName, String description, int ageRestrction, Date startDate, Date endDate, int duration){
        this.name = name;
        this.genre = genre;
        this.actorFullName = actorFullName;
        this.description = description;
        this.ageRestrction = ageRestrction;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
    }

    public Movie(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public void setAgeRestrction(int ageRestrction){
        this.ageRestrction = ageRestrction;
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

    public String getDescription() {
        return description;
    }

    public int getAgeRestrction() {
        return ageRestrction;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOldEnough(int isOldEnough) {
        this.ageRestrction = isOldEnough;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        return name + " " + ID;
    }

}