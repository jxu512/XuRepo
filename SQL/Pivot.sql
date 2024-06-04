--with Compony as
create table Company(id, name, country) as
(
    select 1 as id, 'IBM' as name, 'USA' as Country from dual
    union
    select 2 as id, 'HP' as name, 'USA' as Country from dual
    union
    select 3 as id, 'Barclays' as name, 'UK' as Country from dual
    union
    select 4 as id, 'Simens' as name, 'Germany' as Country from dual
    union
    select 5 as id, 'Alibaba' as name, 'China' as Country from dual
    union
    select 6 as id, 'Volvo' as name, 'Sweden' as Country from dual
    union
    select 7 as id, 'Bank of China' as name, 'China' as Country from dual
    union
    select 8 as id, 'Toyota' as name, 'Japan' as Country from dual
    union
    select 9 as id, 'Honda' as name, 'Japan' as Country from dual
)
-- ";" needed for create table but not for with clause
;
/*
Oracle adds an implicit group by for all the columns not in the pivot clause. Use an inline view that selects just the columns you want in the results
*/
-- this not work
select * from  Company
pivot ( count(name) for Country in ( 'USA', 'UK', 'Germany', 'Sweden', 'China', 'Japan' ) )
;

-- this works
select * from
( select name, country from Company )
pivot ( count(name) for Country in ( 'USA', 'UK', 'Germany', 'Sweden', 'China', 'Japan' ) )
--pivot XML ( count(name) for Country in ( select Country from Company ) )
;