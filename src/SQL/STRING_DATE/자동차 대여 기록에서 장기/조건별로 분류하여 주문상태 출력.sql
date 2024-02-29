/*
FOOD_ORDER 테이블에서 5월 1일을 기준으로
주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문을 작성해주세요.
출고여부는 5월 1일까지 출고완료로
이 후 날짜는 출고 대기로
미정이면 출고미정으로 출력해주시고,
결과는 주문 ID를 기준으로 오름차순 정렬해주세요.
 */

 -- date는 비교연산자로 날짜 기준을 정할 수 있음
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d') as out_date,
       case when out_date <= '2022-05-01' then '출고완료'
            when out_date >= '2022-05-02' then '출고대기'
            else '출고미정'
           end
    as '출고여부'
from food_order
order by order_id
