-- 코드를 작성해주세요
select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from developers d
join skillcodes as s on (d.skill_code & s.code) > 0
where s.category = 'Front End'
order by d.id


# select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
# from developers d
# join (select code
#         from skillcodes
#         where category = 'Front End') as c on (d.skill_code & c.code) > 0
# order by d.id