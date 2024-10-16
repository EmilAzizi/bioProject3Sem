package com.example.bioproject.repository;

import com.example.bioproject.model.Movie;

import java.util.*;
import java.sql.*;

import org.springframework.stereotype.Repository;

@Repository
public class BioRepository {
    private List<Movie> movieList;
    private String JDBC_USERNAME = "root";
    private String JDBC_DATABASE_URL = "jdbc:mysql://localhost:3306/kea";
    private String JDBC_PASSWORD = "27SlimHuskies";

    public BioRepository() {
        movieList = new ArrayList<>();
    }

    public void insertMoviesToMovieList() {
        try (Connection connection = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM movie");
            ResultSet resultSet = ps.executeQuery();
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
                movie.setMaxSeats(resultSet.getInt("movieMaxSeats"));
                movie.setRemainingSeats(resultSet.getInt("movieRemainingSeats"));
                movie.setTheaterID(resultSet.getInt("movieTheaterID"));
                movieList.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getMovieList() {
        if (movieList.isEmpty()) {
            insertMoviesToMovieList();
        }
        return movieList;
    }

    public void createMovie(Movie newMovie) {
        try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String sql = "INSERT INTO movie (movieName, movieGenre, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength)"
                    +
                    "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, newMovie.getName());
            ps.setString(2, newMovie.getGenre());
            ps.setString(3, newMovie.getActorFullName());
            ps.setString(4, newMovie.getDescription());
            ps.setInt(5, newMovie.getAgeRequirement());
            ps.setString(6, newMovie.getStartDate());
            ps.setString(7, newMovie.getEndDate());
            ps.setInt(8, newMovie.getDuration());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int movieID = generatedKeys.getInt(1);
                newMovie.setID(movieID);
            }

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

                try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
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
                movie.setID(id);
                movie.setName(updatedMovie.getName());
                movie.setGenre(updatedMovie.getGenre());
                movie.setActorFullName(updatedMovie.getActorFullName());
                movie.setDescription(updatedMovie.getDescription());
                movie.setAgeRequirement(updatedMovie.getAgeRequirement());
                movie.setStartDate(updatedMovie.getStartDate());
                movie.setEndDate(updatedMovie.getEndDate());
                movie.setDuration(updatedMovie.getDuration());
                movieToUpdate = movie;
                break;
            }
        }

        if (movieToUpdate != null) {
            try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE movie SET movieName = ?, movieGenre = ?, movieActors = ?, movieDescription = ?, " +
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

    public void reserveTickets(int ID, int wishedReservedSeats) throws Exception {
        Movie movieToChangeSeats = null;
        int newSeatsAmount = 0;
        for (Movie movie : movieList) {
            if (movie.getID() == ID) {
                newSeatsAmount = movie.getRemainingSeats() - wishedReservedSeats; // Change from getMaxSeats to
                                                                                  // getRemainingSeats
                if (newSeatsAmount < 0) {
                    throw new Exception("You can't book more seats than the remaining.");
                } else {
                    movie.setRemainingSeats(newSeatsAmount);
                    movieToChangeSeats = movie;
                    break;
                }
            }
        }

        if (movieToChangeSeats != null) {
            // Update the database
            try (Connection con = DriverManager.getConnection(JDBC_DATABASE_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                String sql = "UPDATE movie SET movieRemainingSeats = ? WHERE movieID = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, newSeatsAmount);
                ps.setInt(2, ID);
                ps.executeUpdate(); // Execute the update
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new Exception("Movie not found.");
        }
    }

}
