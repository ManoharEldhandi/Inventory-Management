package com.inventory.dao;

import com.inventory.config.DatabaseConfig;
import com.inventory.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Add a new product
    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.executeUpdate();
        }
    }

    // Retrieve all products
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                ));
            }
        }
        return products;
    }

    // Update product details
    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        }
    }

    // Delete product by ID
    public void deleteProduct(int id) throws SQLException {
        String query = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
