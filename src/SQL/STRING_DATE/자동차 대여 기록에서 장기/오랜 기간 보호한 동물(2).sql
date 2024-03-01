/*
 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.
 */
SELECT ai.animal_id, ai.name
-- 입양 간 동물 = 보호 테이블 & 입양 테이블 교집합
from animal_ins ai join animal_outs ao
                        on ai.animal_id = ao.animal_id
order by datediff(ao.datetime, ai.datetime) desc -- 보호 기간 순으로 내림차순
    limit 2 -- 두 마리만 출력