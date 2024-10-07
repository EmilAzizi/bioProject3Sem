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
        try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            // Prepare the SQL statement with RETURN_GENERATED_KEYS
            String sql = "INSERT INTO movie (movieName, movieGenre, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength)" +
                    "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set the values for the prepared statement
            ps.setString(1, newMovie.getName());
            ps.setString(2, newMovie.getGenre());
            ps.setString(3, newMovie.getActorFullName());
            ps.setString(4, newMovie.getDescription());
            ps.setInt(5, newMovie.getAgeRequirement());  // Ensure BOOLEAN value here
            ps.setString(6, newMovie.getStartDate());
            ps.setString(7, newMovie.getEndDate());
            ps.setInt(8, newMovie.getDuration());

            // Execute the update
            ps.executeUpdate();

            // Retrieve the generated keys (movieID)
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int movieID = generatedKeys.getInt(1); // Get the generated movieID
                newMovie.setID(movieID);               // Set it on the newMovie object
            }

            // Add the movie to the movie list
            movieList.add(newMovie);

        } catch (SQLException e) {
            throw new RuntimeException(e);
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

                try(Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)){
                    PreparedStatement ps = con.prepareStatement("DELETE FROM movie WHERE movieID = ?");
                    ps.setInt(1, ID);
                    ps.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            }
        }

        if (removeMovie != null) {
            movieList.remove(removeMovie);
        }
    }

    public void updateMovie(int id, Movie updatedMovie) {

        Movie movieToUpdate = new Movie();

        for (Movie movie : movieList) {
            if (movie.getID() == id) {
                movie.setName(updatedMovie.getName());
                movie.setGenre(updatedMovie.getGenre());
                movie.setActorFullName(updatedMovie.getActorFullName());
                movie.setDescription(updatedMovie.getDescription());
                movie.setAgeRequirement(updatedMovie.getAgeRequirement());
                movie.setStartDate(updatedMovie.getStartDate());
                movie.setEndDate(updatedMovie.getEndDate());
                movie.setDuration(updatedMovie.getDuration());
                movie = movieToUpdate;
                break;
            }
        }

        if(!movieToUpdate.equals(null)){
            movieToUpdate.setName(updatedMovie.getName());
            movieToUpdate.setGenre(updatedMovie.getGenre());
            movieToUpdate.setActorFullName(updatedMovie.getActorFullName());
            movieToUpdate.setDescription(updatedMovie.getDescription());
            movieToUpdate.setAgeRequirement(updatedMovie.getAgeRequirement());
            movieToUpdate.setStartDate(updatedMovie.getStartDate());
            movieToUpdate.setEndDate(updatedMovie.getEndDate());
            movieToUpdate.setDuration(updatedMovie.getDuration());

            try(Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)){
                PreparedStatement ps = con.prepareStatement("UPDATE movie SET movieName = ?, movieGenre = ?, movieActors = ?, movieDescription = ?, " +
                        "movieAgeRes = ?, movieStartDate = ?, movieEndDate = ?, movieLength = ? WHERE movieID = ?");
                ps.setString(1, movieToUpdate.getName());
                ps.setString(2, movieToUpdate.getGenre());
                ps.setString(3, movieToUpdate.getActorFullName());
                ps.setString(4, movieToUpdate.getDescription());
                ps.setInt(5, movieToUpdate.getAgeRequirement());
                ps.setString(6, movieToUpdate.getStartDate());
                ps.setString(7, movieToUpdate.getEndDate());
                ps.setInt(8, movieToUpdate.getDuration());
                ps.setInt(9, movieToUpdate.getID());
                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
