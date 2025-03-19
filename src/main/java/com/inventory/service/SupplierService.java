package com.inventory.service;

import com.inventory.dao.SupplierDAO;
import com.inventory.model.Supplier;
import java.sql.SQLException;
import java.util.List;

public class SupplierService {

    private final SupplierDAO supplierDAO;

    public SupplierService() {
        this.supplierDAO = new SupplierDAO();
    }

    // Add supplier service method
    public void addSupplier(Supplier supplier) {
        try {
            supplierDAO.addSupplier(supplier);
            System.out.println("Supplier added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding supplier: " + e.getMessage());
        }
    }

    // Get all suppliers service method
    public void displayAllSuppliers() {
        try {
            List<Supplier> suppliers = supplierDAO.getAllSuppliers();
            if (suppliers.isEmpty()) {
                System.out.println("No suppliers available.");
            } else {
                suppliers.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching supplier list: " + e.getMessage());
        }
    }

    // Update supplier service method
    public void updateSupplier(Supplier supplier) {
        try {
            supplierDAO.updateSupplier(supplier);
            System.out.println("Supplier updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating supplier: " + e.getMessage());
        }
    }

    // Delete supplier service method
    public void deleteSupplier(int id) {
        try {
            supplierDAO.deleteSupplier(id);
            System.out.println("Supplier deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting supplier: " + e.getMessage());
        }
    }
}
