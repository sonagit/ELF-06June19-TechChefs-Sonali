#Modifying data in MySQL
#INSERT INTO <table> values (); 

#MySQL INSERT INTO SELECT example

#INSERT IGNORE statement
#email VARCHAR(50) NOT NULL UNIQUE "here Unique" is a constraints

#INSERT IGNORE Keyword

#UPDATE CLAUSE 
/*UPDATE [LOW_PRIORITY] [IGNORE] table_name 
SET 
    column_name1 = expr1,
    column_name2 = expr2,
    ...
[WHERE
    condition];*/
    
    UPDATE employees 
SET 
    email = 'mary.patterson@classicmodelcars.com'
WHERE
    employeeNumber = 1056;
    
#DELETE KEYWORD
DELETE FROM employees 
WHERE
    officeCode = 4;
    
#DELETE FROM TABLE LIMIT row_count;

#CASCADE DELETE 
/*FOREIGN KEY (building_no)
        REFERENCES buildings (building_no)
        ON DELETE CASCADE   

This will enable the data to be deleted if the parent entry is deleted. */

USE information_schema;
 
SELECT 
    table_name
FROM
    referential_constraints
WHERE
    constraint_schema = 'classicmodels'
        #AND referenced_table_name = 'buildings'
        AND delete_rule = 'CASCADE';

# MYSQL Prepared Statement / COMMIT statement 
set autocommit=1;
#LOCK TABLES keywords - uses in practical projects

#LOCK TABLES table_name [READ | WRITE] - do keep lock for both read and write at the same time
UNLOCK TABLES;

#USE keyword to use Database - USE database_name;
USE techchefs_db_test;

#Selecting a database when you login 
#>mysql -u root -D classicmodels -p

#CREATE detabase -- 	CREATE DATABASE [IF NOT EXISTS] database_name;

SHOW DATABASES;
   
#Delete Database -- DROP DATABASE [IF EXISTS] database_name;

/*
MySQL provides various storage engines for its tables as follows:

MyISAM
InnoDB
MERGE
MEMORY (HEAP)
ARCHIVE
CSV
FEDERATED

Have to re-read "http://www.mysqltutorial.org/understand-mysql-table-types-innodb-myisam.aspx"
*/    
   #LAST_INSERT_ID()
   
   select LAST_INSERT_ID() from dual;
   
#RENAME statement - 	RENAME TABLE old_table_name TO new_table_name;
#DROP column - ALTER TABLE table DROP COLUMN column;

#TEMPORARY table concepts 




    