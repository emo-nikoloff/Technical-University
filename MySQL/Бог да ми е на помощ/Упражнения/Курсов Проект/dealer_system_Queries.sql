USE dealer_system;

SELECT * FROM products WHERE current_price > 2000;

SELECT products.name AS ProductName, SUM(order_items.quantity) AS TotalSold
FROM order_items
JOIN products ON order_items.product_id = products.id
GROUP BY products.name;

SELECT 
    orders.id AS OrderId,
    suppliers.name AS SupplierName,
    dealers.name AS DealerName,
    products.name AS ProductName,
    order_items.quantity AS Quantity,
    order_items.unit_price AS ProductPrice,
    (order_items.quantity * order_items.unit_price) AS TotalPrice,
    orders.order_date AS OrderDate
FROM orders
JOIN dealers ON orders.dealer_id = dealers.id
JOIN order_items ON orders.id = order_items.order_id
JOIN products ON order_items.product_id = products.id
JOIN suppliers ON products.supplier_id = suppliers.id
ORDER BY orders.id;

SELECT products.name AS ProductName, product_ratings.rating AS ProductRating
FROM products
LEFT JOIN product_ratings ON products.id = product_ratings.product_id;

SELECT products.name AS ProductName, products.current_price AS ProductPrice
FROM products
WHERE current_price > (
    SELECT AVG(products.current_price)
    FROM products
);

SELECT 
    dealers.name AS DealersName,
    SUM(order_items.quantity * order_items.unit_price) AS TotalSpent
FROM dealers
JOIN orders ON dealers.id = orders.dealer_id
JOIN order_items ON orders.id = order_items.order_id
GROUP BY dealers.id, dealers.name
ORDER BY TotalSpent DESC
LIMIT 1;

DELIMITER $
CREATE TRIGGER order_status_update
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
    IF OLD.status_id <> NEW.status_id THEN
        INSERT INTO order_status_history(order_id, status_id, changed_at)
        VALUES (NEW.id, NEW.status_id, NOW());
    END IF;
END $
DELIMITER ;

UPDATE orders
SET status_id = 2
WHERE id = 1;

UPDATE orders
SET status_id = 3
WHERE id = 1;

SELECT * FROM order_status_history;

DROP PROCEDURE ProductStockReport;
DELIMITER $
CREATE PROCEDURE ProductStockReport()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE product_name VARCHAR(150);
    DECLARE product_stock INT;
    DECLARE product_price DECIMAL(10,2);

    DECLARE product_cursor CURSOR FOR
        SELECT products.name, products.stock_quantity, products.current_price
        FROM products;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    
    CREATE TEMPORARY TABLE temp_report (
        product VARCHAR(150),
        price DECIMAL(10,2),
        stock INT,
        inventory_value DECIMAL(10,2)
    );

    OPEN product_cursor;
    read_loop: LOOP
        FETCH product_cursor INTO product_name, product_stock, product_price;

        IF done THEN
            LEAVE read_loop;
        END IF;
        
        INSERT INTO temp_report
        VALUES (
            product_name,
            product_price,
            product_stock,
            product_stock * product_price
        );
    END LOOP;
    CLOSE product_cursor;
    
    SELECT * FROM temp_report;
    
    DROP TEMPORARY TABLE temp_report;
END $
DELIMITER ;

CALL ProductStockReport();