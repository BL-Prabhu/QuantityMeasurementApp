# Quantity Measurement Application

## Use Case 16 – Save Data to Database (H2)


### 📌 Overview

In this use case, we implemented functionality to **store quantity measurement results into an H2 database**. This helps in persisting comparison results or calculation outcomes for future reference.

---

### 🚀 Features

* Save measurement results into database
* Store operation type (e.g., COMPARE)
* Track success or error status
* Lightweight in-memory database using H2
* Simple repository-based design

---

### 🛠️ Technologies Used

* Java
* JDBC
* H2 Database (In-Memory)
* JUnit (for testing)

---

### 📂 Project Structure

```
entity/
 └── QuantityMeasurementEntity.java

repository/
 └── QuantityMeasurementDatabaseRepository.java

test/
 └── QuantityMeasurementDatabaseRepositoryTest.java
```

---

### 🧱 Entity Class

Represents the data stored in the database.

Fields:

* `boolean result`
* `boolean hasError`
* `String message`

---

### 💾 Repository Layer

Handles database operations:

* Establish connection with H2
* Insert data into table

---

### 🧪 Test Case

The test verifies that data is successfully saved in the database.

Example:

```java
QuantityMeasurementEntity entity =
    new QuantityMeasurementEntity(true, false, "COMPARE");

repo.save(entity);
```

---

### 🗄️ H2 Database Configuration

Default URL:

```
jdbc:h2:mem:testdb
```

H2 Console:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:testdb
```

---

### ▶️ How to Run

1. Run the test class:

   ```
   QuantityMeasurementDatabaseRepositoryTest
   ```

2. Check console output:

   ```
   Data saved successfully
   ```

3. (Optional) Open H2 Console and verify table data

---

### ✅ Expected Output

* Data should be inserted into the database table
* No runtime errors
* Console prints success message

---

### 📌 Conclusion

Use Case 16 demonstrates how to integrate a simple database (H2) with Java to persist application data. This is a foundational step toward building scalable backend systems.

---

### 🔮 Next Improvements

* Add retrieval (SELECT) functionality
* Use Spring Boot + JPA
* Add validation and exception handling
* Convert to production database (MySQL/PostgreSQL)

---
