CREATE DATABASE IF NOT EXISTS kea;
USE kea;

CREATE TABLE IF NOT EXISTS movie (
    movieID INT AUTO_INCREMENT PRIMARY KEY,
    movieName varchar(255),
    movieActors varchar(255),
    movieDescription varchar(255),
	movieAgeRes INT,
    movieStartDate varchar(255),
    movieEndDate varchar(255),
    movieLength INT,
    movieMaxSeats INT,
    movieRemainingSeats INT,
    movieTheater INT
    );

    INSERT INTO movie (movieName, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength, movieMaxSeats, movieRemainingSeats, movieTheater)
    VALUES 
    ('The Quantum Paradox', 'Chris Evans, Emma Watson', 'A thrilling sci-fi adventure about time travel and alternate dimensions.', 13, '2024-10-15', '2024-12-01', 145, 120, 120, 1),
    ('Mystic River', 'Leonardo DiCaprio, Meryl Streep', 'A suspenseful mystery about a small-town detective uncovering dark secrets.', 16, '2024-09-20', '2024-11-05', 132, 150, 75, 2);
