package com.inventory.dao;

import com.inventory.config.DatabaseConfig;
import com.inventory.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // Add a new order
    public void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO orders (productId, quantity, orderDate) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, order.getProductId());
            stmt.setInt(2, order.getQuantity());
            stmt.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.executeUpdate();
        }
    }

    // Retrieve all orders
    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("id"),
                        rs.getInt("productId"),
                        rs.getInt("quantity"),
                        rs.getDate("orderDate")
                ));
            }
        }
        return orders;
    }

    // Update order details
    public void updateOrder(Order order) throws SQLException {
        String query = "UPDATE orders SET productId = ?, quantity = ?, orderDate = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, order.getProductId());
            stmt.setInt(2, order.getQuantity());
            stmt.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setInt(4, order.getId());
            stmt.executeUpdate();
        }
    }

    // Delete order by ID
    public void deleteOrder(int id) throws SQLException {
        String query = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
