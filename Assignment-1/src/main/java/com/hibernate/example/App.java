package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.example.entity.Student;
import com.hibernate.example.services.StudentService;
import com.hibernate.example.utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		Student s = new Student();
//		s.setId(101);
		s.setName("Amit");
		s.setLocation("Noida");
		
		//add
		
		String result = StudentService.saveStudent(s);
		System.out.println(result);
		
		//Retrive
		
		Student std=StudentService.getStudent(1);
		System.out.println("Fetched Student :- "+std);

		//Update
		System.out.println("Before Update Student :- "+StudentService.getStudent(1));
		
		Student updatedStd=StudentService.updateStudent(1,"Chennai");
		System.out.println("After Update Student :- "+updatedStd);
		
		
		//Delete
		String result1=StudentService.deleteStudent(1);
		System.out.println(result1);
	}
}
