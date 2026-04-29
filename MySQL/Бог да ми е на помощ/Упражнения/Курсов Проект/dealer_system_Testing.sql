USE dealer_system;

DELIMITER $
CREATE TRIGGER reduce_product_quantity
AFTER INSERT ON order_items
FOR EACH ROW
BEGIN
	UPDATE products
    SET products.stock_quantity = products.stock_quantity - NEW.quantity
    WHERE id = NEW.product_id;
END $
DELIMITER ;

DROP PROCEDURE GetTopProducts;
DELIMITER $
CREATE PROCEDURE GetTopProducts(IN start_date DATE, IN end_date DATE)
BEGIN
	DECLARE done INT DEFAULT 0;
	DECLARE product_id INT;
    DECLARE product_name VARCHAR(255);
    DECLARE product_price DECIMAL(10,2);
    DECLARE product_total_orders INT;
    
    DECLARE product_cursor CURSOR FOR
		SELECT products.id, products.name, products.current_price, SUM(order_items.quantity) AS total_orders
        FROM order_items
        JOIN orders ON orders.id = order_items.order_id
        JOIN products ON products.id = order_items.product_id
        WHERE orders.order_date BETWEEN start_date AND end_date
        GROUP BY products.id
        ORDER BY total_orders DESC;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    
    CREATE TEMPORARY TABLE temp_top_products (
        product_id INT,
        product_name VARCHAR(255),
        product_price DECIMAL(10,2),
        total_sold INT
    );
    
    OPEN product_cursor;
    
    read_loop: LOOP
		FETCH product_cursor INTO product_id, product_name, product_price, product_total_orders;
        
        IF done THEN
			LEAVE read_loop;
		END IF;
        
        INSERT INTO temp_top_products
        VALUES (product_id, product_name, product_price, product_total_orders);
	END LOOP;
    CLOSE product_cursor;
    
    SELECT * FROM temp_top_products;
    
    DROP TEMPORARY TABLE temp_top_products;
END $
DELIMITER ;

CALL GetTopProducts('2025-01-01', '2025-01-31');