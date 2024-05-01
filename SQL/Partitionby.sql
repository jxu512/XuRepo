--with Employee as
create table Employee(id, name, manager_id, Salary) as
(
    select 1 as id, 'Jeff' as name, null as manager_id, 50 as Salary from dual
    union
    select 2 as id, 'Jim' as name, 1 as manager_id, 120 as Salary from dual
    union
    select 3 as id, 'David' as name, 1 as manager_id, 80 as Salary from dual
    union
    select 4 as id, 'Dan' as name, 2 as manager_id, 90 as Salary from dual
    union
    select 5 as id, 'Jessica' as name, 2 as manager_id, 100 as Salary from dual
    union
    select 6 as id, 'Jane' as name, 3 as manager_id, 110 as Salary from dual
    union
    select 7 as id, 'Liz' as name, 4 as manager_id, 130 as Salary from dual
    union
    select 8 as id, 'Jack' as name, 5 as manager_id, 80 as Salary from dual
    union
    select 9 as id, 'Peter' as name, 6 as manager_id, 120 as Salary from dual
    union
    select 10 as id, 'Jane' as name, 8 as manager_id, 50 as Salary from dual
    union
    select 5 as id, 'Frank' as name, 5 as manager_id, 180 as Salary from dual
    union
    select 6 as id, 'Jenny' as name, 2 as manager_id, 190 as Salary from dual
)
-- ";" needed for create table but not for with clause
;
select id, lpad(Name, 10, '.'), Salary,
min(Salary) over (partition by manager_id) MinSalary,
max(Salary) over (partition by manager_id) MaxSalary,
round(Avg(Salary) over (partition by manager_id), 0) AvgSalary,
manager_id, row_number() over (partition by manager_id order by name) ranking
from Employee
order by manager_id, ranking
;