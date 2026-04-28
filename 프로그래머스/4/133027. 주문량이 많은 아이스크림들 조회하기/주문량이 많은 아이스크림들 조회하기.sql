-- 코드를 입력하세요
SELECT f.flavor
from ((select flavor, sum(total_order) total_order
      from first_half
      group by flavor) f
join
     (select flavor, sum(total_order) total_order
      from july
      group by flavor) j
      on f.flavor = j.flavor)
order by f.total_order + j.total_order desc
limit 3