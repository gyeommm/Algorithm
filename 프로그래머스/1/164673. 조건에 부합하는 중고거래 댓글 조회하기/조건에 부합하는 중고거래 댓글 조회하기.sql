-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, "%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD b
join USED_GOODS_REPLY r using (BOARD_ID)
where year(b.CREATED_DATE) = 2022 and month(b.CREATED_DATE) = 10
order by CREATED_DATE, title;