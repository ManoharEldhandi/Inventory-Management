package com.inventory.dao;

import com.inventory.config.DatabaseConfig;
import com.inventory.model.Supplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {

    // Add a new supplier
    public void addSupplier(Supplier supplier) throws SQLException {
        String query = "INSERT INTO suppliers (name, contactInfo) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getContactInfo());
            stmt.executeUpdate();
        }
    }

    // Retrieve all suppliers
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM suppliers";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                suppliers.add(new Supplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("contactInfo")
                ));
            }
        }
        return suppliers;
    }

    // Update supplier details
    public void updateSupplier(Supplier supplier) throws SQLException {
        String query = "UPDATE suppliers SET name = ?, contactInfo = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getContactInfo());
            stmt.setInt(3, supplier.getId());
            stmt.executeUpdate();
        }
    }

    // Delete supplier by ID
    public void deleteSupplier(int id) throws SQLException {
        String query = "DELETE FROM suppliers WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
