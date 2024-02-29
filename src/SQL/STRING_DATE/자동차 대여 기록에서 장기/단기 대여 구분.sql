/*
 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서
 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가하여
 대여기록을 출력하는 SQL문을 작성해주세요.
 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.
 */

-- datediff 는 day 차이 반환하여 반환 날짜가 앞으로 와야함
-- timestampdiff는 구분자에 따라서 다양한 값 반환 = timestampdiff(DAY, start_date, end_date)
SELECT history_id, car_id, date_format(start_date,'%Y-%m-%d') as start_date,
       date_format(end_date,'%Y-%m-%d') as end_date,
       case
           when DATEDIFF(end_date,start_date)+1 >= 30 then '장기 대여'
           else '단기 대여'
           END
        as RENT_TYPE
from car_rental_company_rental_history
where '2022-09' = date_format(start_date, '%Y-%m')
order by history_id desc