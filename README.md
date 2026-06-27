# 📘 Use Case 17: Get Operation Count

## 🧾 Description

This use case allows users to retrieve the **total number of times a specific operation** (e.g., compare, add) has been performed in the system.

It helps in tracking usage statistics and understanding how frequently certain operations are executed.

---

## 🎯 Objective

To provide a simple API that returns the count of a given operation performed by users.

---

## 📥 Input

* **Operation Name** (Path Variable)

   * Type: `String`
   * Example:

     ```
     COMPARE
     ADD
     ```

---

## 📤 Output

* Returns the total count of the requested operation.

### Example Response:

```
5
```

---

## 🔗 API Endpoint

### GET Request

```
/api/v1/quantities/count/{operation}
```

### Example:

```
/api/v1/quantities/count/COMPARE
```

---

## ⚙️ Controller Layer

The controller exposes the endpoint:

```java
@GetMapping("/count/{operation}")
public ResponseEntity<Long> getOperationCount(@PathVariable String operation) {
    return ResponseEntity.ok(service.getOperationCount(operation));
}
```

---

## 🧠 Service Layer

Handles the business logic:

```java
@Override
public Long getOperationCount(String operation) {
    return repository.countByOperation(operation.toLowerCase());
}
```

---

## 🗄️ Repository Layer

Responsible for fetching count from database:

```java
Long countByOperation(String operation);
```

---

## 🧪 Test Case

### Test Scenario: Successful Count Fetch

```java
@Test
void testGetOperationCount_Success() throws Exception {

    when(service.getOperationCount("COMPARE"))
            .thenReturn(5L);

    mockMvc.perform(get("/api/v1/quantities/count/COMPARE"))
            .andExpect(status().isOk())
            .andExpect(content().string("5"));

    verify(service, times(1))
            .getOperationCount("COMPARE");
}
```

---

## ✅ Expected Behavior

* Returns HTTP **200 OK**
* Returns operation count as plain text or JSON number
* Case-insensitive operation handling (recommended)

---

## ❌ Error Handling

| Scenario          | Response                  |
| ----------------- | ------------------------- |
| Invalid operation | 0 or custom error         |
| Service failure   | 500 Internal Server Error |

---

## 📌 Notes

* Operation names should be standardized (e.g., uppercase or lowercase)
* Useful for analytics and monitoring system usage
* Can be extended to support date-based filtering

---

## 🚀 Example Curl

```bash
curl -X GET http://localhost:8080/api/v1/quantities/count/COMPARE
```

---

## 📊 Use Cases

* Track feature usage
* Monitor system behavior
* Generate reports and insights

---

## 🏁 Summary

Use Case 17 provides a simple and efficient way to retrieve how many times a specific operation has been executed, enabling better tracking and analytics within the Quantity Measurement system.
