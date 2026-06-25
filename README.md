# Quantity Measurement Application

## Use Case 14 – Quantity Comparison

---

### 📌 Overview

Use Case 14 focuses on comparing two quantities of the **same measurement type** (e.g., length, weight, temperature) after converting them into a common unit.

This ensures accurate comparison even when units differ (e.g., feet vs inches).

---

### 🚀 Features

* Compare two quantities with different units
* Automatic unit conversion before comparison
* Supports multiple measurement types (Length, Weight, Temperature)
* Returns boolean result (true/false)

---

### 🛠️ Technologies Used

* Java
* Object-Oriented Design (OOP)
* Service Layer Architecture
* DTO Pattern

---

### 📂 Project Structure

```id="xv9k2q"
controller/
 └── QuantityMeasurementController.java

service/
 └── QuantityMeasurementServiceImpl.java

model/
 └── Quantity.java
 └── IMeasurable.java

dto/
 └── QuantityDTO.java
```

---

### 🔄 Flow of Execution

1. User provides input via `QuantityDTO`
2. Controller receives request
3. Service layer processes comparison
4. Quantities are converted to a common unit
5. Comparison is performed
6. Result is returned

---

### 🧪 Example

```java id="u1v7ka"
controller.performComparison(
    new QuantityDTO(1, "FEET", "LENGTH"),
    new QuantityDTO(12, "INCHES", "LENGTH")
);
```

---

### ⚙️ How It Works

* 1 FEET = 12 INCHES
* Both values are converted into the same unit
* Then compared

```id="o9m3fw"
1 FEET == 12 INCHES → TRUE
```

---

### ✅ Expected Output

```id="7w4t2c"
Comparison Result: true
```

---

### ❗ Validation Rules

* Units must belong to the same measurement type
* Null values are not allowed
* Invalid units throw an error

---

### 📌 Key Methods

#### In `Quantity` class:

```java id="7c3v2l"
public boolean equals(Quantity<U> other)
```

#### In Service:

```java id="9m4xka"
public boolean compare(QuantityDTO q1, QuantityDTO q2)
```

---

### 📊 Supported Conversions (Example)

| Type   | Units Supported     |
| ------ | ------------------- |
| Length | FEET, INCHES, YARD  |
| Weight | KG, GRAM            |
| Temp   | CELSIUS, FAHRENHEIT |

---

### 📌 Conclusion

Use Case 14 ensures accurate and flexible comparison of quantities by handling unit conversion internally. This improves correctness and usability of the system.

---

### 🔮 Future Enhancements

* Add more units (miles, pounds, etc.)
* Precision handling (decimal rounding)
* API endpoint for comparison
* UI integration

---
