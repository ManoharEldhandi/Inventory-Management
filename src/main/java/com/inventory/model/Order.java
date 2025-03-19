package com.inventory.model;

import java.util.Date;

public class Order {

    private int id;
    private int productId;
    private int quantity;
    private Date orderDate;

    // Constructor
    public Order(int id, int productId, int quantity, Date orderDate) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Display order details
    @Override
    public String toString() {
        return "Order ID: " + id + ", Product ID: " + productId + ", Quantity: " + quantity + ", Order Date: " + orderDate;
    }
}
