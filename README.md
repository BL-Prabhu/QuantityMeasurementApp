# Quantity Measurement System - Use Case 11 (Volume)

## 📌 Overview
This project implements a generic measurement system supporting:

- Volume Conversion
- Equality Comparison
- Addition of quantities

Using a scalable generic design.

---

## ⚙️ Supported Units

| Unit        | Conversion |
|------------|-----------|
| LITRE       | Base Unit |
| MILLILITRE  | 0.001 L   |
| GALLON      | 3.78541 L |

---

## 🧱 Architecture

- Model → Core logic (Quantity, Units)
- Service → Business operations
- Controller → Execution layer
- Test → JUnit validation

---

## 🚀 Features

✅ Generic Quantity class  
✅ Cross-unit conversion  
✅ Equality using base unit  
✅ Addition with target unit  
✅ Cross-category safety

---

## 🧪 Example

```java
Quantity<VolumeUnit> litre = new Quantity<>(1, LITRE);
Quantity<VolumeUnit> ml = new Quantity<>(1000, MILLILITRE);

litre.equals(ml); // true
litre.convertTo(MILLILITRE); // 1000
litre.add(ml); // 2 litres