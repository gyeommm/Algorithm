-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(p.price * os.sales_amount) SALES
from product p
join offline_sale os on p.product_id = os.product_id
group by p.product_code
order by sales desc, p.product_code