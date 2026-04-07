CREATE DATABASE dealer_system;
USE dealer_system;

CREATE TABLE suppliers(
	id int AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(150) NOT NULL,
    country VARCHAR(200),
    city VARCHAR(200),
    address VARCHAR(200),
    email VARCHAR(100),
    phone VARCHAR(15)
);

CREATE TABLE products(
	id int AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT NOT NULL, FOREIGN KEY(supplier_id) REFERENCES suppliers(id),
	name VARCHAR(150) NOT NULL,
    description text,
    current_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE product_price_history(
	id int AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL, FOREIGN KEY(product_id) REFERENCES products(id),
    price DECIMAL(10, 2) NOT NULL,
    valid_from DATE NOT NULL,
    valid_to DATE
);

CREATE TABLE dealers(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(150) NOT NULL,
    country VARCHAR(200),
    city VARCHAR(200),
    address VARCHAR(200),
    email VARCHAR(100),
    phone VARCHAR(15)
);

CREATE TABLE product_views(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dealer_id INT NOT NULL, FOREIGN KEY(dealer_id) REFERENCES dealers(id),
    product_id INT NOT NULL, FOREIGN KEY(product_id) REFERENCES products(id),
    viewed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product_ratings(
	id INT AUTO_INCREMENT PRIMARY KEY,
    dealer_id INT NOT NULL, FOREIGN KEY(dealer_id) REFERENCES dealers(id),
	product_id INT NOT NULL, FOREIGN KEY(product_id) REFERENCES products(id),
    UNIQUE (dealer_id, product_id),
    rating TINYINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment VARCHAR(255),
    rated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dealer_id INT NOT NULL, FOREIGN KEY(dealer_id) REFERENCES dealers(id),
    order_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'New'
);

CREATE TABLE order_items(
	id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL, FOREIGN KEY(order_id) REFERENCES orders(id),
	product_id INT NOT NULL, FOREIGN KEY(product_id) REFERENCES products(id),
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE order_status_history(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL, FOREIGN KEY(order_id) REFERENCES orders(id),
    status VARCHAR(50) NOT NULL,
    changed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);