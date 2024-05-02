--with Employee as
create table Employee(id, name, manager_id) as
(
    select 1 as id, 'Jeff' as name, null as manager_id from dual
    union
    select 2 as id, 'Jim' as name, 1 as manager_id from dual
    union
    select 3 as id, 'David' as name, 1 as manager_id from dual
    union
    select 4 as id, 'Dan' as name, 2 as manager_id from dual
    union
    select 5 as id, 'Jessica' as name, 2 as manager_id from dual
    union
    select 6 as id, 'Jane' as name, 3 as manager_id from dual
    union
    select 7 as id, 'Liz' as name, 4 as manager_id from dual
    union
    select 8 as id, 'Jack' as name, 5 as manager_id from dual
    union
    select 9 as id, 'Peter' as name, 6 as manager_id from dual
    union
    select 10 as id, 'Jane' as name, 8 as manager_id from dual
)
-- ";" needed for create table but not for with clause
;
select level, id, lpad(name,10,'.'), manager_id, prior name "Manager", SYS_CONNECT_BY_PATH(name, '/') "Path"
from Employee
start with id=1
connect by prior id =  manager_id
order by level, id
;