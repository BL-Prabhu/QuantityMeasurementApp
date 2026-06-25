 feature/UC15-N-Tier-Architectures-Refactor
# Use Case 15: Quantity Conversion Feature

## 📌 Overview

This use case implements the **Quantity Conversion Feature**, which allows users to convert values from one unit to another (e.g., meters to kilometers, grams to kilograms).

The system ensures accurate conversion using predefined conversion factors and supports multiple unit types.

---

## 🎯 Objectives

* Convert quantities between different units
* Ensure type-safe and accurate conversions
* Provide reusable and scalable conversion logic

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* REST API
* Maven

---

## 📂 Project Structure

* `model` → Contains `Quantity` class
* `service` → Business logic for conversion
* `controller` → API endpoints
* `exception` → Custom error handling

---

## ⚙️ Functionality

### 1. Create Quantity

* User provides value and unit
* Example: `10 meters`

### 2. Convert Quantity

* Convert from one unit to another
* Example: `meters → kilometers`

### 3. Supported Units

* Length → meter, kilometer, centimeter
* Weight → gram, kilogram
* (Extendable for more units)

---

## 🔁 Sample API

### Convert Quantity API

**POST** `/api/quantity/convert`

#### Request Body:

```json
{
  "value": 1000,
  "fromUnit": "meter",
  "toUnit": "kilometer"
}
```

#### Response:

```json
{
  "convertedValue": 1,
  "unit": "kilometer"
}
```

---

## ❗ Error Handling

* Invalid unit → returns error message
* Unsupported conversion → handled gracefully
* Null or negative values → validation error

---

## 🔐 Validation Rules

* Value must be positive
* Units must belong to the same category
* Conversion must be supported

---

## 🚀 Future Enhancements

* Add temperature conversion
* Add currency conversion
* Support dynamic unit configuration
* Integrate with database

---

## ✅ Conclusion

This use case demonstrates a clean and scalable way to implement **unit conversion logic** using Java and Spring Boot, making it easy to extend for additional unit types in the future.
=======
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
 dev
