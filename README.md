# UC1: Quantity Measurement Equality (Feet)

## 📌 Overview

This use case checks whether two measurements in feet are equal using object-oriented design principles.

## 🎯 Goal

Compare two `Feet` objects and determine if they represent the same value.

## 🧠 Concepts Used

* Object-Oriented Design
* Immutable Objects
* equals() and hashCode()
* Double comparison using Double.compare()
* Layered Architecture (Model-Service-Controller)
* Unit Testing (JUnit)

## 📁 Project Structure

* model → Represents data (Feet)
* service → Business logic
* controller → Handles flow
* test → Unit tests
* app → Main entry point

## ⚙️ Flow

1. User provides two values
2. Controller creates Feet objects
3. Service compares using equals()
4. Result is printed

## 📊 Sample Output

Input: 1.0 ft and 1.0 ft
Output: Equal (true)

## 🚀 Benefits

* Clean separation of concerns
* Reusable business logic
* Easy to test
* Follows industry standards

## 🔥 Conclusion

This use case demonstrates how basic equality logic can be structured into a scalable and maintainable architecture.
