INSERT INTO VEHICLES (id, make, model, prod_year, price, fuel_type)
VALUES
(1, 'Skoda', 'Superb', 2018, 99500.50, 'DIESEL'),
(2, 'Skoda', 'Rapid', 2015, 45200.00, 'PETROL'),
(3, 'Jaguar', 'XF', 2022, 290000.00, 'DIESEL');

INSERT INTO CUSTOMERS (id, name, email, password, transaction_type, vehicle_id)
VALUES
(1, 'Nowak Jan', 'nowak.jan@nowak.com', 'nowak1234', 'SALE', 1),
(2, 'Nowak Karol', 'nowak.karol@nowak.com', '123456', 'SALE', 2),
(3, 'Maliniak Jan', 'maliniak@gmail.com', 'haslo1234', 'PURCHASE', 3);