/*
 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의
 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.
 */
SELECT outs.animal_id, outs.animal_type, outs.name
from animal_ins ins join animal_outs outs
                         on ins.animal_id = outs.animal_id  # 보호 & 입양 테이블 둘 다 존재
where sex_upon_intake like 'Intact%'    # 보호 시 비 중성화
  and sex_upon_outcome regexp 'Spayed|Neutered' # 입양 시 중성화
order by outs.animal_id