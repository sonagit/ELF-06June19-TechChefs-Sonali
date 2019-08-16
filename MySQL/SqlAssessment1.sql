SQL Assignment 1
1.WAQ to display the employees working in dept 20
->select * from employee where dept_no=20;
2.WAQ to display the employees earning more than 25000.
->Select * from employee where salary >25000;
3.WAQ to display all the employees who job type is software developer.
->Select * from employee where job_type ='software developer';
4. WAQ to display the employees working IN dept 10,20 and 40;
->select * from employee where dept_no IN (10,20,40);
5.WAQ to display all the employees whose firstname is having letter 'L' as 2nd letter.
->select * from employee where first_name LIKE '_L%';
6.WAQ to display all the employees whose firstname is having atleast 2 'A' character.
->select * from employee where first_name LIKE '%a%a%';
7.WAQ to display all the employees whose lastname is having letter 'E' as the  2 nd last  character.
->select * from employee where last_name LIKE '%E_';
8.WAQ to display the employees whose name starts with 'S'.
->select * from employee where first_name LIKE ’S%’;
9.WAQ to display all the employees who are having exactly 5 characters in their lastname.
->select * from employee where length(last_name)=5;
10.WAQ to display the employees salary is between 20000 to 30000.
->select * from employee where salary between 20000 AND 30000;
