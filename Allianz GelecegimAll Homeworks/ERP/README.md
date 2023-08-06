# ERP (Enterprise Resource Planning) System

The ERP System is a comprehensive business management solution that allows organizations to manage various aspects of their operations, including customer orders, products, invoices, and more.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- - [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
    - [Accessing Swagger UI](#accessing-swagger-ui)
- [Modules](#modules)
    - [Order Management](#order-management)
    - [Product Management](#product-management)
    - [Settings Management](#settings-management)
- [Generating Invoices](#generating-invoices)
- [OrderProductEntity](#orderproductentity)

## Introduction

The ERP System is designed to streamline and enhance business processes by providing a user-friendly interface for managing orders, products, and invoices. It also offers settings management to configure various aspects of the application.

## Features

- Create and manage customer orders
- Track product inventory and quantities
- Generate invoices for confirmed orders
- Configure application settings
- ...

## Getting Started

### Prerequisites

- Java 8 or higher
- Spring Boot
- PostgreSQL database

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/erp-system.git
   cd erp-system
   ```
2. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```

## Usage

Access the application by navigating to `http://localhost:8080` in your web browser. Log in and start managing your orders, products, and settings.

## Accessing Swagger UI

Swagger UI is integrated into the application for easy API documentation and testing. To access Swagger UI, navigate to `http://localhost:8080/swagger-ui.html` in your web browser.

## Modules

### Order Management

The Order Management module allows users to create, view, and manage customer orders. Orders can include multiple products with quantities, prices, and tax information.

### Product Management

The Product Management module enables users to add, update, and view product details, including name, stock quantity, price, and tax status.

### Settings Management

The Settings Management module allows administrators to configure application settings, including tax rates and other global parameters.

### Generating Invoices

As soon as an order is confirmed, the application automatically generates an invoice for the order. The invoice includes details about the products, quantities, prices, taxes, and the total amount. Invoices are stored in the database for future reference.

## OrderProductEntity

The `OrderProductEntity` class represents a snapshot of a product at the time an order is created. It includes information about the product, such as name, price, quantity, and tax status. This information is used to generate accurate invoices and manage inventory.