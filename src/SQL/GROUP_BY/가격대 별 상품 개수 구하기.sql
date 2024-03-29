/*
 PRODUCT 테이블에서 만원 단위의 가격대 별로 상품 개수를 출력하는 SQL 문을 작성해주세요.
 이때 컬럼명은 각각 컬럼명은 PRICE_GROUP, PRODUCTS로 지정해주시고
 가격대 정보는 각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시해주세요.
 결과는 가격대를 기준으로 오름차순 정렬해주세요.
 */
SELECT(CASE
           WHEN PRICE <10000 THEN 0 // 만 원 미만인 경우는 0으로 기재
           ELSE TRUNCATE(PRICE, -4) // 소수점 기준 뒤에서 4자리 버림 10000인 경우 1
    END) AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP
