# 🛒 Said Market App Backend 📦

Welcome to the **Supermarket App Backend**! This app is built with **Spring Boot** to handle all your supermarket needs, from managing products and orders. Dive in and get started with our handy API documentation and setup instructions! 🚀

---

## 🌟 Features

- 🛍️ **Product Management:** Add, update, delete, and list all products in the supermarket.
- 📦 **Inventory Control:** Manage stock and ensure products are available.
- 🧾 **Order Processing:** Create, update, and track customer orders.

---

## 📚 Documentation

Check out our **API Documentation** for detailed endpoints and usage:
- **Swagger UI**: Start the server and visit `http://localhost:3000/api/swagger-ui/index.html` 📖 to explore the endpoints interactively.
  
---

## Data Base
- SQL instructions for the Database, run in SQL Sheell terminal:
https://drive.google.com/file/d/1DZTGB-BC3LqoZLN_UK8uyt4_eZP-MfBl/view
https://drive.google.com/file/d/1MhNMwcxSvRYNfA8H3NjOtixSPM6Ovwaa/view

---

## 🔒 Environment Variables

Create an `.env` file in the root directory with the following configuration to manage environment variables:

```plaintext
DB_URL=jdbc:postgresql://localhost:{port}/{databsename}
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password
