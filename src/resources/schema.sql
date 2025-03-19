-- Database creation
CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

-- Products Table
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Suppliers Table
CREATE TABLE IF NOT EXISTS suppliers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contactInfo VARCHAR(200) NOT NULL
);

-- Orders Table
CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    quantity INT NOT NULL,
    orderDate DATE NOT NULL,
    FOREIGN KEY (productId) REFERENCES products(id) ON DELETE CASCADE
);
