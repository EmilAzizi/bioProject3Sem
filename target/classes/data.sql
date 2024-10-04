CREATE DATABASE IF NOT EXISTS kea;
USE kea;

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

INSERT INTO movie (movieName, movieActors, movieDescription, movieAgeRes, movieStartDate, movieEndDate, movieLength)
VALUES
    ('Inception', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.', true, '2010-07-16', '2020-07-16', 148),
    ('The Dark Knight', 'Christian Bale, Heath Ledger, Aaron Eckhart', 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.', true, '2008-07-18', '2018-07-18', 152),
    ('Interstellar', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.', true, '2014-11-07', '2024-11-07', 169),
    ('The Matrix', 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', true, '1999-03-31', '2009-03-31', 136),
    ('The Shawshank Redemption', 'Tim Robbins, Morgan Freeman, Bob Gunton', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', true, '1994-09-23', '2004-09-23', 142);