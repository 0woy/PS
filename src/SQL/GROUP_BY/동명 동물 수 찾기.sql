/*
 동물 보호소에 들어온 동물 이름 중
 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작성해주세요.
 이때 결과는 이름이 없는 동물은 집계에서 제외하며,
 결과는 이름 순으로 조회해주세요.
 */
SELECT name, count(*) as count
from animal_ins
where name is not null  // 이름 없는 동물 제외
group by name   // 이름 별 묶음
having count(name) >=2  // 두 번 이상 쓰인 이름
order by name