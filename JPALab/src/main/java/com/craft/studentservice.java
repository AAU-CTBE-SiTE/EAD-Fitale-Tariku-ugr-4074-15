package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentService {
    private final EntityManagerFactory emf;

    public StudentService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // CREATE
    public Student createStudent(String name, String tech) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student student = new Student(name, tech);
            em.persist(student);
            tx.commit();
            return student;
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // READ one student by primary key
    public Student getStudentById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    // READ all students using JPQL
    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> query =
                    em.createQuery("SELECT s FROM Student s ORDER BY s.id", Student.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // JPQL filter by technology
    public List<Student> getStudentsByTech(String tech) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> query = em.createQuery(
                    "SELECT s FROM Student s WHERE LOWER(s.tech) = LOWER(:tech) ORDER BY s.id",
                    Student.class);
            query.setParameter("tech", tech);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // UPDATE
    public boolean updateStudent(int id, String newName, String newTech) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student student = em.find(Student.class, id);
            if (student == null) {
                tx.commit();
                return false;
            }
            student.setName(newName);
            student.setTech(newTech);
            tx.commit();
            return true;
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // DELETE
    public boolean deleteStudentById(int id) {
        EntityManager em = emf.createEntityManager();
