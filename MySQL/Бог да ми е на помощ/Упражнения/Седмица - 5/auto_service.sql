CREATE DATABASE auto_service;
USE auto_service;

CREATE TABLE clients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    phoneNumber VARCHAR(20)
);

CREATE TABLE cars(
	id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(255),
    plateNumber VARCHAR(20),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE services(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    price DECIMAL(10, 2)
);

CREATE TABLE employees(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    position DECIMAL(10, 2)
);

CREATE TABLE repairs(
	id INT AUTO_INCREMENT PRIMARY KEY,
    
    car_id INT,
    FOREIGN KEY (car_id) REFERENCES cars(id),
    
    service_id INT,
    FOREIGN KEY (service_id) REFERENCES services(id),
    
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(id),

    repair_date DATE
);