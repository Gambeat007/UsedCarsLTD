CREATE TABLE VEHICLES (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   make VARCHAR(20) NOT NULL,
   model VARCHAR(20) NOT NULL,
   prod_year INTEGER NOT NULL,
   price FLOAT NOT NULL,
   fuel_type VARCHAR(20)
);

CREATE TABLE CUSTOMERS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(120) NOT NULL
);

CREATE TABLE ROLES (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20)
);

-- CREATE TABLE USERS (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(30),
--     email VARCHAR(50),
--     password VARCHAR(120)
-- );