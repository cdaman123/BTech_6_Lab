CREATE TABLE SALESMAN(
    salesman_id decimal(4),
    name varchar(30),
    city varchar(30),
    commission decimal(4,2)
);

CREATE TABLE CUSTOMER(
    customer_id decimal(4),
    cust_name varchar(30),
    city varchar(30),
    grade decimal(3),
    salesman_id decimal(4)
);

CREATE TABLE ORDERS (
    ord_no decimal(5),
    purch_amt decimal(8,2),
    ord_date date,
    customer_id decimal(4),
    salesman_id decimal(4)
);

INSERT INTO SALESMAN VALUES
(5001,'James Hoog','New York','0.15'),
(5002,'Nail Knite','Paris',0.13),
(5005,'Pit Alex','London',0.11),
(5006,'Mc Lyon','Paris',0.14),
(5003,'Lauson Hen',Null,0.12),
(5007,'Paul Adam','Rome',0.13);

INSERT INTO CUSTOMER VALUES
(3002,'Nick Rimando','New York',100,5001),
(3005,'Graham Zusi','California',200,5002),
(3001,'Brad Guzan','Landon',Null,5005),
(3004,'Fabian Johns','Paris',300,5006),
(3007,'Brad Davis','New York',200,5001),
(3009,'Geoff Camero','Berlin',100,5003),
(3008,'Julian Green','London',300,5002),
(3003,'Jozy Altidoer','Moscow',200,5007);

INSERT INTO ORDERS VALUES
(70001,150.5,'2012-10-05',3005,5002),
(70009,270.65,'2012-09-10',3001,5005),
(70002,65.26,'2012-10-05',3002,5001),
(70004,110.5,'2012-08-17',3009,5003),
(70007,948.5,'2012-09-10',3005,5002),
(70005,2400.6,'2012-07-27',3007,5001),
(70008,5760,'2012-09-10',3002,5001);

SELECT * FROM SALESMAN;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;


SELECT CUSTOMER.cust_name,
SALESMAN.name, SALESMAN.city
FROM SALESMAN, CUSTOMER
WHERE SALESMAN.city = CUSTOMER.city;

SELECT CUSTOMER.cust_name, SALESMAN.name as salesman_name
FROM CUSTOMER  
INNER JOIN SALESMAN  
ON CUSTOMER.salesman_id = SALESMAN.salesman_id;

SELECT DISTINCT(cust_name),grade FROM CUSTOMER 
WHERE customer_id  IN 
(SELECT DISTINCT(customer_id) FROM ORDERS) 
AND grade is not NULL;

SELECT * FROM SALESMAN 
WHERE commission
BETWEEN 0.12 AND 0.14;

SELECT ord_no, cust_name, commission AS "Commission%",
purch_amt*commission AS "Commission"
FROM SALESMAN,ORDERS,CUSTOMER
WHERE ORDERS.customer_id = CUSTOMER.customer_id
AND ORDERS.salesman_id = SALESMAN.salesman_id
AND CUSTOMER.grade>=200;

SELECT * FROM SALESMAN;

SELECT DISTINCT(salesman_id)
FROM ORDERS;

SELECT name,city 
FROM SALESMAN
WHERE city = 'Paris';

SELECT * FROM CUSTOMER
WHERE grade = 200;

SELECT * FROM SALESMAN
WHERE city in ('Paris','Rome');

SELECT 22*4*(212+16)/31 as Ans;

SELECT * FROM SALESMAN
WHERE name LIKE 'N__l%';

SELECT SUM(purch_amt) as 'Total Purchase Amt'
FROM ORDERS;

SELECT cust_name FROM CUSTOMER, 
    (SELECT MAX(purch_amt),customer_id 
    FROM ORDERS WHERE purch_amt NOT IN 
        (SELECT MAX(purch_amt) FROM ORDERS)) AS P 
WHERE CUSTOMER.customer_id = P.customer_id;

UPDATE CUSTOMER
SET grade = grade*1.1
WHERE salesman_id > 5003;
SELECT * FROM CUSTOMER;

SELECT SYSDATE() AS 'System Date';

SELECT UPPER(cust_name) FROM CUSTOMER;

SELECT AVG(purch_amt) FROM ORDERS;

SELECT ROUND(25.625,1);

SELECT REPLACE('Data management system', 'Data', 'Database') 
AS 'converted str';