DROP DATABASE IF EXISTS dealer_system;
CREATE DATABASE dealer_system;
USE dealer_system;

CREATE TABLE suppliers(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(150) NOT NULL,
    country VARCHAR(200),
    city VARCHAR(200),
    address VARCHAR(200),
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE products(
	id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT NOT NULL,
    category_id INT NOT NULL,
	name VARCHAR(150) NOT NULL,
    description text,
    current_price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    
    FOREIGN KEY (supplier_id)
        REFERENCES suppliers(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
	FOREIGN KEY (category_id)
        REFERENCES categories(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
        
	CHECK (current_price > 0),
    CHECK (stock_quantity >= 0)
);

CREATE TABLE product_price_history(
	id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    valid_from DATE NOT NULL,
    valid_to DATE,
    
    FOREIGN KEY(product_id)
        REFERENCES products(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	
    CHECK (price > 0),
    CHECK (valid_to IS NULL OR valid_to >= valid_from)
);

CREATE TABLE dealers(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(150) NOT NULL,
    country VARCHAR(200),
    city VARCHAR(200),
    address VARCHAR(200),
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE product_views(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dealer_id INT NOT NULL,
    product_id INT NOT NULL,
    viewed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY(dealer_id)
        REFERENCES dealers(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
	FOREIGN KEY(product_id)
        REFERENCES products(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE product_ratings(
	id INT AUTO_INCREMENT PRIMARY KEY,
    dealer_id INT NOT NULL,
	product_id INT NOT NULL,
    rating TINYINT NOT NULL,
    comment VARCHAR(255),
    rated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
	UNIQUE(dealer_id, product_id),

    FOREIGN KEY(dealer_id)
        REFERENCES dealers(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    FOREIGN KEY(product_id)
        REFERENCES products(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
        
	CHECK (rating BETWEEN 1 AND 5)
);

CREATE TABLE order_statuses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
	dealer_id INT NOT NULL,
    status_id INT NOT NULL,
    order_date DATE NOT NULL DEFAULT (CURRENT_DATE),
    
    FOREIGN KEY(dealer_id)
        REFERENCES dealers(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
	FOREIGN KEY(status_id)
        REFERENCES order_statuses(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE order_items(
	id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
	product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,

	UNIQUE(order_id, product_id),

    FOREIGN KEY(order_id)
        REFERENCES orders(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(product_id)
        REFERENCES products(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
        
	CHECK (quantity > 0),
    CHECK (unit_price > 0)
);

CREATE TABLE order_status_history(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    status_id INT NOT NULL,
    changed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(order_id)
        REFERENCES orders(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	FOREIGN KEY(status_id)
        REFERENCES order_statuses(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

INSERT INTO suppliers(name, country, city, address, email, phone) VALUES
('Tech Solutions Ltd.', 'Germany', 'Berlin', 'Unter den Linden 12', 'contact@techsolutions.de', '+49301234567'),
('Global Devices Inc.', 'USA', 'San Francisco', 'Market Street 1355', 'sales@globaldevices.com', '+14155551234'),
('ElectroWorld', 'Bulgaria', 'Sofia', 'Tsarigradsko Shose Blvd 115', 'info@electroworld.bg', '+35929876543');

INSERT INTO categories(name) VALUES
('Laptops'),
('Smartphones'),
('Peripherals');

INSERT INTO products(supplier_id, category_id, name, description, current_price, stock_quantity) VALUES
(1, 1, 'Dell XPS 15', 'High-end ultrabook laptop', 3200.00, 15),
(1, 1, 'Lenovo ThinkPad X1', 'Business class laptop', 2800.00, 20),
(2, 2, 'iPhone 14 Pro', 'Apple smartphone', 2200.00, 30),
(2, 2, 'Samsung Galaxy S23', 'Android flagship phone', 1800.00, 25),
(3, 3, 'Logitech MX Master 3', 'Wireless mouse', 120.00, 100),
(3, 3, 'Keychron K6', 'Mechanical keyboard', 200.00, 60);

INSERT INTO product_price_history(product_id, price, valid_from, valid_to) VALUES
(1, 3000.00, '2024-01-01', '2024-12-31'),
(1, 3200.00, '2025-01-01', NULL),
(3, 2000.00, '2024-06-01', '2024-12-31'),
(3, 2200.00, '2025-01-01', NULL);

INSERT INTO dealers(name, country, city, address, email, phone) VALUES
('Ivan Petrov Ltd.', 'Bulgaria', 'Sofia', 'Vitosha Blvd 25', 'ivan.petrov@dealer.bg', '+359888123456'),
('Plamen Georgiev EOOD', 'Bulgaria', 'Plovdiv', 'Kapitan Raycho 10', 'plamen.georgiev@dealer.bg', '+359889654321'),
('Nikola Dimitrov Trade', 'Bulgaria', 'Varna', 'Slivnitsa Blvd 88', 'nikola.dimitrov@dealer.bg', '+359887112233');

INSERT INTO product_views(dealer_id, product_id) VALUES
(1, 1), (1, 1), (1, 2), (1, 3),
(2, 1), (2, 3), (2, 4),
(3, 2), (3, 5), (3, 6);

INSERT INTO product_ratings(dealer_id, product_id, rating, comment) VALUES
(1, 1, 5, 'Excellent performance'),
(1, 3, 4, 'Very good phone'),
(2, 1, 4, 'Solid laptop'),
(2, 4, 5, 'Amazing device'),
(3, 5, 3, 'Average mouse'),
(3, 6, 5, 'Great keyboard');

INSERT INTO order_statuses(name) VALUES
('New'),
('Processing'),
('Shipped'),
('Delivered');

INSERT INTO orders(dealer_id, status_id, order_date) VALUES
(1, 1, '2025-01-10'),
(1, 2, '2025-01-15'),
(2, 3, '2025-02-05'),
(3, 4, '2025-03-12');

INSERT INTO order_items(order_id, product_id, quantity, unit_price) VALUES
(1, 1, 2, 3200.00),
(1, 5, 3, 120.00),
(2, 2, 1, 2800.00),
(2, 6, 2, 200.00),
(3, 3, 2, 2200.00),
(4, 4, 1, 1800.00);

INSERT INTO order_status_history(order_id, status_id, changed_at) VALUES
(1, 1, '2025-01-10 10:00:00'),
(1, 2, '2025-01-11 12:00:00'),
(2, 1, '2025-01-15 09:00:00'),
(2, 2, '2025-01-16 14:00:00'),
(3, 1, '2025-02-05 11:30:00'),
(3, 3, '2025-02-06 16:00:00');