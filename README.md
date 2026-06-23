# Quantity Measurement System – UC8

## 📌 Overview

This project implements a **Quantity Measurement System** with support for:

* Unit conversion
* Addition of quantities
* Explicit target unit operations

UC8 focuses on:

> Performing addition of two quantities with a **specified target unit**

---

## 🧱 Project Structure

```
model/
  ├── QuantityLength.java
  ├── LengthUnit.java

service/
  ├── QuantityLengthService.java
  ├── QuantityLengthServiceImpl.java

controller/
  ├── QuantityLengthController.java

test/
  ├── QuantityLengthServiceTest.java
```

---

## 🚀 Features (UC8)

### ✅ 1. Unit Conversion

Convert between:

* Feet ↔ Inches
* Feet ↔ Yard
* Feet ↔ Centimeter

---

### ✅ 2. Addition (Same / Different Units)

Supports:

```
1 FEET + 1 FEET = 2 FEET
```

---

### ✅ 3. Addition with Target Unit (UC8 Core Feature ⭐)

You can specify the result unit explicitly:

```
1 FEET + 12 INCHES → result in INCHES = 24 INCHES
1 FEET + 12 INCHES → result in FEET = 2 FEET
```

---

### ✅ 4. Equality Check

Compares values across units:

```
36 INCHES == 1 YARD ✔
```

---

## 🧪 Example Usage

### Conversion

```
QuantityLength q = new QuantityLength(1, FEET);
q.convertTo(INCHES); // 12
```

### Addition (UC8)

```
service.add(q1, q2, INCHES);
```

---

## ⚙️ Design Principles

* ✔ Immutable Model Objects
* ✔ Validation (No NaN / Infinite values)
* ✔ Base Unit Conversion (Feet)
* ✔ Separation of Concerns
* ✔ Clean Service Layer

---

## 🧮 Core Logic

All operations convert values to a **base unit (Feet)**:

```
Step 1: Convert both values to Feet  
Step 2: Perform operation  
Step 3: Convert result to target unit  
```

---

## 🧪 Running Tests

Using Maven:

```
mvn test
```

Or run test class from IDE:

```
QuantityLengthServiceTest
```

---

## ❗ Validations

* Null unit → ❌ Exception
* NaN / Infinite values → ❌ Exception
* Null inputs in service → ❌ Exception

---

## 🎯 Use Case Coverage

| Use Case | Description                          |
| -------- | ------------------------------------ |
| UC1–UC5  | Basic equality & conversion          |
| UC6      | Addition (default unit)              |
| UC7      | Addition with unit flexibility       |
| **UC8**  | ⭐ Addition with explicit target unit |

---

## 📌 Summary

UC8 enhances the system by:

* Allowing flexible result units
* Supporting real-world measurement scenarios
* Improving usability of addition operations

---

## 👨‍💻 Author

Quantity Measurement Assignment – Clean Code Implementation
