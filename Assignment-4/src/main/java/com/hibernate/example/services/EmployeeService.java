package com.hibernate.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.example.entity.Employee;
import com.hibernate.example.utility.HibernateUtility;

import jakarta.persistence.EntityManager;

public class EmployeeService {

	private EntityManager entityManager;

	public List<Employee> getEmployees() {
		return Arrays.asList(
				new Employee(null, "Amit Kumar", 28, "BSc", 45000.0),
				new Employee(null, "Priya Sharma", 34, "MBA", 60000.0),
				new Employee(null, "Rajesh Singh", 40, "MSc", 75000.0),
				new Employee(null, "Sneha Patel", 25, "BBA", 40000.0),
				new Employee(null, "Vikas Gupta", 30, "BSc", 50000.0),
				new Employee(null, "Anjali Mehta", 29, "MA", 55000.0),
				new Employee(null, "Suresh Reddy", 35, "Btech", 80000.0),
				new Employee(null, "Nisha Nair", 32, "BSc", 47000.0),
				new Employee(null, "Kiran Desai", 45, "MBA", 90000.0),
				new Employee(null, "Ritu Verma", 26, "Btech", 42000.0));
	}

	public String addEmployee() {

		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			session.getTransaction().begin();
			for (Employee e : getEmployees()) {
				session.persist(e);
			}
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occurs.. :- " + e.getMessage());
		}

		return "added...";
	}

	public List<Employee> fetchAllEmployeeInDecendingOrderById() {

		List<Employee> result = new ArrayList<>();

		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			session.getTransaction().begin();
			String qry = "from Employee as emp order by emp.empId DESC";

//			result=entityManager.createQuery(qry,Employee.class).getResultList();

			result = session.createSelectionQuery(qry, Employee.class).getResultList();
//			
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occurs.. :- " + e.getMessage());
		}

		return result;
	}

	public List<Employee> fetchEmployeeUsingPagination(int first, int max) {

		List<Employee> result = new ArrayList<>();

		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			session.getTransaction().begin();
			String qry = "from Employee";

//			result=session.createSelectionQuery(qry,Employee.class).setFirstResult(first).setMaxResults(max).getResultList();

			result = session.createSelectionQuery(qry, Employee.class).setFirstResult(first).setMaxResults(max)
					.getResultList();

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occurs.. :- " + e.getMessage());
		}

		return result;
	}

	public List<Employee> fetchEmployeeByEducation(String education) {

		List<Employee> result = new ArrayList<>();

		try {
			Session session = HibernateUtility.getSessionFactory().openSession();
			session.getTransaction().begin();
			
			// Using Positional Parameter
//			String qry = "from Employee emp where emp.education =?1";
//			result = session.createSelectionQuery(qry, Employee.class)
//					.setParameter(1, education)
//					.getResultList();
			
			
			//Using Named Parameter
			String qry = "from Employee emp where emp.education = :edu";
			result = session.createSelectionQuery(qry, Employee.class)
					.setParameter("edu", education)
					.getResultList();

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occurs.. :- " + e.getMessage());
		}

		return result;
	}
	
	public void executeAggregateMethods() {
		
		try {
			Session session=HibernateUtility.getSessionFactory().openSession();
			session.getTransaction().begin();
			
			//Employee with Highest salary
			String qry1="select e from Employee e where e.salary=(select max(emp.salary) from Employee emp)";
			Employee emp1=session.createSelectionQuery(qry1,Employee.class).getSingleResultOrNull();
			System.out.println("Employee with highest Salary :- "+emp1);

			//Employee with Lowest salary
			String qry2="select e from Employee e where e.salary=(select min(emp.salary) from Employee emp)";
			Employee emp2=session.createSelectionQuery(qry2,Employee.class).getSingleResultOrNull();
			System.out.println("Employee with lowest Salary :- "+emp2);
						
			//No. of Employee whose age is less than 50
			String qry3="select count(emp) from Employee emp where emp.age < ?1";
			Long ans1=session.createSelectionQuery(qry3,Long.class).setParameter(1, 50).uniqueResult();
			System.out.println("No. of Employee whose age is <50  -: "+ans1);

			//Total salary of all employee
			String qry4="select sum(emp.salary) from Employee emp";
			Double ans2=session.createSelectionQuery(qry4,Double.class).uniqueResult();
			System.out.println("Total salary of All Employee  -: "+ans2);
			
			session.getTransaction().commit();
			session.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occurs :- "+e.getMessage());
		}
	}

}
