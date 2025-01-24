# ERP System API - Testing Guide with Postman

This document provides step-by-step instructions on how to test the ERP System API using [Postman](https://www.postman.com/).

---

## Table of Contents
1. [Getting Started](#getting-started)
2. [Available Endpoints](#available-endpoints)
   - [Inventory Management](#inventory-management)
   - [Employee Management](#employee-management)
3. [Postman Setup](#postman-setup)
4. [Testing API Endpoints](#testing-api-endpoints)
   - [Get All Products](#get-all-products)
   - [Add a Product](#add-a-product)
   - [Update Product Quantity](#update-product-quantity)
   - [Delete a Product](#delete-a-product)
   - [Get All Employees](#get-all-employees)
   - [Add an Employee](#add-an-employee)
   - [Update an Employee](#update-an-employee)
   - [Delete an Employee](#delete-an-employee)
5. [Troubleshooting](#troubleshooting)

---

## Getting Started

1. Ensure your **Spring Boot application** is running:
   - Open a terminal and run:
     ```bash
     mvn spring-boot:run
     ```
   - By default, the application is hosted at `http://localhost:8080`.

2. Download and install [Postman](https://www.postman.com/downloads/) if you haven't already.

---

## Available Endpoints

### Inventory Management
- **Base URL**: `http://localhost:8080/inventory/products`

| Endpoint                  | Method | Description                          |
|---------------------------|--------|--------------------------------------|
| `/inventory/products`     | GET    | Fetch all products                  |
| `/inventory/products`     | POST   | Add a new product                   |
| `/inventory/products/{id}`| PUT    | Update product quantity by ID       |
| `/inventory/products/{id}`| DELETE | Delete a product by ID              |

### Employee Management
- **Base URL**: `http://localhost:8080/employees`

| Endpoint               | Method | Description                     |
|------------------------|--------|---------------------------------|
| `/employees`           | GET    | Fetch all employees            |
| `/employees`           | POST   | Add a new employee             |
| `/employees/{id}`      | PUT    | Update employee details by ID  |
| `/employees/{id}`      | DELETE | Delete an employee by ID       |

---

## Postman Setup

1. **Create a New Collection**:
   - Open Postman.
   - Click **Collections** → **+ New Collection**.
   - Name it "ERP System API".

2. **Add Requests**:
   - Add requests for each endpoint listed in the [Available Endpoints](#available-endpoints) section.
   - Save each request under the "ERP System API" collection.

---

## Testing API Endpoints

### Inventory Management

#### 1. **Get All Products**
   - **Method**: `GET`
   - **URL**: `http://localhost:8080/inventory/products`
   - **Expected Response** (if products exist):
     ```json
     [
         {
             "id": 1,
             "name": "Laptop",
             "description": "High-performance laptop",
             "quantity": 10,
             "price": 1200.50
         }
     ]
     ```

#### 2. **Add a Product**
   - **Method**: `POST`
   - **URL**: `http://localhost:8080/inventory/products`
   - **Headers**:
     - `Content-Type: application/json`
   - **Body** (raw, JSON):
     ```json
     {
         "name": "Smartphone",
         "description": "Flagship smartphone",
         "quantity": 20,
         "price": 800.00
     }
     ```
   - **Expected Response**:
     ```json
     {
         "id": 2,
         "name": "Smartphone",
         "description": "Flagship smartphone",
         "quantity": 20,
         "price": 800.00
     }
     ```

#### 3. **Update Product Quantity**
   - **Method**: `PUT`
   - **URL**: `http://localhost:8080/inventory/products/{id}`
     - Replace `{id}` with the product ID (e.g., `1`).
   - **Headers**:
     - `Content-Type: application/json`
   - **Body** (raw, JSON):
     ```json
     {
         "quantity": 15
     }
     ```
   - **Expected Response**:
     ```json
     {
         "id": 1,
         "name": "Laptop",
         "description": "High-performance laptop",
         "quantity": 15,
         "price": 1200.50
     }
     ```

#### 4. **Delete a Product**
   - **Method**: `DELETE`
   - **URL**: `http://localhost:8080/inventory/products/{id}`
     - Replace `{id}` with the product ID (e.g., `1`).
   - **Expected Response**: `204 No Content`

---

### Employee Management

#### 1. **Get All Employees**
   - **Method**: `GET`
   - **URL**: `http://localhost:8080/employees`
   - **Expected Response**:
     ```json
     [
         {
             "id": 1,
             "name": "John Doe",
             "role": "Manager",
             "salary": 50000.00
         }
     ]
     ```

#### 2. **Add an Employee**
   - **Method**: `POST`
   - **URL**: `http://localhost:8080/employees`
   - **Headers**:
     - `Content-Type: application/json`
   - **Body** (raw, JSON):
     ```json
     {
         "name": "Alice Johnson",
         "role": "Designer",
         "salary": 45000.00
     }
     ```
   - **Expected Response**:
     ```json
     {
         "id": 2,
         "name": "Alice Johnson",
         "role": "Designer",
         "salary": 45000.00
     }
     ```

#### 3. **Update Employee Role and Salary**
   - **Method**: `PUT`
   - **URL**: `http://localhost:8080/employees/{id}`
     - Replace `{id}` with the employee ID (e.g., `1`).
   - **Headers**:
     - `Content-Type: application/json`
   - **Body** (raw, JSON):
     ```json
     {
         "role": "Lead Designer",
         "salary": 50000.00
     }
     ```
   - **Expected Response**:
     ```json
     {
         "id": 1,
         "name": "Alice Johnson",
         "role": "Lead Designer",
         "salary": 50000.00
     }
     ```

#### 4. **Delete an Employee**
   - **Method**: `DELETE`
   - **URL**: `http://localhost:8080/employees/{id}`
     - Replace `{id}` with the employee ID (e.g., `1`).
   - **Expected Response**: `204 No Content`

---

## Troubleshooting

### **Common Issues**
1. **Whitelabel Error Page**:
   - Ensure the application is running at `http://localhost:8080`.
   - Verify you are using the correct endpoint URLs.

2. **404 Not Found**:
   - Check that the endpoint exists in your application.
   - Verify the URL and HTTP method.

3. **500 Internal Server Error**:
   - Check the application logs for more details.

4. **Empty Responses**:
   - Add data via the `POST` endpoints or directly in the database.

---

Enjoy testing your ERP System API! 🚀
