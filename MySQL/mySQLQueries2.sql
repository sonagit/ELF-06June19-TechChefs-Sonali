## AUTO INCREMENT -- USER GIVEN ID has higher precedence than auto increment
CREATE TABLE stores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    store_name VARCHAR(100)
);

select * from stores;

INSERT INTO `stores` VALUES (null,'PK Tiral Store' );
commit;

# MySQL self join 
SELECT 
    *
FROM
    customers c1
        INNER JOIN
    customers c2 USING (customerNumber);

#

SELECT count(m.id), e.id,
    m.name AS 'Manager',
    e.name AS 'Direct report'
FROM
    employee_info e
        INNER JOIN
    employee_info m ON m.id = e.mngr_id
    group by m.id
ORDER BY e.id;

#GROUP BY clause with aggregate functions such as SUM, AVG, MAX, MIN, and COUNT. 

SELECT 
    min(orderNumber),status,max(orderNumber), avg(orderNumber), count(orderNumber)
FROM
    classicmodels.orders 
    group by status;

select Year(orderDAte), Month(orderdate), dayname(orderdate) , orderdate from orders;
#HAVING
SELECT 
    min(orderNumber),status,max(orderNumber), avg(orderNumber), count(orderNumber)
FROM
    classicmodels.orders 
group by status 
having status != 'Shipped';  

#When do we use UNION ALL and ROLLUP clause

#MYSQL SubQuery in WHERE CLAUSE
SELECT 
    customerName
FROM
    customers
WHERE
    customerNumber NOT IN (SELECT DISTINCT
            customerNumber
        FROM
            orders);
#SUBQUERY IN FROM Clause -- FLOOR will remove all the decimal points
SELECT 
    MAX(items), MIN(items), FLOOR(AVG(items))
FROM
    (SELECT 
        orderNumber, COUNT(orderNumber) AS items
    FROM
        orderdetails
    GROUP BY orderNumber) AS lineitems;
   
#Co-related Sub Query and Independent Subquery   
SELECT 
    productname, buyprice
FROM
    products p1
WHERE
    buyprice > (SELECT 
            AVG(buyprice)
        FROM
            products
        WHERE
            productline = p1.productline);

#EXISTS and NOT EXISTS 
SELECT 
   *
FROM
    customers
WHERE
    EXISTS( SELECT 
            orderNumber, SUM(priceEach * quantityOrdered)
        FROM
            orderdetails
                INNER JOIN
            orders USING (orderNumber)
        WHERE
            customerNumber = customers.customerNumber
        GROUP BY orderNumber
        HAVING SUM(priceEach * quantityOrdered) > 60000);

#DERIVED Table and alias
SELECT 
    column_list
FROM
    (SELECT 
        column_list
    FROM
        table_1) derived_table_name 
WHERE derived_table_name.c1 > 0;

#EXIST operator is faster than comparision operator as it terminates as soon as it get the first value hence returning True.

SELECT 
    customerNumber, customerName
FROM
    customers
WHERE
    NOT EXISTS( SELECT 
            1
        FROM
            orders
        WHERE
            orders.customernumber = customers.customernumber);

select * from orders o where o.customerNumber = 125;

-- MySQL INSERT EXISTS
-- MySQL UPDATE EXISTS
-- MySQL DELETE EXISTS 

-- UNION vs. JOIN
#A JOIN combines result sets horizontally, a UNION appends result set vertically. 

#we use alias ot oerform operation on the resultset of union query
SELECT 
    concat(firstName,' ',lastName) fullname
FROM
    employees 
UNION SELECT 
    concat(contactFirstName,' ',contactLastName)
FROM
    customers
ORDER BY fullname;

#INTERSECT OPERATOR -- there is no intersect operator in MySQL so we can simulate it using IN ketword and subquery
CREATE TABLE t1 (
    id INT PRIMARY KEY
);
 
CREATE TABLE t2 LIKE t1;
 
INSERT INTO t1(id) VALUES(1),(2),(3);
 
INSERT INTO t2(id) VALUES(2),(3),(4);

-- 1st way distinct and inner join
SELECT  id  FROM t1 INNER JOIN t2 USING(id);
   
-- 2nd way in operator and subquery
SELECT DISTINCT
    id
FROM
    t1
WHERE
    id IN (SELECT 
            id
        FROM
            t2);


#common table expression or CTE - have not completed it