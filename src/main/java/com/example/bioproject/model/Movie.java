package com.example.bioproject.model;

public class Movie {
    private String name;
    // private String description;
    private int ageRequirement;
    // private String actorFullName;
    private String genre;
    private int duration;
    // private String date;
    // private int runtime;
    private int ID;

    public Movie(String name, String genre, int duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.ID = 0;
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

    // public String getDescription() {
    // return description;
    // }
    //
    public int getAgeRequirement() {
        return ageRequirement;
    }

    //
    // public String getActorFullName() {
    // return actorFullName;
    // }
    //
    // public String getDate() {
    // return date;
    // }
    //
    // public int getRunTime() {
    // return runtime;
    // }
    //
    // public void setDescription(String description) {
    // this.description = description;
    // }
    //
    public void setAgeRequirement(int ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    //
    // public void setActorFullName(String actorFullName) {
    // this.actorFullName = actorFullName;
    // }
    //
    // public void setDate(String date) {
    // this.date = date;
    // }
    //
    // public void setRuntime(int runtime) {
    // this.runtime = runtime;
    // }
    //
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