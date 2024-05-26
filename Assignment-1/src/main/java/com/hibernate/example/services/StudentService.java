package com.hibernate.example.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.example.entity.Student;
import com.hibernate.example.utility.HibernateUtility;

public class StudentService {

	public static String saveStudent(Student s) {

		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.persist(s);

			tx.commit();
			session.close();
			return "Student saved Successfully....";
		} catch (Exception e) {
			// TODO: handle exception
			return "Some Exception occurs -: " + e.getMessage();
		}

	}

	public static Student getStudent(Integer id) {

		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Student s=session.get(Student.class, id);

			tx.commit();
			session.close();
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( "Some Exception occurs  -: " + e.getMessage());
			return null;
		}

	}

	public static Student updateStudent(int id,String location) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Student student=session.get(Student.class, id);
			Student s=null;
			if(student!=null) {
				student.setLocation(location);
				s=session.merge(student);
			}else {
				System.out.println("Student doesn't exist with id :- "+id);
			}
			
			tx.commit();
			session.close();
			return s;
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( "Some Exception occurs -: " + e.getMessage());
			return null;
		}
	}

	public static String deleteStudent(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Student student=session.get(Student.class, id);
			String result="";
			if(student!=null) {
				session.remove(student);
				result="Student Deleted...";
			}
			else {
				result="Student doesn't exit with id:- "+id;
			}
			tx.commit();
			session.close();
			return result;
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( "Some Exception occurs -: " + e.getMessage());
			return null;
		}
	}

}
