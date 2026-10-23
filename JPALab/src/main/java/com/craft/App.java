package com.craft;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Set MYSQL_USER and MYSQL_PASSWORD as environment variables on your computer.
        // Do not commit your real database password to GitHub.
        String user = System.getenv().getOrDefault("MYSQL_USER", "root");
        String password = System.getenv().getOrDefault("MYSQL_PASSWORD", "");

        Map<String, Object> properties = Map.of(
                "jakarta.persistence.jdbc.user", user,
                "jakarta.persistence.jdbc.password", password
        );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU", properties);

        try {
            StudentService service = new StudentService(emf);

            System.out.println("Creating sample students...");
            Student first = service.createStudent("John Snow", "Java");
            service.createStudent("Alemayehu", "Python");
            service.createStudent("Sara", "Java");

            System.out.println("\nAll students:");
            service.getAllStudents().forEach(System.out::println);

            System.out.println("\nFind student by ID " + first.getId() + ":");
            System.out.println(service.getStudentById(first.getId()));

            System.out.println("\nStudents who use Java:");
            service.getStudentsByTech("Java").forEach(System.out::println);

            System.out.println("\nTotal students: " + service.countStudents());

            System.out.println("\nUpdating the first student...");
            service.updateStudent(first.getId(), "John Snow Updated", "Jakarta");

            System.out.println("Updated record: " + service.getStudentById(first.getId()));

            System.out.println("\nDeleting the second sample student...");
            service.deleteStudentById(first.getId() + 1);

            System.out.println("\nFinal student list:");
            service.getAllStudents().forEach(System.out::println);
        } finally {
            emf.close();
        }
    }
}
