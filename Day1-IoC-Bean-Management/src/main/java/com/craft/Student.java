
package com.craft;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private int age;
    private Address address;
    private List<Subject> subjects = new ArrayList<>();

    public Student() {
        System.out.println("Student empty constructor called.");
    }

    // Constructor-based dependency injection
    public Student(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;

        System.out.println("Student parameterized constructor called.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("Student Details");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);

        System.out.println("Subjects:");

        for (int i = 0; i < subjects.size(); i++) {
            System.out.println("Subject " + (i + 1) + ": "
                    + subjects.get(i).getSubjectName());
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }
}
