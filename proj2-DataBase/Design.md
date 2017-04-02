# Design for Project2-Database

1. How to represent a Table.
    * A constructor.
    * An "addRow" method.
    * A main method that creates table T1 from this lab using the constructor and addRow methods.

2. How to implement "join" methods.

## Commands

1. It is an error to create a table with no columns and it is also an error to create a table that already exists.
"create table" should return the empty string on success, or an appropriate error message.

2. load table name Load the table stored in the file table name.tbl into memory, giving it the name table name.
If a table with the same name already exists, it should be replaced. If the relevant table file is an invalid table, it is an error.

3. Store "table name" write the content of fa database table to the file "table name".tbl.
If already exists, overwritten existed file.
Should return a empty string on success, or an appropriate error message.

4. Drop table: Delete the table from database.

5. Insert into: Insert the given row (the list of literals) to the named table.
The table must already be in the DB and the provided values must match the columns of that table.
It is an error to insert a row that does not match the given table.

Insert Into should return the empty String on success, or an appropriate error message otherwise

6. print "table name" should return the String representation of the table, or an appropriate error message.

7. Select: Select statements are used to extract data from the database.
The order of the columns in the new table is defined by the order they are listed in the select. In the case that all columns are selected (with the * operator), the order is defined by the column order for the join.

It is an error to write a select statement that involved no columns of the listed tables.

Select should return the String representation of the produced table, or an appropriate error message otherwise.