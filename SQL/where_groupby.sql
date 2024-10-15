-- where is executed before group by
-- below two queries are different

with T as
(
select 1 SOURCE_REF from dual union all
select 1 SOURCE_REF from dual union all
select 2 SOURCE_REF from dual union all
select 3 SOURCE_REF from dual union all
select 1 SOURCE_REF from dual
)
select SOURCE_REF from T
where rownum=1
group by SOURCE_REF
having(count(*)=1)
;

with T as
(
select 1 SOURCE_REF from dual union all
select 1 SOURCE_REF from dual union all
select 2 SOURCE_REF from dual union all
select 3 SOURCE_REF from dual union all
select 1 SOURCE_REF from dual
)
select SOURCE_REF from
(
select SOURCE_REF from T
group by SOURCE_REF
having(count(*)=1)
)
where rownum=1
;
