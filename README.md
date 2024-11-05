# 🛒 Said Market App Backend 📦

Welcome to the **Said Market App Backend**! This application, built with **Spring Boot**, manages various supermarket operations, including product management and order processing. Follow the instructions below to set up and run the application using Docker. 🚀

---

## 🌟 Features

- 🛍️ **Product Management:** Add, update, delete, and list all products in the supermarket.
- 📦 **Inventory Control:** Manage stock levels to ensure product availability.
- 🧾 **Order Processing:** Create, update, and track customer orders.
- 🐳 **Docker Image:** Available at `docker pull saljure/said_market:latest`.

---

## 🐳 Running the Application with Docker

The application can be easily deployed using Docker. The repository includes a `docker-compose.yml` file that sets up both the backend application and a PostgreSQL database.

### Prerequisites

- [Docker](https://www.docker.com/get-started) installed on your machine.
- [Docker Compose](https://docs.docker.com/compose/install/) installed (if not included with Docker).

### Steps to Run

1. **Clone the Repository:**

   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Create a `.env` File:**

   In the root directory of the repository, create a `.env` file with the following content:

   ```env
   DB_URL=jdbc:postgresql://super_market:5432/said_market
   DB_USERNAME=your_db_username
   DB_PASSWORD=your_db_password
   ```

   Replace `your_db_username` and `your_db_password` with your actual database credentials.

3. **Run Docker Compose:**

   Start the application and the database by executing:

   ```bash
   docker-compose up
   ```

   This command will pull the necessary images, build the containers, and start both the `said-market` backend service and the PostgreSQL database.

4. **Access the Application:**

   Once the application is running, access the API documentation via **Swagger UI**:

   - Open a browser and navigate to `http://localhost:8080/api/swagger-ui/index.html` to interactively explore the endpoints.

5. **Stop the Containers:**

   To stop the containers, press `CTRL + C` in the terminal or run:

   ```bash
   docker-compose down
   ```

---

## 📚 Documentation

For detailed information on the API endpoints and their usage, refer to the **API Documentation**:

- **Swagger UI:** After starting the server, visit `http://localhost:8080/api/swagger-ui/index.html` to explore the endpoints interactively.

---

## 💾 Database

The application utilizes PostgreSQL as its database. To initialize the database schema, use the provided SQL scripts:

- **Database SQL Scripts:**
  - [Schema Setup](https://drive.google.com/file/d/1DZTGB-BC3LqoZLN_UK8uyt4_eZP-MfBl/view)
  - [Sample Data](https://drive.google.com/file/d/1MhNMwcxSvRYNfA8H3NjOtixSPM6Ovwaa/view)

Place these SQL files in the project directory; they will be automatically loaded into the database container.

---

## 🔒 Environment Variables

Manage environment variables by creating a `.env` file in the root directory. Example configuration:

```env
DB_URL=jdbc:postgresql://super_market:5432/said_market
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password
```

Replace `your_db_username` and `your_db_password` with your actual database credentials.


