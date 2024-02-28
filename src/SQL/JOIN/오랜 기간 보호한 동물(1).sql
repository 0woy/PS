/*
 아직 입양을 못 간 동물 중,
 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요.
 이때 결과는 보호 시작일 순으로 조회해야 합니다
 */
SELECT ins.name, ins.datetime
    # 보호 테이블 전체 & 입양 테이블 엮음, 입양 테이블 tuple 없어도 null로 둠
from animal_ins ins left join animal_outs outs
                              on ins.animal_id = outs.animal_id
where outs.animal_id is null    # 입양 테이블에 id가 없는 동물
order by ins.datetime limit 3   #보호 시작일 순, 3마리
