# Quantity Measurement System – UC10

## 📌 Overview

UC10 introduces a **Generic Quantity Measurement System** using:

* Generics
* Abstraction (`IMeasurable`)
* Multi-unit support (Length + Weight)

---

## 🧱 Architecture

```
model/
  ├── IMeasurable.java
  ├── Quantity.java
  ├── LengthUnit.java
  ├── WeightUnit.java

service/
  ├── QuantityService.java
  ├── QuantityServiceImpl.java

controller/
  ├── QuantityController.java

test/
  ├── QuantityServiceTest.java
```

---

## 🚀 Features

### ✅ Generic Design

Single `Quantity<U>` class supports:

* Length
* Weight
* Any future measurement

---

### ✅ Conversion

```
1 FEET → 12 INCHES
1 KG → 1000 GRAM
```

---

### ✅ Addition

```
1 FEET + 12 INCHES = 2 FEET
1 KG + 1000 GRAM = 2 KG
```

---

### ✅ Equality

```
12 INCHES == 1 FEET
1000 GRAM == 1 KG
```

---

### ✅ Type Safety (🔥 UC10 Highlight)

```
Length ≠ Weight
```

Cross comparison is prevented.

---

## ⚙️ Core Design

### Interface: IMeasurable

Defines:

* Conversion to base unit
* Conversion from base unit

---

### Generic Class: Quantity<U>

* Works with any unit type
* Uses base unit conversion internally

---

## 🧪 Running Tests

```
mvn test
```

---

## 📐 Logic Flow

```
Convert → Base Unit → Perform Operation → Convert Back
```

---

## 🎯 Use Case Coverage

| Use Case | Description                          |
| -------- | ------------------------------------ |
| UC1–UC5  | Equality & conversion                |
| UC6      | Addition                             |
| UC7      | Addition with unit                   |
| UC8      | Explicit target unit                 |
| UC9      | Service layer                        |
| **UC10** | ⭐ Generic + multi-measurement system |

---

## 🔥 Key Advantages

* Reusable design
* Extensible (Temperature, Volume, etc.)
* Clean architecture
* Strong type safety
* Interview-ready design

---

## 👨‍💻 Author

Clean Code – Quantity Measurement System
