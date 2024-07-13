create table employees(id, name) as (
select 1, 'Jeff Xu' from dual
union
select 2, 'Jack' from dual
);
create table hr_records(emp_id, name) as (
select 1, 'Jeff' from dual
union
select 3, 'David' from dual
);

MERGE INTO employees e
    USING hr_records h
    ON (e.id = h.emp_id)
  WHEN MATCHED THEN
    UPDATE SET e.name = h.name
  WHEN NOT MATCHED THEN
    INSERT (id, name)
    VALUES (h.emp_id, h.name);

select * from employees;
