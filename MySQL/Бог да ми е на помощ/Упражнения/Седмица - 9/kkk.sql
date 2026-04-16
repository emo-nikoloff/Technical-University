USE transaction_test;

DELIMITER $
CREATE PROCEDURE transferMoney(
    IN fromAccountId INT,
    IN toAccountId INT,
    IN amountInput DOUBLE
)
BEGIN
    DECLARE fromBalance DOUBLE;

    START TRANSACTION;

    SELECT amount 
    INTO fromBalance
    FROM customer_accounts
    WHERE id = fromAccountId;

    IF fromBalance IS NULL THEN
        ROLLBACK;
        SELECT 'Невалидна сметка на подателя' AS message;
    ELSEIF fromBalance < amountInput THEN
        ROLLBACK;
        SELECT 'Недостатъчна наличност' AS message;
    ELSE
        UPDATE customer_accounts
        SET amount = amount - amountInput
        WHERE id = fromAccountId;

        IF ROW_COUNT() = 0 THEN
            ROLLBACK;
            SELECT 'Грешка при теглене' AS message;
        ELSE
            UPDATE customer_accounts
            SET amount = amount + amountInput
            WHERE id = toAccountId;
            IF ROW_COUNT() = 0 THEN
                ROLLBACK;
                SELECT 'Грешка при превод към получателя' AS message;
            ELSE
                COMMIT;
                SELECT 'Успешна транзакция' AS message;
            END IF;
        END IF;
    END IF;

END $
DELIMITER ;

CALL transferMoney(1, 2, 50);