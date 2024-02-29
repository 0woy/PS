/*
 동물 보호소에 들어온 동물 중 \
 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의
 아이디와 이름, 성별 및 중성화 여부를 조회하는 SQL 문을 작성해주세요.
 */

-- ^,$로 묶지 않으면 해당 문자를 포함하는 name도 반환함 (Lucycle 이름도 통과함)
SELECT animal_id, name, sex_upon_intake
from animal_ins
where name regexp '^(Lucy|Ella|Pickle|Rogan|Sabrina|Mitty)$'
order by animal_id