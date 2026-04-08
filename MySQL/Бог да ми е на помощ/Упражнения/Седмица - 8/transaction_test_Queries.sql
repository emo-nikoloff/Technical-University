USE transaction_test;

SELECT customers.name, customer_accounts.amount
FROM customers
JOIN customer_accounts ON customers.id = customer_accounts.customer_id;

BEGIN;

UPDATE customer_accounts
JOIN customers ON customer_accounts.customer_id = customers.id
SET customer_accounts.amount = customer_accounts.amount - 50000
WHERE customers.name = 'Stoyan Pavlov Pavlov'
AND customer_accounts.currency = 'BGN';

UPDATE customer_accounts
JOIN customers ON customer_accounts.customer_id = customers.id
SET customer_accounts.amount = customer_accounts.amount + 50000
WHERE customers.name = 'Ivan Petrov Iordanov'
AND customer_accounts.currency = 'BGN';

COMMIT;