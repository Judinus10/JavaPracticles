
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

# Java Projects Repository

This repository contains various Java packages and exercises grouped into categories based on topics. The project covers fundamental Java concepts such as arrays, loops, multithreading, and thread synchronization, as well as advanced concepts like thread states and concurrent programming.

---

## Package Overview

### 1. **Arrays**
This package includes exercises to manipulate and process arrays:
- **Sum.java**: Calculate the sum of array elements.
- **FindMaxAndMin.java**: Find the maximum and minimum element in an array.
- **PrintArray1.java**: Print array elements using two methods (enhanced for-loop and standard for-loop).
- **PrintArray2.java**: Print array elements in a formatted structure.
- **SearchElement.java**: Search for an element in a predefined array.
- **ReverseArray.java**: Reverse the elements of an array using a loop.
- **CountEvenOdd.java**: Count even and odd numbers in an array.
- **SortArray.java**: Implement the Bubble Sort algorithm to sort an array.
- **SecondLargestElement.java**: Find the second largest number in an array without sorting.

### 2. **Loops**
This package contains exercises related to loops:
- **MultiplicationTable.java**: Generate and print the multiplication table for a number.
- **ReverseNumber.java**: Reverse the digits of an integer.
- **PrimeCheck.java**: Check whether a number is prime.
- **FibonacciSequence.java**: Generate the Fibonacci sequence up to `n` terms.
- **CountDigits.java**: Count the number of digits in a given integer.
- **SumOfDigits.java**: Calculate the sum of the digits of a given number.

### 3. **Thread**
This package includes multithreading exercises, thread creation, and synchronization:

#### **HusbandWife**
Simulating a bank account shared between a husband and wife:
- **BankAccount.java**: Common bank account shared between threads.
- **Husband.java**: Represents the husband accessing the shared account.
- **Wife.java**: Represents the wife accessing the shared account.
- **Main.java**: The main driver class.

#### **BankAccount**
Simulating a bank account package:
- **BankAccount.java**: Bank account implementation.
- **Main.java**: Driver class for testing.
- **InsufficientBalanceException.java**: Custom exception for insufficient balance.

#### **ProducerConsumer**
Producer-Consumer problem implementation:
- **ProducerConsumer.java**: Implementation of the producer-consumer problem.
- **Source.java**: Shared resource between producer and consumer.
- **Mother.java**: Represents the producer.
- **Child.java**: Represents the consumer.
- **Main.java**: Main driver class.

#### **ThreadGroup**
Managing threads using thread groups:
- **ThreadGroup.java**: Demonstrates thread group concepts.
- **myRunnable.java**: Runnable task for thread group example.

#### **Thread Creation and Synchronization**
- **ConcurrentProgramWithMonitor.java**: Using monitors for concurrent programming.
- **ConcurrentProgramWithReentrantLock.java**: Using `ReentrantLock` for synchronization.
- **CreateThread1.java**: Creating a thread using `extends Thread`.
- **CreateThread2.java**: Creating a thread using `implements Runnable`.
- **CreateThread3.java**: Creating a thread using a lambda function.
- **Lamda.java**: Thread creation with lambda expressions.
- **LamdaBlock.java**: Block-level lambda thread implementation.
- **ReentrantLock.java**: Demonstrates the use of `ReentrantLock` for thread synchronization.
- **ThreadState.java**: Analyzing different thread states.


## Topics Covered
- Arrays and Loops
- Multithreading and Synchronization
- Thread States and Management
- Producer-Consumer Problem
- Custom Exceptions
- Advanced Locking Mechanisms

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
