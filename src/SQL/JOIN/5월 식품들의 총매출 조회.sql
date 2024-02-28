/*
 FOOD_PRODUCT와 FOOD_ORDER 테이블에서 생산일자가 2022년 5월인 식품들의
 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요.
 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면
 식품 ID를 기준으로 오름차순 정렬해주세요.
 */

SELECT fo.product_id, fp.product_name, sum(fo.amount * fp.price) as TOTAL_SALES
from food_product fp left join food_order fo
                               on fp.product_id = fo.product_id
where '2022-05' = date_format(fo.produce_date, '%Y-%m') #여기서 order 내역이 & 2022년 5월 조건 걸림
group by fo.product_id # 같은 상품이 여러번 팔릴 수 있음
order by TOTAL_SALES desc, fo.product_id    # 정렬