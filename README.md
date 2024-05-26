# Hibernate_Assignments

Environment Setup Details: 
Software to be installed and available on your local PC/Laptop. You can raise software 
request for the below software in TARMAC. 
OpenJDK 17 or above 
Eclipse IDE for Enterprise Java and Web Developers (2024-03 version) 
Any database (MySQL/Oracle) OR any in-memory database (h2/hsql) 
General Instructions: 
a. Use H2 in-memory database for the assignments. 
b. Create separate maven project for each of the assignments. 
d. Capture screen shots of the output of the program wherever applicable and submit it 
along with the solutions. 
e. Submit the src and pom.xml for each project. 
 
## Assignment-1: Create Hibernate application to perform CRUD operations: 
a. Persist the Student class objects. 
b. Retrieve the details of a specific Student 
c. update the location of a particular student 
d. delete a Student with specific id 
i. Using xml configuration 
ii. Using annotations 
Student class attributes : id, name, location. 
Write the code to show the results of all these operations. 

## Assignment-2: Create a Hibernate application to demonstrate the diƯerent types of 
Inheritance mapping (SINGLE_TABLE, JOINED and TABLE_PER_CLASS) 
Consider the below class model. 
Parent class :- Person(id,name)
Child class:- Employee(dept), Customer(acctType)
 
## Assignment-3: Create Hibernate application to demonstrate the diƯerent types of 
association mappings. 
Use Annotations (Not xml) and also create bidirectional association between the entities. 
a. OneToOne Mapping between Person and Passport 
i. Primary key association 
ii. Unique foreign key association 
b. ManyToOne mapping between Book to Publisher 
c. ManyToMany mapping between Student and Project 

## Assignment-4 : Create Hibernate application to perform CRUD operations. Write queries 
using HQL. 
a. Making use of the clause orderBy – select all employees based on the descending 
order of their empid 
b. Paging through the query results to list from specific row, say 2 and set the size per 
each page as 3. 
c. Using diƯerent types of parameter binding
i. Find employee with a specific education 
d. Using Hibernate Aggregate operations max, min, count, sum 
i. Find the employee with highest salary, 
ii. Find the employee with least salary 
iii. Count the number of employees whose age is less than 50 
iv. Find the total salary of all employees 
Employee class attributes : empid, name, age, education, salary 

## Assignment-5 : Create Hibernate application to persist Employee class objects. 
Create multiple sessions. Load the object twice using the diƯerent sessions. Set the 
show_sql property true (<property name=”show_sql”>true</property>). This helps to see 
the executed queries in the console. See that the query to load the object is executed twice. 
Now, enable Second level cache using EHCache. Again load the object twice using the 
diƯerent sessions. What is the diƯerence now? Through the queries shown in the console 
show the diƯerence. What is the advantage of enabling second level cache?
