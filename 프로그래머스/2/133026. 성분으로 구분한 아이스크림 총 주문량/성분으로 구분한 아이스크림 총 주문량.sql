-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, sum(TOTAL_ORDER) total_order
from first_half f
join icecream_info i on f.flavor = i.flavor
group by i.ingredient_type
order by total_order