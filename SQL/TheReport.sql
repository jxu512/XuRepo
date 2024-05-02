/*
You are given two tables: Students and Grades. Students contains three columns ID, Name and Marks.

Ketty gives Eve a task to generate a report containing three columns: Name, Grade and Mark. Ketty
doesn't want the NAMES of those students who received a grade lower than 8. The report must be in descending order by grade -- i.e.
higher grades are entered first. If there is more than one student with the same grade (8-10) assigned to them, order those
particular students by their name alphabetically. Finally, if the grade is lower than 8, use "NULL" as their name and list
them by their grades in descending order. If there is more than one student with the same grade (1-7) assigned to t

*/

select
case
  when s.marks>=70 then s.NAME
  else null
end Name,
g.Grade,s.marks
from Students s, Grades g
where s.marks between g.Min_Mark and g.Max_Mark
order by g.grade desc,s.Name,s.Marks desc
;
