USE dealer_system;

-- Автоматично намаляване на наличност на продукт при поръчка + Забрана за отрицателна наличност
DELIMITER $
CREATE TRIGGER reduce_product_stock
BEFORE INSERT ON order_items
FOR EACH ROW
BEGIN
	DECLARE current_stock INT;
    
    SELECT products.stock_quantity INTO current_stock
    FROM products
    WHERE products.id = NEW.product_id;
    
	IF current_stock < NEW.quantity THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Not enough stock!';
    ELSE
		UPDATE products
		SET products.stock_quantity = products.stock_quantity - NEW.quantity
		WHERE products.id = NEW.product_id;
    END IF;
END $
DELIMITER ;

-- История на цените
DELIMITER $
CREATE TRIGGER price_history
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
	IF OLD.current_price <> NEW.current_price THEN
		UPDATE product_price_history
        SET product_price_history.valid_to = CURRENT_DATE()
        WHERE product_price_history.product_id = OLD.id AND product_price_history.valid_to IS NULL;
        
        INSERT INTO product_price_history(product_id, price, valid_from, valid_to) VALUES
        (NEW.id, NEW.current_price, CURRENT_DATE(), NULL);
	END IF;
END $
DELIMITER ;

-- Ограничение за рейтинг
DELIMITER $
CREATE TRIGGER check_product_ownership_before_rating
BEFORE INSERT ON product_ratings
FOR EACH ROW
BEGIN
	-- Вариант I
	/*DECLARE product_count INT;

    SELECT COUNT(*) INTO product_count
    FROM orders
    JOIN order_items ON orders.id = order_items.order_id
    WHERE orders.dealer_id = NEW.dealer_id AND order_items.product_id = NEW.product_id;

    IF product_count = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Dealer has not purchased this product!';
    END IF;*/
    
    -- Вариант II
	IF NOT EXISTS (
		SELECT 1
		FROM orders
		JOIN order_items ON orders.id = order_items.order_id
		WHERE orders.dealer_id = NEW.dealer_id AND order_items.product_id = NEW.product_id
	) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'You can rate only purchased products';
	END IF;
END $
DELIMITER ;

-- Автоматично записване на статус история
DELIMITER $
CREATE TRIGGER order_history
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
	IF OLD.status_id <> NEW.status_id THEN
		INSERT INTO order_status_history(order_id, status_id, changed_at) VALUES
        (NEW.id, NEW.status_id, NOW());
	END IF;
END $
DELIMITER ;

-- Създаване на поръчка
DELIMITER $
CREATE PROCEDURE CreateOrder(IN dealer_id INT, IN product_id INT, IN quantity INT)
BEGIN
    DECLARE new_order_id INT;
    DECLARE product_price DECIMAL(10, 2);
    
    IF NOT EXISTS (
        SELECT 1 FROM dealers WHERE id = dealer_id
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Dealer does not exist';
    END IF;
    
    IF NOT EXISTS (
        SELECT 1 FROM products WHERE id = product_id
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Product does not exist';
    END IF;
    
    IF quantity <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid quantity';
    END IF;
    
    SELECT products.current_price INTO product_price
    FROM products
    WHERE products.id = product_id;
    
    INSERT INTO orders(dealer_id, status_id) VALUES
    (dealer_id, 1);
	
	-- Вариант I
	/*SELECT MAX(orders.id) INTO new_order_id
    FROM orders;*/
    
    -- Вариант II
    SET new_order_id = LAST_INSERT_ID();
    
    # Вече има съществуващ тригер за: "Автоматично намаляване на наличност на продукт при поръчка + Забрана за отрицателна наличност"
    INSERT INTO order_items(order_id, product_id, quantity, unit_price) VALUES
    (new_order_id, product_id, quantity, product_price);
END $
DELIMITER ;

-- Обща стойност на поръчка
DELIMITER $
CREATE PROCEDURE GetOrderTotal(IN p_order_id INT)
BEGIN
	SELECT order_id, SUM(unit_price * quantity)
    FROM order_items
    WHERE order_id = p_order_id;
END $
DELIMITER ;

-- Най-продавани продукти
DELIMITER $
CREATE PROCEDURE GetTopProducts(IN p_limit INT)
BEGIN
	SELECT products.id, products.name, SUM(order_items.quantity) as total_sold
    FROM products
    JOIN order_items ON products.id = order_items.product_id
    GROUP BY products.id, products.name
    ORDER BY total_sold DESC
    LIMIT p_limit;
END $
DELIMITER ;

-- Промяна на цена
DELIMITER $
CREATE PROCEDURE UpdateProductPrice(IN p_product_id INT, IN p_new_price DECIMAL(10,2 ))
BEGIN
	
END $
DELIMITER ;