USE CLASSICMODELS;

#SELECT CLAUSE 
SELECT 
    *
FROM
    classicmodels.customers c;

#SELECT DISTINCT CLAUSE 
SELECT DISTINCT
    c.contactFirstName, c.contactLastName, c.phone
FROM
    classicmodels.customers c;
#122-105 = duplicate entry - 27

#INNER JOIN 
SELECT 
    *
FROM
    classicmodels.orders
        INNER JOIN
    orderdetails ON orders.orderNumber = orderdetails.orderNumber
WHERE
    orders.orderNumber < 10103;

#PROPER DATA QUERY
SELECT 
    MIN(p.amount), city
FROM
    classicmodels.customers c
        INNER JOIN
    classicmodels.payments p ON c.customerNumber = p.customerNumber
GROUP BY city
HAVING city like 'B%' 
order by city desc;

# second cheapest 
# customerNumber, checkNumber, paymentDate, amount
#'124', 'KI131716', '2003-08-15', '111654.40'

SELECT 
    *
FROM
    classicmodels.payments p
ORDER BY p.amount DESC limit 2,1;

#ORDER BY CLAUSE
#Multiple columns order by 
SELECT 
    *
FROM
    classicmodels.orders o
ORDER BY p.customerNumber ASC , p.checkNumber ASC;

select orderNumber, status from classicmodels.orders o where FIELD(status,
'Shipped','Resolved','Cancelled','On Hold','Disputed','In Process');

select status from classicmodels.orders o where FIELD(status,'Resolved','On Hold');

#WHERE CLAUSE
USE CLASSICMODELS;

SELECT 
    firstname, lastname, jobtitle
FROM
    employees
WHERE
    jobtitle like 'Sales Rep%';

#NOT EQUAL TO
SELECT 
    firstname, lastname, jobtitle
FROM
    employees
WHERE
    jobtitle <> 'Sales Rep%';

#BETWEEN Operator
SELECT 
    *
FROM
    employees
WHERE
    employeeNumber between 1000 and 1500;
    
#>= and <= operator
SELECT 
    *
FROM
    employees
WHERE
    employeeNumber >= 1030 and employeeNumber <= 1500;

#NOT BETWEEN Operator
SELECT 
    productCode, 
    productName, 
    buyPrice
FROM
    products
WHERE
    buyPrice NOT BETWEEN 20 AND 100;

#DATE CAST Operator
SELECT 
   orderNumber,
   requiredDate,
   status
FROM 
   orders
   where requireddate between '2003-01-01' and '2003-01-31';

SELECT 
   orderNumber,
   requiredDate,
   status
FROM 
   orders
WHERE 
   requireddate BETWEEN 
     CAST('2003-01-01' AS DATE) AND 
     CAST('2003-01-31' AS DATE);

#LIKE OPERATOR (%)
SELECT 
    employeeNumber, 
    lastName, 
    firstName
FROM
    employees
WHERE
    firstName LIKE 'a%';

SELECT 
    employeeNumber, 
    lastName, 
    firstName
FROM
    employees
WHERE
    lastName LIKE '%on';
#LIKE OPERATOR (_)
SELECT * FROM classicmodels.employees
WHERE
    firstName LIKE '_arry';
    
#ESCAPE Sequence
SELECT 
    productCode, 
    productName
FROM
    products
WHERE
    productCode LIKE '%$_20%' ESCAPE '$';
    
#IN OPERATOR
SELECT 
    officeCode, 
    city, 
    phone, 
    country
FROM
    offices
WHERE
    country IN ('USA' , 'France');

#SUB-QUERY IN Operator
SELECT    
 orderNumber, 
 customerNumber, 
 status, 
 shippedDate
FROM    
 orders
WHERE orderNumber IN
(
 SELECT 
 orderNumber
 FROM 
 orderDetails
 GROUP BY 
 orderNumber
 HAVING SUM(quantityOrdered * priceEach) > 60000
);

SELECT 
    *
FROM
    offices
WHERE
    state IS NULL OR addressLine2 IS NULL
        OR addressLine1 IS NULL;

#IFNULL Command
select ifnull(1,0);
select ifnull('',0);
select ifnull(NULL,'TRIAL');

#Create Table 
CREATE TABLE IF NOT EXISTS contacts (
    contactid INT AUTO_INCREMENT PRIMARY KEY,
    contactname VARCHAR(20) NOT NULL,
    bizphone VARCHAR(15),
    homephone VARCHAR(15)
);

#Insert DATA
INSERT INTO contacts(contactname,bizphone,homephone)
VALUES('John Doe','(541) 754-3009',NULL),
      ('Cindy Smith',NULL,'(541) 754-3110'),
      ('Sue Greenspan','(541) 754-3010','(541) 754-3011'),
      ('Lily Bush',NULL,'(541) 754-3111');

SELECT 
    contactName, bizphone, homephone
FROM
    contacts;

select contactName, IFNULL(bizphone,homephone) PHONE from contacts;

#NULLIF command
select NULLIF(NULL,null);
SELECT 1/NULLIF(0,0);

# FULL TEXT SEARCH 

ALTER TABLE products ADD FULLTEXT index_name(productName); 
SELECT productName, productline
FROM products
WHERE MATCH(productName) 
      AGAINST('Ford' IN BOOLEAN MODE );

SELECT productName, productline
FROM products
WHERE MATCH(productName) 
      AGAINST('Ford -Truck' IN BOOLEAN MODE );

/*Operator	Description
+	Include, the word must be present.
–	Exclude, the word must not be present.
>	Include, and increase ranking value.
<	Include, and decrease the ranking value.
()	Group words into subexpressions (allowing them to be included, excluded, ranked, and so forth as a group).
~	Negate a word’s ranking value.
*	Wildcard at the end of the word.
“”	Defines a phrase (as opposed to a list of individual words, the entire phrase is matched for inclusion or exclusion).*/

#Alias example - ASkeyword
SELECT 
    CONCAT_WS(', ', lastName, firstname) as 'FULL NAME'
FROM
    employees;

use classicmodels;

/* MySQL supports the following types of joins:

Cross join
Inner join
Left join
Right join */

#INNER JOINS
SELECT
 customerName,
 COUNT(o.orderNumber) total
FROM
 customers c
INNER JOIN orders o ON c.customerNumber = o.customerNumber
GROUP BY
 customerName
ORDER BY
 total DESC;
 
# CROSS JOIN 
SELECT 
    *
FROM
    contacts
        CROSS JOIN
    offices;

# USING Keyword LEFT = 2996; RIGHT = 2996; CROSS = ; INNER
SELECT 
    COUNT(1)
FROM
    orders
        INNER JOIN
    orderdetails USING (orderNumber);



