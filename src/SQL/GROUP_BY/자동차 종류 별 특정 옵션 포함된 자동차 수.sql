/*
CAR_RENTAL_COMPANY_CAR 테이블에서
'통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된
자동차가 자동차 종류 별로 몇 대인지 출력하는 SQL문을 작성해주세요.
이때 자동차 수에 대한 컬럼명은 CARS로 지정하고,
결과는 자동차 종류를 기준으로 오름차순 정렬해주세요.
 */
SELECT CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where options regexp '가죽시트|열선시트|통풍시트'   // 복수 개의 특정 문자열 포함 여부
group by car_type   // 자동차 종류별
order by car_type;