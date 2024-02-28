/*
 PRODUCT 테이블과 OFFLINE_SALE 테이블에서
 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요.
 결과는 매출액을 기준으로 내림차순 정렬해주시고
 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.
 */

select p.product_code, (sum(sales_amount) * p.price) as sales
from offline_sale off inner join product p
    on off.product_id = p.product_id
group by p.product_code     # Group by절은 select 절에 포함된 칼럼만 사용
                            # 애초에 상품 코드 별이라고 명시 됨..
order by sales desc, p.product_code;