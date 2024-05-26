package com.hibernate.example;

import org.hibernate.Session;

import com.hibernate.example.entity.Passport;
import com.hibernate.example.entity.Person;
import com.hibernate.example.utility.HibernateUtility;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            Session session = HibernateUtility.getSessionFactory().openSession();
            session.getTransaction().begin();

            // Create the Person entity
            Person p1 = new Person();
            p1.setName("Tausif");

            // Persist the Person entity first to generate its ID
            session.persist(p1);
            
            Person p2 = new Person();
            p2.setName("LKSDNlD");

            // Persist the Person entity first to generate its ID
            session.persist(p2);

            // Create the Passport entity
            Passport pass = new Passport();
            pass.setNumber("PA10234IN");

            // Set the Person on the Passport entity
            pass.setPerson(p1);

            // Now persist the Passport entity
            session.persist(pass);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Exception occurs :- " + e.getLocalizedMessage());
        }
    }
}
