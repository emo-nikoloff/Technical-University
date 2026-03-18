CREATE DATABASE hospital;
USE hospital;

CREATE TABLE doctors(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    cabinet VARCHAR(50),
    specialization VARCHAR(100),
    works_with_nhif BOOLEAN,
    phone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE patients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    egn VARCHAR(10) UNIQUE
);

CREATE TABLE treatments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    
    patient_id INT,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    
    diagnosis VARCHAR(255),
    treatment TEXT,
    medications TEXT,
    start_date DATE,
    end_date DATE
);

ALTER TABLE doctors
DROP specialization;

CREATE TABLE specialization(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

ALTER TABLE doctors
ADD specialization_id INT;

ALTER TABLE doctors
ADD FOREIGN KEY (specialization_id) REFERENCES specialization(id);