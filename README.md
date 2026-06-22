# UC2: Quantity Measurement Equality (Feet & Inches)

## 📌 Overview

This use case checks equality of measurements for both Feet and Inches using object-oriented principles.

## 🎯 Goal

Compare two measurements of the same unit and determine if they are equal.

## 🧠 Concepts Used

* Object-Oriented Design
* Immutable Classes
* equals() and hashCode()
* Double.compare() for precision
* Layered Architecture
* Unit Testing (JUnit)

## 📁 Structure

* model → Feet, Inches classes
* service → Comparison logic
* controller → Handles flow
* test → Unit tests
* app → Entry point

## ⚙️ Flow

1. User inputs values
2. Controller creates objects
3. Service compares values
4. Result is printed

## 📊 Sample Output

Input: 1.0 inch and 1.0 inch
Output: Equal (true)

Input: 1.0 ft and 1.0 ft
Output: Equal (true)

## 🚀 Benefits

* Clean separation of logic
* Reusable components
* Easy testing
* Industry-standard design

## 🔥 Conclusion

This use case demonstrates how multiple measurement types can be handled cleanly using proper architecture and equality logic.
