-- Queries from 11212025
use classicmodels;
SELECT contactfirstname, contactlastname from customers order by contactlastname desc, contactfirstname asc;
select lastname, firstname, jobtitle from employees where jobtitle = 'Sales Rep';
select lastname, firstname, officecode from employees where jobtitle = 'Sales Rep' and `officeCode` = 1;
select lastname, firstname, jobtitle, officecode from employees where jobtitle = 'Sales Rep' or officecode = 1;
select firstname, lastname, officecode from employees where officecode between 1 and 3;
select firstname, lastname from employees where lastname like '%son';
select firstname, lastname, officecode from employees where officecode in (1, 2, 3);
select lastname from employees order by lastname;
select distinct lastname from employees order by lastname;
SELECT productcode, productname, buyprice FROM products WHERE buyprice BETWEEN 90 AND 100;
SELECT employeenumber, lastname, firstname FROM employees WHERE firstname LIKE "a%";
SELECT status, SUM(quantityordered * priceeach) AS amount
FROM orders INNER JOIN orderdetails USING (orderNumber)
GROUP BY status;

SELECT YEAR(orderDate) AS year, SUM(quantityOrdered * priceEach) AS total
FROM orders INNER JOIN orderdetails USING (orderNumber)
WHERE status = 'Shipped'
GROUP BY year
HAVING year > 2003;

