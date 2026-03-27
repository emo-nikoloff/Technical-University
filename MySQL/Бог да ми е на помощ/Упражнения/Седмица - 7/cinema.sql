CREATE DATABASE cinema;
USE cinema;

CREATE TABLE cinemas(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE halls(
	id INT AUTO_INCREMENT PRIMARY KEY,
    number INT,
    status ENUM('Standard', 'VIP', 'Deluxe'),
    cinema_id INT, FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
);

CREATE TABLE movies(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    year INT,
    country VARCHAR(50) NOT NULL
);

CREATE TABLE projections(
	id INT AUTO_INCREMENT PRIMARY KEY,
    time INT,
    hall_id INT, FOREIGN KEY (hall_id) REFERENCES halls(id),
    movie_id INT, FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE TABLE clients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE tickets(
	id INT AUTO_INCREMENT PRIMARY KEY,
    price FLOAT,
    projections_id INT, FOREIGN KEY (projections_id) REFERENCES projections(id),
    client_id INT, FOREIGN KEY (client_id) REFERENCES clients(id)
);

INSERT INTO cinemas (name) VALUES
('Arena Mladost'),
('Cinema City'),
('Grand Cinema');

INSERT INTO halls (number, status, cinema_id) VALUES
(1, 'VIP', 1),
(2, 'Standard', 1),
(3, 'Deluxe', 1),
(1, 'VIP', 2),
(2, 'Standard', 2),
(1, 'Deluxe', 3);

INSERT INTO movies (name, year, country) VALUES
('Final Destination 7', 2023, 'USA'),
('Inception', 2010, 'USA'),
('Avatar', 2009, 'USA');

INSERT INTO projections (time, hall_id, movie_id) VALUES
(105, 1, 1),
(105, 3, 1),
(148, 2, 2),
(105, 4, 1),
(162, 6, 3);

INSERT INTO clients (name) VALUES
('Ivan Petrov'),
('Maria Ivanova'),
('Georgi Georgiev'),
('Elena Dimitrova');

INSERT INTO tickets (price, projections_id, client_id) VALUES
(12.50, 1, 1),
(12.50, 1, 2),
(15.00, 2, 3),
(13.00, 4, 4);

SELECT cinemas.name, halls.number, projections.time
FROM projections
JOIN halls ON projections.hall_id = halls.id
JOIN cinemas ON halls.cinema_id = cinemas.id
JOIN movies ON projections.movie_id = movies.id
WHERE movies.name = 'Final Destination 7' AND halls.status IN ('VIP', 'Deluxe')
ORDER BY cinemas.name ASC, halls.number ASC;

SELECT COUNT(tickets.id)
FROM tickets
JOIN projections ON tickets.projections_id = projections.id
JOIN halls ON projections.hall_id = halls.id
JOIN cinemas ON halls.cinema_id = cinemas.id
JOIN movies ON projections.movie_id = movies.id
WHERE movies.name = 'Final Destination 7' AND cinemas.name = 'Arena Mladost' AND halls.status = 'VIP';