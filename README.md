**Inventory Management System - Project Guide**

**Project Overview**

The Inventory Management System is a Java-based application designed to efficiently manage product inventory, suppliers, and customer orders using MySQL as the database. 
The system offers the following features:

Add Product: Add new products to the inventory.
Display All Products: View a list of all available products.
Add Supplier: Add supplier details for product sourcing.
Display All Suppliers: View a list of all suppliers.
Add Order: Manage and record customer orders.
Display All Orders: List all recorded orders.


**Project Folder Structure**
```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/inventory/
│   │   │   │   ├── Main.java
│   │   │   │   ├── config/
│   │   │   │   │   └── DatabaseConfig.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── Product.java
│   │   │   │   │   ├── Supplier.java
│   │   │   │   │   └── Order.java
│   │   │   │   ├── dao/
│   │   │   │   │   ├── ProductDAO.java
│   │   │   │   │   ├── SupplierDAO.java
│   │   │   │   │   └── OrderDAO.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── ProductService.java
│   │   │   │   │   ├── SupplierService.java
│   │   │   │   │   └── OrderService.java
│   │   │   │   └── utils/
│   │   │   │       └── ConsoleUI.java
│   └── resources/
│       └── db/schema.sql
├── lib/
│   └── mysql-connector-j-9.2.0.jar
├── .gitignore
├── README.md
└── inventory_db.sql
```
**Setup Instructions**
Follow these steps to set up and run the project:

**Step 1: Setup MySQL Database**
	1.	Start the MySQL server:
 	2.	Log in to MySQL:
  3.	Create the inventory_db database:
  4.	Import the provided schema file:
    command: mysql -u root -p inventory_db < src/resources/db/schema.sql

Step 2: Add MySQL Connector (if not added)
Create the lib folder (if it doesn’t exist) and move the .jar file:
    command: mkdir lib
             mv ~/Downloads/mysql-connector-j-9.2.0.jar lib/

**Step 3: Compile the Java Files**
Run the following commands in sequence:
1. Compile Config Class```
   command: javac -d out -cp "out:lib/mysql-connector-j-9.2.0.jar" src/main/java/com/inventory/config/DatabaseConfig.java ```
3. Compile Model Classes```
   command: javac -d out -cp "lib/mysql-connector-j-9.2.0.jar" src/main/java/com/inventory/model/*.java```
4. Compile DAO Classes```
   command: javac -d out -cp "out:lib/mysql-connector-j-9.2.0.jar" src/main/java/com/inventory/dao/*.java```
5. Compile Utility Class```
   command: javac -d out -cp "out:lib/mysql-connector-j-9.2.0.jar" src/main/java/com/inventory/utils/ConsoleUI.java```
6. Compile Service Classes```
   command: javac -d out -cp "out:lib/mysql-connector-j-9.2.0.jar" src/main/java/com/inventory/service/*.java```
7. Compile Main Class```
   command: javac -d out -cp "out:lib/mysql-connector-j-9.2.0.jar" src/main/java/com/inventory/Main.java```

**Step 4: Run the Project**
Run the application with the .jar file included:```
command: java -cp "out:lib/mysql-connector-j-9.2.0.jar" com.inventory.Main```
 
**Key Features**
```
✅ Add, Update, and Delete Products
✅ Manage Supplier Information
✅ Create and Track Orders
✅ Real-time Data Storage Using MySQL
✅ Console-based User Interface for Seamless Interaction
✅ Structured Codebase with Clear Separation of Concerns
```
Important Notes
Ensure MySQL Server is running before starting the project.
If any permission errors occur, use sudo where required.
Ensure all dependencies (like the MySQL Connector JAR file) are correctly added to the lib/ folder.

