# Quantity Measurement System - Use Case 13

## 📌 Overview
This use case adds comparison and sorting capabilities to the quantity system.

---

## 🚀 Features

- Compare two quantities
- Sort list of quantities
- Automatic unit conversion during comparison
- Type safety using generics

---

## ⚙️ Example

### Comparison
1 ft == 12 inches → true

### Sorting
Input:
3 ft, 24 inches, 1 yard

Output:
2 ft, 3 ft, 3 ft

---

## 🧱 Architecture

- Model → Quantity + Units
- Service → Comparison logic
- Controller → Execution
- Test → JUnit validation

---

## ▶️ Run

```bash
java QuantityController