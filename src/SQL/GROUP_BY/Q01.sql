/*
 REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의
 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요.
 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.
 */
select FOOD_TYPE,	REST_ID,	REST_NAME,	FAVORITES
from rest_info r1
where favorites in (select MAX(favorites)   // 가장 많은 즐겨 찾기
                    from rest_info r2
                    where r1.food_type = r2.food_type   // 종류는 다르지만 즐겨찾기 수가 같은 경우
                    group by food_type) // 음식 종류별
order by food_type desc;    // 음식 종류 기준 내림차순