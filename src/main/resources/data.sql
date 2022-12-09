INSERT INTO VEHICLES(make, model, prod_year, price, fuel_type) VALUES
('Skoda', 'Superb', 2018, 99500.50, 'DIESEL'),
('Skoda', 'Rapid', 2015, 45200.00, 'PETROL'),
('Jaguar', 'XF', 2022, 290000.00, 'DIESEL');

INSERT INTO CUSTOMERS(name, email, password) VALUES
('Nowak Jan', 'nowak.jan@nowak.com', 'nowak1234'),
('Nowak Karol', 'nowak.karol@nowak.com', '123456'),
('Maliniak Jan', 'maliniak@gmail.com', 'haslo1234');

INSERT INTO ROLES(name) VALUES
('ROLE_OWNER'),
('ROLE_CUSTOMER'),
('ROLE_PUBLIC');

-- INSERT INTO USERS(username, email, password) VALUES
-- ('John Owner','owner@owner.com','ownerpass');