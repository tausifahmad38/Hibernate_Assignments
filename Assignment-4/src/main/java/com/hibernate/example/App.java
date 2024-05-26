package com.hibernate.example;

import java.util.List;

import org.hibernate.Session;

import com.hibernate.example.entity.Employee;
import com.hibernate.example.services.EmployeeService;
import com.hibernate.example.utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "HQL application is running..." );
        
      
        
       EmployeeService service=new EmployeeService();
       
       // This method will save 10 employee from service class
       service.addEmployee();
       
       //fetching Employee with decreasing order of empId
       System.out.println("Employees in descending order of EmpId -: ");
       List<Employee> employees=service.fetchAllEmployeeInDecendingOrderById();
       for(Employee e:employees) {
    	   System.out.println(e);
       }
       
       // Paging through the query results to list from specific row, say 2 and set the size per each page as 3.
       
       System.out.println("Pagination Result :-");
       List<Employee> result1=service.fetchEmployeeUsingPagination(2, 3);
       for(Employee e:result1) {
    	   System.out.println(e);
       }
       
       
       //Find employee with a specific education using :-
       			//Named parameter
       			//position parameter
       System.out.println("Employee with Specific Education like Btech:- ");
       List<Employee> result2=service.fetchEmployeeByEducation("Btech");
       for(Employee e:result2) {
    	   System.out.println(e);
       }
       
//       Implementing Aggregate method of HQL
       
       service.executeAggregateMethods();
    }
}
