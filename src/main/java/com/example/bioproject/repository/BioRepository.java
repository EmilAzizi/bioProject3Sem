package com.example.bioproject.repository;

import com.example.bioproject.model.Movie;

import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class BioRepository {
    private List<Movie> movieList;
    private String JDBC_USERNAME = "root";
    private String JDBC_DATABASE_URL = "jdbc:mysql://localhost:3306/kea";
    private String JDBC_PASSWORD = "Emperiusvalor1!";


//    public List<Movie> getMovieList() {
//        return movieList;
//    }
//
//    public void createMovie(Movie newMovie) {
//        movieList.add(newMovie);
//    }

    public BioRepository() {
        movieList = new ArrayList<>();
    }

    public void insertMoviesToMovieList(){
        try (Connection connection = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM movie");
            ResultSet resultSet = ps.executeQuery();
            // Fuck you MySQL
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setID(resultSet.getInt("movieID"));
                movie.setName(resultSet.getString("movieName"));
                movie.setGenre(resultSet.getString("movieGenre"));
                movie.setActorFullName(resultSet.getString("movieActors"));
                movie.setDescription(resultSet.getString("movieDescription"));
                movie.setAgeRequirement(resultSet.getInt("movieAgeRes"));
                movie.setStartDate(resultSet.getString("movieStartDate"));
                movie.setEndDate(resultSet.getString("movieEndDate"));
                movie.setDuration(resultSet.getInt("movieLength"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getMovieList(){
        if(movieList.isEmpty()){
            insertMoviesToMovieList();
        }
        return movieList;
    }

    public void createMovie(Movie newMovie) {
        try(Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)){
            PreparedStatement ps = con.prepareStatement("INSERT INTO movie (movieName, movieGenre, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength)" +
                    "VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, newMovie.getName());
            ps.setString(2, newMovie.getGenre());
            ps.setString(3, newMovie.getActorFullName());
            ps.setString(4, newMovie.getDescription());
            ps.setInt(5, newMovie.getAgeRequirement());
            ps.setString(6, newMovie.getStartDate());
            ps.setString(7, newMovie.getEndDate());
            ps.setInt(8, newMovie.getDuration());
            ps.executeUpdate();
            movieList.add(newMovie);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIDForMovie(){
        int ID = 1;
        for(Movie movie : movieList){
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
//                movie.setName(updatedMovie.getName());
//                movie.setGenre(updatedMovie.getGenre());
                movie.setName(updatedMovie.getName());
                movie.setDuration(updatedMovie.getDuration());
                movie.setGenre(updatedMovie.getGenre());
//                movie.setDescription(updatedMovie.getDescription());
//                movie.setActorFullName(updatedMovie.getActorFullName());
//                movie.setDate(updatedMovie.getDate());
//                movie.setRuntime(updatedMovie.getRunTime());
//                movie.setOldEnough(updatedMovie.getIsOldEnough());
                break;
            }
        }
    }
}
