package com.example.bioproject.model;

public class Movie {
    private String description;
    private boolean isOldEnough;
    private String actorFullName;
    private String date;
    private int runtime;

    public Movie(String description, boolean isOldEnough, String actorFullName, String date, int runtime) {
        this.description = description;
        this.isOldEnough = isOldEnough;
        this.actorFullName = actorFullName;
        this.date = date;
        this.runtime = runtime;
    }

    public Movie() {
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsOldEnough() {
        return isOldEnough;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public String getDate() {
        return date;
    }

    public int getRunTime() {
        return runtime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOldEnough(boolean isOldEnough) {
        this.isOldEnough = isOldEnough;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movie [description=" + description + ", isOldEnough=" + isOldEnough + ", actorFullName=" + actorFullName
                + ", date=" + date + ", runtime=" + runtime + "]";
    }

    

}