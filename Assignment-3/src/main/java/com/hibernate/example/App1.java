package com.hibernate.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.example.entity.Book;
import com.hibernate.example.entity.Publisher;
import com.hibernate.example.utility.HibernateUtility;


public class App1 {

	public static void main(String[] args) {
		System.out.println("Running App1.....");

        try {
            Session session = HibernateUtility.getSessionFactory().openSession();
            session.getTransaction().begin();

            Set<Book> bookList=new HashSet();
            
            Book b1=new Book();
            b1.setTitle("Java Guides");
                                 
            Book b2=new Book();
            b2.setTitle("Hibernate");
            
            bookList.add(b1);
            bookList.add(b2);
            
            Publisher p1=new Publisher();
            p1.setAddress("Delhi");
            p1.setName("ABC");
            p1.setBookList(bookList);
            
            
            b1.setPublisher(p1);
            b2.setPublisher(p1);
            
            System.out.println("Book :- "+b1+" Publisher :- "+p1);
            session.persist(p1);
            session.persist(b1);
            session.persist(b2);
            
            System.out.println("publisher details :- "+session.get(Publisher.class,1));
           

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Exception occurs :- " + e.getLocalizedMessage());
        }
	}
}
