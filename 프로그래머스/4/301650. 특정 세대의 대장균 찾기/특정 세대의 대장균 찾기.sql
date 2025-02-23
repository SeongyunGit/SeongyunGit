-- 코드를 작성해주세요
select f.id 
from ECOLI_DATA as f 
join ECOLI_DATA as s on f.parent_id = s.id
join ECOLI_DATA as t on s.parent_id = t.id
where t.parent_id is null
order by f.id asc;
