/*
https://www.hackerrank.com/challenges/print-prime-numbers/problem?isFullScreen=true*/
with T as
(SELECT level+1 Num
    FROM dual
    CONNECT BY LEVEL <= 999)
select listagg(t1.Num, '&') within group (order by t1.Num)
from T t1
where not exists
(
    select t2.Num from T t2
    where t2.Num < t1.Num and remainder(t1.Num, t2.Num)=0
);