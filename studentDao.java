package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    // Create a student
    public void createStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(student); // save student to database
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Read student by ID
    public Student getStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Student student = null;
        
        try {
            session.beginTransaction();
            student = session.get(Student.class, id); // get student by id
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // Update student
    public void updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(student); // update student
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student); // delete student
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
