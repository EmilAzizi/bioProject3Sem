CREATE DATABASE IF NOT EXISTS kea;
USE kea;

drop table if exists movie;

CREATE TABLE IF NOT EXISTS movie (
    movieID INT AUTO_INCREMENT PRIMARY KEY,
    movieName varchar(255),
    movieGenre varchar(255),
    movieActors varchar(255),
    movieDescription varchar(255),
	movieAgeRes INT,
    movieStartDate varchar(255),
    movieEndDate varchar(255),
    movieLength INT,
    movieMaxSeats INT,
    movieRemainingSeats INT,
    movieTheaterID INT
    );

    CREATE TABLE IF NOT EXISTS kiosk (
        kioskID INT AUTO_INCREMENT PRIMARY KEY,
        kioskName varchar(255),
        kioskPrice DOUBLE,
        kioskAmount INT
    );

    INSERT INTO kiosk (kioskName, kioskPrice)
    VALUES
        ('Popcorn - Small', 3.50),
        ('Popcorn - Medium', 5.00),
        ('Popcorn - Large', 6.50),
        ('Coca-Cola - Small', 2.00),
        ('Coca-Cola - Medium', 3.00),
        ('Coca-Cola - Large', 4.00),
        ('Nachos', 4.50),
        ('Hot Dog', 5.00),
        ('Candy Mix', 3.00),
        ('Water Bottle', 1.50);


INSERT INTO movie (movieName, movieGenre, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength, movieMaxSeats, movieRemainingSeats, movieTheaterID)
    VALUES 
    ('The Quantum Paradox', 'sci-fi', 'Chris Evans, Emma Watson', 'A thrilling sci-fi adventure about time travel and alternate dimensions.', 13, '2024-10-15', '2024-12-01', 145, 120, 120, 1),
    ('Mystic River', 'thriller', 'Leonardo DiCaprio, Meryl Streep', 'A suspenseful mystery about a small-town detective uncovering dark secrets.', 16, '2024-09-20', '2024-11-05', 132, 150, 75, 2);
