/*
 '경제' 카테고리에 속하는 도서들의
 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
결과는 출판일을 기준으로 오름차순 정렬해주세요.
 */
SELECT Book_id, author_name, date_format(published_date, '%Y-%m-%d') AS PUBLISHED_DATE
from book b inner join author a
                       on b.author_id = a.author_id
where b.category = '경제'
order by published_date;
