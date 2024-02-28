/*
천재지변으로 인해 일부 데이터가 유실되었습니다.
입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는
동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
*/
SELECT outs.animal_id, outs.name
FROM animal_outs outs left outer join animal_ins ins
    on ins.animal_id = outs.animal_id
where outs.animal_id not in (select animal_id
                            from animal_ins
                            group by animal_id)
order by outs.animal_id