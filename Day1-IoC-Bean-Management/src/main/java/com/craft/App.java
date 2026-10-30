
package com.craft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("beansConfig.xml")) {

            // 1. Setter Injection
            System.out.println("\n===== SETTER INJECTION =====");

            Student student = context.getBean("student", Student.class);

            student.getDetails();

            // 2. Constructor Injection
            System.out.println("\n===== CONSTRUCTOR INJECTION =====");

            Student constructorStudent =
                    context.getBean("constructorStudent", Student.class);

            System.out.println(constructorStudent);

            // 3. Singleton Scope
            System.out.println("\n===== SINGLETON SCOPE =====");

            Student student1 = context.getBean("student", Student.class);
            Student student2 = context.getBean("student", Student.class);

            System.out.println("Same object? " + (student1 == student2));

            // 4. Prototype Scope
            System.out.println("\n===== PROTOTYPE SCOPE =====");

            Student prototype1 =
                    context.getBean("prototypeStudent", Student.class);

            Student prototype2 =
                    context.getBean("prototypeStudent", Student.class);

            System.out.println("Same object? " + (prototype1 == prototype2));

            prototype1.setName("Changed Name");

            System.out.println("First Student: " + prototype1.getName());
            System.out.println("Second Student: " + prototype2.getName());

        }
    }
}
