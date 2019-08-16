/*Section 13. MySQL data types

MySQL data types – show you various data types in MySQL so that you can apply them effectively in designing database tables.
INT – show you how to use integer data type.
DECIMAL – show you how to use DECIMAL data type to store exact values in decimal format.
BIT – introduce you BIT data type and how to store bit values in MySQL.
BOOLEAN – explain to you how MySQL handles Boolean values by using TINYINT(1) internally.
CHAR – guide to CHAR data type for storing the fixed-length string.
VARCHAR – give you the essential guide to VARCHAR data type.
TEXT – show you how to store text data using TEXT data type.
DATE – introduce you to the DATE data type and show you some date functions to handle the date data effectively.
TIME – walk you through the features of TIME data type and show you how to use some useful temporal functions to handle time data.
DATETIME – introduce you to the DATETIME data type and some useful functions to manipulate DATETIME values.
TIMESTAMP – introduce you to TIMESTAMP and its features called automatic initialization and automatic update that allows you to define auto-initialized and auto-updated columns for a table.
JSON – show you how to use JSON data type to store JSON documents.
ENUM – learn how to use ENUM data type correctly to store enumeration values. */

#YYYY-MM-DD HH:MM:SS
SELECT NOW();

SELECT DATE(NOW());

SELECT CURDATE();

#ENUM Datatype

#MySQL constraints
#NO NULL - column_name data_type NOT NULL;
#PRIMARY Key - user_id INT AUTO_INCREMENT PRIMARY KEY,
/* FOREIGN KEY 
CONSTRAINT constraint_name
FOREIGN KEY foreign_key_name (columns)
REFERENCES parent_table(columns)
ON DELETE action
ON UPDATE action
*/
#UNIQUE constraints




