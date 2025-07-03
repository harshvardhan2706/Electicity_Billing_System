-- Database: ebs

-- DROP DATABASE IF EXISTS ebs;

CREATE DATABASE ebs
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United Kingdom.1252'
    LC_CTYPE = 'English_United Kingdom.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- 1. Create Database
CREATE DATABASE ebs;

-- 2. Connect to Database (in psql or client)
-- \c ebs

-- 3. Create login table
CREATE TABLE login (
    meter_no VARCHAR(20) PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(20) NOT NULL,
    "user" VARCHAR(20) NOT NULL -- "user" is a reserved keyword, quoted
);

-- 4. Create customer table
CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    meter_no VARCHAR(20) UNIQUE NOT NULL,
    address VARCHAR(50),
    city VARCHAR(30),
    state VARCHAR(30),
    email VARCHAR(40),
    phone VARCHAR(20),
    FOREIGN KEY (meter_no) REFERENCES login(meter_no)
);

-- 5. Create meter_info table
CREATE TABLE meter_info (
    meter_no VARCHAR(20) PRIMARY KEY,
    meter_location VARCHAR(20),
    meter_type VARCHAR(20),
    phase_code VARCHAR(20),
    bill_type VARCHAR(20),
    days INTEGER,
    FOREIGN KEY (meter_no) REFERENCES login(meter_no)
);

-- 6. Create tax table
CREATE TABLE tax (
    tax_id SERIAL PRIMARY KEY,
    cost_per_unit NUMERIC(10, 2) NOT NULL,
    meter_rent NUMERIC(10, 2) NOT NULL,
    service_charge NUMERIC(10, 2) NOT NULL,
    service_tax NUMERIC(10, 2) NOT NULL,
    swacch_bharat_cess NUMERIC(10, 2) NOT NULL,
    fixed_tax NUMERIC(10, 2) NOT NULL
);

-- 7. Insert values into tax table
INSERT INTO tax (cost_per_unit, meter_rent, service_charge, service_tax, swacch_bharat_cess, fixed_tax)
VALUES (9, 47, 22, 57, 6, 18);

-- 8. Create bill table
CREATE TABLE bill (
    bill_id SERIAL PRIMARY KEY,
    meter_no VARCHAR(20) NOT NULL,
    month VARCHAR(30) NOT NULL,
    units INTEGER NOT NULL,
    totalbill NUMERIC(10, 2) NOT NULL,
    status VARCHAR(20),
    FOREIGN KEY (meter_no) REFERENCES login(meter_no)
);

	