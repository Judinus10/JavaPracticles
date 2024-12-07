
# Java Exercises Project  
*A collection of Java exercises to practice loops, arrays, multithreading, and basic programming concepts.*  

---

## 📋 Table of Contents  
1. [About the Project](#about-the-project)  
2. [Packages and Classes](#packages-and-classes)  
3. [Installation](#installation)  
4. [Usage](#usage)  
5. [Technologies Used](#technologies-used)  
6. [Contributing](#contributing)  
7. [Contact](#contact)  

---

## 📖 About the Project  

This project contains multiple packages that cover a variety of Java exercises. The exercises include loops, arrays, and multithreading concepts. Each exercise is designed to help you enhance your problem-solving skills and understanding of core Java.  

---

## 📦 Packages and Classes  

### **Package: Loops**  
Contains exercises to master looping constructs (`for` and `while`).  

1. **`EvenAndOdd.java`**  
   - Find and print all even or odd numbers between 1 and 50 using both `for` and `while` loops.  

2. **`Factorials.java`**  
   - Prompt the user for a number and calculate its factorial using both `for` and `while` loops.  

3. **`NumberPrint.java`**  
   - Print numbers from 1 to 10 using both `for` and `while` loops.  

4. **`Sum.java`**  
   - Prompt the user for a number `n` and calculate the sum of numbers from 1 to `n` using both `for` and `while` loops.  

5. **`FibonacciSequence.java `**
   - Generate the Fibonacci sequence up to n terms.
   
6.  **`MultiplicationTable.java `**
   - Generate and print the multiplication table of a number entered by the user.

7. **`ReverseNumber.java `**
   - Reverse the digits of a given integer using a loop.

8. **`PrimeNumberCheck.java `**
   - Check if a number is prime or not.

9. **`CountDigits.java `**
   - Count the number of digits in an integer.

10. **`SumOfDigits.java `**
    - Calculate the sum of the digits of a number.
---
  

---

### **Package: Arrays**  
Contains exercises to practice array operations such as summation, finding max/min, and searching elements.  

1. **`Sum.java`**  
   - Prompt the user for an array length and elements, then calculate and display the sum of the elements.  

2. **`FindMaxAndMin.java`**  
   - Find and print the maximum and minimum elements of a user-defined array.  

3. **`PrintArray2.java`**  
   - Prompt the user for an array and display its elements in a formatted manner.  

4. **`PrintArray1.java`**  
   - Demonstrates two methods to print a pre-defined array using `for` and `for-each` loops.  

5. **`SearchElement.java`**  
   - Search for a specific element in a pre-defined array based on user input.  

6. **`ReverseArray.java`**  
   - Reverse the elements of an array using a loop.  

7. **`CountEvenOdd.java`**  
   - Count how many even and odd numbers are present in an array.  

8. **`BubbleSort.java`**  
   - Implement the Bubble Sort algorithm to sort an array in ascending order.  

9. **`FindSecondLargest.java`**  
   - Find the second largest number in an array without sorting.  

---

### **Package: Thread**  
Contains exercises to practice multithreading concepts such as thread creation, synchronization, and concurrent tasks.  

#### **Classes**  
1. **`CreateThread1.java`**  
   - Demonstrates thread creation by extending the `Thread` class.  

2. **`CreateThread2.java`**  
   - Demonstrates thread creation by implementing the `Runnable` interface.  

3. **`CreateThread3.java`**  
   - Demonstrates thread creation using a lambda function.  

#### **Sub-Package: HusbandWife**  
Simulates a real-world scenario where multiple threads (husband and wife) access a common bank account.  

1. **`BankAccount.java`**  
   - Represents a shared bank account with synchronized methods to ensure thread safety.  

2. **`Husband.java`**  
   - A thread class that simulates a husband withdrawing money from the account.  

3. **`Wife.java`**  
   - A thread class that simulates a wife depositing money into the account.  

4. **`Main.java`**  
   - The main driver class to execute the threads and simulate concurrent access to the shared bank account.  

---

## 🛠️ Installation  

1. Clone the repository:  
   ```bash
   git clone https://github.com/Judinus10/JavaPracticles.git
   ```  
2. Navigate to the project directory:  
   ```bash
   cd JavaPracticles
   ```  
3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).  

---

## 🚀 Usage  

1. Compile the project:  
   ```bash
   javac -d . Loops/*.java Arrays/*.java Thread/*.java Thread/HusbandWife/*.java
   ```  
2. Run any class by specifying its fully qualified name:  
   ```bash
   java Thread.CreateThread1
   ```  
   or  
   ```bash
   java Thread.HusbandWife.Main
   ```  

---

## 🧰 Technologies Used  

- **Java**: Version 17 or compatible  
- **JDK**: For compiling and running Java programs  

---

## 🤝 Contributing  

Contributions are welcome!  
To contribute:  
1. Fork the repository.  
2. Create a new branch:  
   ```bash
   git checkout -b feature-name
   ```  
3. Make your changes and commit them:  
   ```bash
   git commit -m "Description of changes"
   ```  
4. Push to the branch:  
   ```bash
   git push origin feature-name
   ```  
5. Open a pull request.  

---

## 📧 Contact  

- **Name**: Judinus Judes Uthiyaraj  
- **Email**: jjudinas@gmail.com  
- **GitHub**: [https://github.com/Judinus10](https://github.com/Judinus10)  

--- 
