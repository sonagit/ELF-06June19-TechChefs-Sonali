SQL assignment 2
1.WAQ to display all the details of the software developer in dept 30.
->select * from employee where job_type ="Software developer" and dept_no =30;
2.WAQ to display the list for all the software developer in dept number 40 and having salary 
greater than 5000.
->Select * from employee where job_type ="Software developer" and dept_no = 40 and salary >5000;
3. WAQ to display the list of all the employees except those who are working in dept 10 and 20.
->Select * from employee where dept_no NOT IN (10,20);
4.WAQ to display the list of the employees who are not working as Android developer and clerk is dept 10 and 20 with the salary in range 1000 to 30000.
->select * from employee where job NOT IN ("Android Developer","Clerk") AND dept_no NOT IN (10,20) AND salary BETWEEN 10000 AND 30000;
5.WAQ to display the list of the employees whose salary is not  in range of 10000 to 20000 in dept 10,20,30 except all clerk . ->select * from employee where salary NOT BETWEEN 10000 AND 20000 AND dept_no IN (10,20,30) AND job NOT IN ("Clerk") ;
6.WAQ to arrange all the employees by their salary in descending order.
->Select * from employee order by salary desc;
7.WAQ to display the maximum salary, minimum salary and total salary from employee.
->Select max(salary) "max salary",min(salary) "min salary",sum(salary) "Total salary" from employee;
8.WAQ to display the list of the number of clerks in dept 20.
->select * from employee where job="clerk" AND dept_no =20;
9.WAQ to display the list of the highest and lowest salary earned by clerk.
->select max(salary),min(salary) from employee where job="clerk";
10.WAQ to display the total salary of all departments.
->select sum(salary) ,dept_no ,count(*) from employee group by dept_no;
