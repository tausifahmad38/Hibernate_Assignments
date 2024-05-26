package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.example.entity.Customer;
import com.hibernate.example.entity.Employee;
import com.hibernate.example.entity.Person;
import com.hibernate.example.utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
        	Session session=HibernateUtility.getSessionFactory().openSession();
        	session.getTransaction().begin();
        	
        	Person person1=new Person();
        	person1.setId(1);
        	person1.setName("Ankit");
        	
        	Employee emp1=new Employee();
        	emp1.setId(2);
        	emp1.setName("Amit");
        	emp1.setDept("ERS");
        	
//        	Employee emp2=new Employee();
//        	emp2.setId(3);
//        	emp2.setName("Sumit");
//        	emp2.setDept("DFS");
        	
        	Customer customer1=new Customer();
        	customer1.setId(4);
        	customer1.setName("Axis Bank");
        	customer1.setAcctType("Saving");
        	
        	session.persist(person1);
        	session.persist(emp1);
//        	session.persist(emp2);
        	session.persist(customer1);
        	
        	Person person2=new Person();
        	person2.setId(5);
        	person2.setName("Ajay");
        	
        	session.persist(person2);
        	
        	session.getTransaction().commit();
        	session.close();
        	
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println("Exception Occurs :- "+e.getMessage());
		}
    }
}
