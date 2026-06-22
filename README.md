# 📏 Quantity Measurement App – Use Case 6

## 📌 Overview

This project implements **addition of length quantities with unit conversion** using clean layered architecture.

It supports operations like:

* Adding same units (Feet + Feet)
* Adding different units (Feet + Inches)
* Returning result in desired unit

---

## 🧱 Project Structure

```
com.src
├── model
│   ├── LengthUnit.java
│   └── QuantityLength.java
│
├── service
│   ├── QuantityService.java
│   └── QuantityServiceImpl.java
│
├── controller
│   └── QuantityController.java
│
└── test
    └── QuantityServiceTest.java
```

---

## ⚙️ Supported Units

* Feet
* Inches
* Yards
* Centimeters

---

## 🚀 Features

✔ Unit conversion before addition
✔ Add same and different units
✔ Add with target unit
✔ Handles edge cases:

* Null inputs
* Negative values
* Large values
* Small decimal values

---

## 🧮 Examples

```
1 ft + 12 in = 2 ft
1 yard + 3 ft = 2 yards
2.54 cm + 1 in = 5.08 cm
```

---

## 🧠 Design Principles

* Separation of Concerns (Model, Service, Controller)
* Interface-based design (loose coupling)
* Reusable and testable code
* Clean and maintainable structure

---

## 🧪 Running Tests

Using JUnit:

```
Run QuantityServiceTest.java
```

Or via Maven:

```
mvn test
```

---

## ▶️ Run Application

Run the main method in:

```
QuantityController.java
```

---

## ⚠️ Validations

* Value must be finite
* Unit cannot be null
* Operands cannot be null

---

## 🔮 Future Enhancements

* Add comparison across units
* Add volume and weight measurements
* Convert to REST API (Spring Boot)
* Add UI layer

---

## ✅ Conclusion

This project demonstrates a **clean implementation of unit-based calculations** using:

* Object-Oriented Design
* Layered Architecture
* Unit Testing

---
