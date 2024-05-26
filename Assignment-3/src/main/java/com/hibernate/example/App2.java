package com.hibernate.example;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.example.entity.Book;
import com.hibernate.example.entity.Project;
import com.hibernate.example.entity.Publisher;
import com.hibernate.example.entity.Student;
import com.hibernate.example.utility.HibernateUtility;

public class App2 {
	public static void main(String[] args) {
		System.out.println("Running App2.....");

        try {
            Session session = HibernateUtility.getSessionFactory().openSession();
            session.getTransaction().begin();

            Student s1=new Student();
            s1.setDept("ERS");
            s1.setName("ABC");
            
            Student s2=new Student();
            s2.setDept("Support");
            s2.setName("XYZ");
            
            
            Project p1=new Project();
            p1.setName("project1");
           
            Project p2=new Project();
            p2.setName("project2");
            
            session.persist(p1);
            session.persist(p2);
                        
            Set<Project> projects = new HashSet<>();
           projects.add(p1);
           projects.add(p2);
           
           s1.setProjects(projects);
           s2.setProjects(projects);
           
           session.persist(s1);
           session.persist(s2);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Exception occurs :- " + e.getLocalizedMessage());
        }
	}

}
