package com.example;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        // Create new student
        Student newStudent = new Student("John Doe", 22);
        studentDao.createStudent(newStudent);

        // Read student by ID
        Student student = studentDao.getStudent(newStudent.getId());
        System.out.println("Retrieved Student: " + student.getName());

        // Update student
        student.setName("Johnathan Doe");
        studentDao.updateStudent(student);
        System.out.println("Updated Student: " + student.getName());

        // Delete student
        studentDao.deleteStudent(student.getId());
        System.out.println("Student deleted");
        
        // Close Hibernate session factory
        HibernateUtil.shutdown();
    }
}
