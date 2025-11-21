# java-library-project
---
# 📚 Library Management System

A robust console-based Java application designed to manage library members, borrowing transactions, and administrative statistics. This project demonstrates the use of **Object-Oriented Programming (OOP)** principles, including encapsulation, static members, and control flow logic.

---

## 👥 Project Team
**Computer Science Department**

| Student Name | University ID |
| :--- | :--- |
| **Sultan Daham Hamad Al-Anzi** | **446102803** |
| **Faisal Abdullah Ibrahim Al-Suwaid** | **446105494** |

---

## 🚀 Project Overview
This system simulates a library environment where members can log in, borrow books, and return them. It also includes an Administrator panel to track the library's total revenue and operational statistics.

### Key Features:
* **Member Authentication:** Pre-loaded user accounts (Hamad, Sultan, Ahmed).
* **Borrowing Logic:**
    * Limit of **5 books** per member.
    * Fees calculation (**0.50** per transaction).
    * Option to borrow multiple books at once.
* **Return System:** Validates that the user has books to return.
* **Admin Dashboard:**
    * View **Total Revenue**.
    * Analyze the **Most Frequent Operation** (Borrowing vs. Returning vs. Viewing).
* **Input Validation:** Prevents errors when non-integer values are entered.

---

## 🛠️ Technical Implementation
The project utilizes the following Java concepts:
- **Encapsulation:** Private instance variables (`id`, `name`, `borrowedCount`) accessed via Getters/Setters.
- **Static Variables:** Global tracking for `TotalRevenue` and operation counts across all objects.
- **Control Flow:** Usage of `switch` statements, `do-while` loops for menus, and `if-else` for logic validation.
- **Scanner Class:** Robust handling of user inputs.

---

## 💻 How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Sultan-ALanzi/java-library-project.git](https://github.com/Sultan-ALanzi/java-library-project.git)
    ```
2.  **Open in IDE:** Import the project folder into Eclipse or IntelliJ IDEA.
3.  **Run the Application:** Locate `Member.java` and run the `main` method.



