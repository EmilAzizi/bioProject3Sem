package com.example.bioproject.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ScreenRepository {

    private String JDBC_USERNAME = "root";
    private String JDBC_DATABASE_URL = "jdbc:mysql://localhost:3306/kea";
    private String JDBC_PASSWORD = "Emperiusvalor1!";

    public String reserveTicket(String userEmail, int amountReserved) {
        
        return userEmail;
    }
}
