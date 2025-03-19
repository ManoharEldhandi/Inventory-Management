package com.inventory.service;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    // Add product service method
    public void addProduct(Product product) {
        try {
            productDAO.addProduct(product);
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
        }
    }

    // Get all products service method
    public void displayAllProducts() {
        try {
            List<Product> products = productDAO.getAllProducts();
            if (products.isEmpty()) {
                System.out.println("No products available.");
            } else {
                products.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product list: " + e.getMessage());
        }
    }

    // Update product service method
    public void updateProduct(Product product) {
        try {
            productDAO.updateProduct(product);
            System.out.println("Product updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
        }
    }

    // Delete product service method
    public void deleteProduct(int id) {
        try {
            productDAO.deleteProduct(id);
            System.out.println("Product deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
    }
}
