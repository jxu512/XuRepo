create table employee (empID,EmpName,Salary ) as
(
select 1, 'ID-Jeff', 600 from dual
union
select 2, 'ID-James', 600 from dual
union
select 3, 'ID-David', 550 from dual
union
select 4, 'ID-Frank', 650 from dual
);
SELECT empID, EmpName, Salary
FROM employee
WHERE salary > 500 AND salary < 700 and EmpName like '%ID%'
ORDER BY Salary desc, empID;
