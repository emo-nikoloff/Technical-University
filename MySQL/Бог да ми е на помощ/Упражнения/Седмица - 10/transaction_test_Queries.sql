USE transaction_test;

DELIMITER $
CREATE PROCEDURE convert_currency(
    IN input_amount DOUBLE,
    IN from_currency VARCHAR(10),
    IN to_currency VARCHAR(10),
    OUT result_amount DOUBLE
)
BEGIN
    IF from_currency = 'BGN' AND to_currency = 'EUR' THEN
        SET result_amount = input_amount / 1.95583;
        
    ELSEIF from_currency = 'EUR' AND to_currency = 'BGN' THEN
        SET result_amount = input_amount * 1.95583;
        
    ELSE
        SET result_amount = NULL;
    END IF;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE transfer_money(
    IN from_account_id INT,
    IN to_account_id INT,
    IN transfer_amount DOUBLE
)
BEGIN
    DECLARE from_balance DOUBLE;
    DECLARE to_balance DOUBLE;
    DECLARE from_currency VARCHAR(10);
    DECLARE to_currency VARCHAR(10);
    DECLARE converted_amount DOUBLE;

    START TRANSACTION;

    SELECT amount, currency 
    INTO from_balance, from_currency
    FROM customer_accounts
    WHERE id = from_account_id;

    SELECT amount, currency 
    INTO to_balance, to_currency
    FROM customer_accounts
    WHERE id = to_account_id;

    IF (from_currency NOT IN ('BGN','EUR')) OR (to_currency NOT IN ('BGN','EUR')) THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Unsupported currency!';
    END IF;

    IF from_balance < transfer_amount THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds!';
    END IF;

    IF from_currency = to_currency THEN
        SET converted_amount = transfer_amount;
    ELSE
        CALL convert_currency(transfer_amount, from_currency, to_currency, converted_amount);
    END IF;

    UPDATE customer_accounts
    SET amount = amount - transfer_amount
    WHERE id = from_account_id;

    UPDATE customer_accounts
    SET amount = amount + converted_amount
    WHERE id = to_account_id;

    COMMIT;

END $
DELIMITER ;