package com.example.bioproject.repository;

import com.example.bioproject.model.Movie;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BioRepository {
    private List<Movie> movieList;

    public BioRepository() {
        movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void createMovie(Movie newMovie) {
        movieList.add(newMovie);
    }

    public void setIDForMovie() {
        int ID = 1;
        for (Movie movie : movieList) {
            movie.setID(ID);
            ID++;
        }
    }

    public Movie getMovieByID(int ID) {
        for (Movie movie : movieList) {
            if (movie.getID() == ID) {
                return movie;
            }
        }
        return null;
    }

    public void deleteMovie(int ID) {
        Movie removeMovie = null;

        for (Movie movie : movieList) {
            if (movie.getID() == ID) {
                removeMovie = movie;
                break;
            }
        }

        if (removeMovie != null) {
            movieList.remove(removeMovie);
        }
        setIDForMovie();
    }

    public void updateMovie(int id, Movie updatedMovie) {
        for (Movie movie : movieList) {
            if (movie.getID() == id) {
                // Update the movie details
                // movie.setName(updatedMovie.getName());
                // movie.setGenre(updatedMovie.getGenre());
                movie.setName(updatedMovie.getName());
                movie.setDuration(updatedMovie.getDuration());
                movie.setGenre(updatedMovie.getGenre());
                // movie.setDescription(updatedMovie.getDescription());
                // movie.setActorFullName(updatedMovie.getActorFullName());
                // movie.setDate(updatedMovie.getDate());
                // movie.setRuntime(updatedMovie.getRunTime());
                movie.setAgeRequirement(updatedMovie.getAgeRequirement());
                break;
            }
        }
    }
}
