
# Day 1 - IoC and Bean Management Lab

## Introduction

This project demonstrates Spring Framework Core concepts,
especially Inversion of Control (IoC) and Dependency Injection (DI).

## Technologies Used

- Java 19
- Maven
- Spring Framework 6.2.7
- IntelliJ IDEA

## Project Objectives

1. Understand Spring Inversion of Control.
2. Create and manage Spring Beans.
3. Implement Setter-based Dependency Injection.
4. Implement Constructor-based Dependency Injection.
5. Perform Literal Dependency Injection.
6. Perform Object Dependency Injection.
7. Implement Collection Dependency Injection.
8. Understand Singleton Bean Scope.
9. Understand Prototype Bean Scope.

## Project Structure

```text
Day1-IoC-Bean-Management/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        ├── java/
        │   └── com/craft/
        │       ├── App.java
        │       ├── Student.java
        │       ├── Address.java
        │       └── Subject.java
        └── resources/
            └── beansConfig.xml
```

## How to Run

1. Open the project in IntelliJ IDEA.
2. Allow Maven to download dependencies.
3. Open App.java.
4. Run the main method.
5. Check the console output.

## Expected Results

- Student information is displayed.
- Address information is injected.
- Subjects are injected as a collection.
- Constructor injection works.
- Singleton comparison returns true.
- Prototype comparison returns false.

## Conclusion

This lab demonstrates how Spring IoC manages object creation
and how Dependency Injection connects application components.
It also demonstrates the difference between Singleton and
Prototype bean scopes.
