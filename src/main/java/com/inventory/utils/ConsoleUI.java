package com.inventory.utils;

import com.inventory.model.Product;
import com.inventory.model.Supplier;
import com.inventory.model.Order;
import com.inventory.service.ProductService;
import com.inventory.service.SupplierService;
import com.inventory.service.OrderService;

import java.util.Date;
import java.util.Scanner;

public class ConsoleUI {

    private final ProductService productService;
    private final SupplierService supplierService;
    private final OrderService orderService;

    public ConsoleUI() {
        this.productService = new ProductService();
        this.supplierService = new SupplierService();
        this.orderService = new OrderService();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Add Supplier");
            System.out.println("4. Display All Suppliers");
            System.out.println("5. Add Order");
            System.out.println("6. Display All Orders");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> productService.displayAllProducts();
                case 3 -> addSupplier(sc);
                case 4 -> supplierService.displayAllSuppliers();
                case 5 -> addOrder(sc);
                case 6 -> orderService.displayAllOrders();
                case 7 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct(Scanner sc) {
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        productService.addProduct(new Product(0, name, quantity, price));
    }

    private void addSupplier(Scanner sc) {
        System.out.print("Enter Supplier Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = sc.nextLine();
        supplierService.addSupplier(new Supplier(0, name, contactInfo));
    }

    private void addOrder(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        orderService.addOrder(new Order(0, productId, quantity, new Date()));
    }
}
