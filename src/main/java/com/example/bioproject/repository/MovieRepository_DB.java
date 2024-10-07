package com.example.bioproject.repository;

import java.util.List;
import java.util.Arrays;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;


import com.example.bioproject.model.MovieModel;

@Repository
public class MovieRepository_DB {

    private JdbcTemplate jdbcTemplate;

    public List<MovieModel> showMovies() {
        String sql = """
                SELECT * FROM movie
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> new MovieModel(
            rs.getInt("movieID"),
            rs.getString("movieName"),
            Arrays.asList(rs.getString("movieActors").split(",")),
            rs.getString("movieDescription"),
            rs.getBoolean("movieAgeRes"),
            rs.getDate("movieStartDate").toLocalDate(),
            rs.getDate("movieEndDate").toLocalDate(),
            rs.getInt("movieLength")
        ));
    }
}
