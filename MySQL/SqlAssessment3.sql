1.WAQ to display all the employees whose name and job is having exactly 5 characters.
->select * from employee where length(first_name) =5 AND length(job)=5;

2.WAQ to display all the employees whose job starts with 'soft'.
->select * from employee where job like 'soft%';

3.WAQ to display the maximum salary for each job.
->select max(salary),dept_no from employee group by dept_no;

4.WAQ to display the department numbers along with the number of employees working in it.
->select count(id),dept_no from employee group by dept_no;

5.WAQ to display the minimum salary for each of the job excluding all the employees whose name ends with a.
->select min(salary),job from employee where first_name not like '%a' group by job;

6.WAQ to display the list of employees who is working in admin department.
->select * from employee where dept_no in (select dept_no from dept where dname="admin");

7.WAQ to display the list of the department names that are working as clerk.
->select * from dept where dept_no in (select dept_no from employee where job="clerk");

8.WAQ to display the 2nd maximum salary.
->select max(salary) from employee where salary < (select max(salary) from employee);

9.WAQ to display the 3rd maximum salary.
->select max(salary) from employee where salary < (select max(salary) from employee where salary <(select max(salary) from employee));
OR
->SELECT DISTINCT salary 
	FROM employee e1 
	WHERE 3 = (SELECT COUNT(DISTINCT salary) 
	FROM employee e2 
	WHERE e2.salary >= e1.salary);
10.WAQ to display the 4th least salary.
->SELECT DISTINCT salary 
	FROM employee e1 
	WHERE 4 = (SELECT COUNT(DISTINCT salary) 
	FROM employee e2 
	WHERE e2.salary <= e1.salary);