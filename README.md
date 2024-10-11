# DSA Test Platform

A Java/Maven-based platform for users to implement Data Structures and Algorithms (DSA) solutions and automatically test their code.

## Features

- **Interface Definitions:** Provides interfaces for various DSA problems.
- **Solution Implementations:** Reference solutions for users to compare against.
- **Automated Testing:** Uses JUnit 5 and Maven Surefire for testing user implementations.
- **Code Quality Checks:** Integrates Checkstyle for enforcing coding standards.

## Prerequisites

- **Java:** JDK 11 or higher
- **Maven:** 3.6.0 or higher

## Setup Instructions

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/MR-Elbarbary/DSA_machine.git
   ```

2. **Inter the Repository**
   ```bash
   cd DSA_machine/demo
   ```
3. **Compile project:**
   ```bash
   mvn compile
   ```

### to Test your work do

```bash
mvn -Dtest="testName"+"Test" test
```

### example

```bash
mvn -Dtest=ArrayListTest test
```
