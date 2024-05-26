# Hibernate_Assignments

## Environment Setup Details:
Ensure the following software is installed and available on your local PC/Laptop. You can raise a software request for the below software in TARMAC.
- OpenJDK 17 or above
- Eclipse IDE for Enterprise Java and Web Developers (2024-03 version)
- Any database (MySQL/Oracle) OR any in-memory database (H2/HSQL)

## General Instructions:
- Use H2 in-memory database for the assignments.
- Create a separate Maven project for each of the assignments.
- Capture screenshots of the output of the program wherever applicable and submit them along with the solutions.
- Submit the `src` and `pom.xml` for each project.

## Assignment-1: Create Hibernate Application to Perform CRUD Operations
1. **Persist the Student Class Objects**
2. **Retrieve the Details of a Specific Student**
3. **Update the Location of a Particular Student**
4. **Delete a Student with Specific ID**
   - i. Using XML Configuration
   - ii. Using Annotations

### Student Class Attributes:
- `id`
- `name`
- `location`

### Code Implementation:
Write code to show the results of all these operations.

## Assignment-2: Create a Hibernate Application to Demonstrate Different Types of Inheritance Mapping
1. Demonstrate SINGLE_TABLE, JOINED, and TABLE_PER_CLASS inheritance strategies.
   - **Parent Class**: `Person(id, name)`
   - **Child Classes**: 
     - `Employee(dept)`
     - `Customer(acctType)`

## Assignment-3: Create a Hibernate Application to Demonstrate Different Types of Association Mappings
Use Annotations (Not XML) and create bidirectional associations between the entities.

1. **OneToOne Mapping between Person and Passport**
   - i. Primary key association
   - ii. Unique foreign key association
2. **ManyToOne Mapping between Book to Publisher**
3. **ManyToMany Mapping between Student and Project**

## Assignment-4: Create Hibernate Application to Perform CRUD Operations with HQL Queries
1. Use the `orderBy` clause to select all employees based on the descending order of their `empid`.
2. Page through the query results to list from a specific row (e.g., 2) and set the size per page as 3.
3. Use different types of parameter binding to:
   - Find an employee with a specific education.
4. Use Hibernate aggregate operations `max`, `min`, `count`, and `sum` to:
   - i. Find the employee with the highest salary.
   - ii. Find the employee with the least salary.
   - iii. Count the number of employees whose age is less than 50.
   - iv. Find the total salary of all employees.

### Employee Class Attributes:
- `empid`
- `name`
- `age`
- `education`
- `salary`

## Assignment-5: Create Hibernate Application to Persist Employee Class Objects
1. Create multiple sessions.
2. Load the object twice using different sessions. Set the `show_sql` property to `true` (`<property name="show_sql">true</property>`). This helps to see the executed queries in the console. Verify that the query to load the object is executed twice.
3. Enable Second Level Cache using EHCache. Load the object twice using different sessions. Compare the differences in the queries shown in the console before and after enabling the second-level cache. Discuss the advantage of enabling the second-level cache.
