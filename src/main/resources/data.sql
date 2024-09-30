CREATE DATABASE IF NOT EXISTS bio;
USE bio;

CREATE TABLE IF NOT EXISTS movie (
    movieID INT AUTO_INCREMENT PRIMARY KEY,
    movieName varchar(255),
    movieActors varchar(255),
    movieDescription varchar(255),
	movieAgeRes BOOLEAN,
    movieStartDate DATE,
    movieEndDate DATE,
    movieLength INT
    );