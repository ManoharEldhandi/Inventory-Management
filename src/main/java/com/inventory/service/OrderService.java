package com.inventory.service;

import com.inventory.dao.OrderDAO;
import com.inventory.model.Order;
import java.sql.SQLException;
import java.util.List;

public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
    }

    // Add order service method
    public void addOrder(Order order) {
        try {
            orderDAO.addOrder(order);
            System.out.println("Order added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding order: " + e.getMessage());
        }
    }

    // Get all orders service method
    public void displayAllOrders() {
        try {
            List<Order> orders = orderDAO.getAllOrders();
            if (orders.isEmpty()) {
                System.out.println("No orders available.");
            } else {
                orders.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching order list: " + e.getMessage());
        }
    }

    // Update order service method
    public void updateOrder(Order order) {
        try {
            orderDAO.updateOrder(order);
            System.out.println("Order updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating order: " + e.getMessage());
        }
    }

    // Delete order service method
    public void deleteOrder(int id) {
        try {
            orderDAO.deleteOrder(id);
            System.out.println("Order deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting order: " + e.getMessage());
        }
    }
}
