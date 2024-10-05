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
    private Connection con;
    private String db_url = "jdbc:mysql://localhost:3306/kea";
    private String db_username = "root";
    private String db_password = "Emperiusvalor1!";

    public BioRepository() {
        movieList = new ArrayList<>();
    }


//    public List<Movie> getMovieList() {
//        return movieList;
//    }
//
//    public void createMovie(Movie newMovie) {
//        movieList.add(newMovie);
//    }

    public void loadMoviesFromStartUp(){
        if(movieList.isEmpty()){
            try (Connection con = DriverManager.getConnection(db_url,db_username, db_password)){
            String query = "SELECT * FROM movie";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setID(rs.getInt("movieID"));
                movie.setName(rs.getString("movieName"));
                movie.setGenre(rs.getString("movieGenre"));
                movie.setActorFullName(rs.getString("movieActors"));
                movie.setGenre(rs.getString("movieDescription"));
                movie.setAgeRestrction(rs.getInt("movieAgeRes"));
                movie.setStartDate(rs.getDate("movieStartDate"));
                movie.setEndDate(rs.getDate("movieEndDate"));
                movie.setDuration(rs.getInt("movieLength"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }

    public List<Movie> getMovieList() {
        loadMoviesFromStartUp();
        return movieList;
    }

    public void insertMovie(Movie newMovie) {
//        try {
//            String query = "INSERT INTO movie (movieName, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength) VALUES (?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, newMovie.getName());
//            pstmt.setString(2, newMovie.getActorFullName());
//            pstmt.setString(3, newMovie.getGenre());
//            pstmt.setBoolean(4, true);  // Replace with actual data
//            pstmt.setDate(5, Date.valueOf("2020-01-01"));  // Replace with actual data
//            pstmt.setDate(6, Date.valueOf("2020-01-01"));  // Replace with actual data
//            pstmt.setInt(7, newMovie.getDuration());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


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
