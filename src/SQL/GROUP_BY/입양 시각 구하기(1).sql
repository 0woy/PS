/*
보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다.
09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요.
이때 결과는 시간대 순으로 정렬해야 합니다.
 */

SELECT hour(datetime) as hour, count(*) as count
from animal_outs
where hour(datetime) between 9 and 19   // 9시 부터 19시까지만 출력
group by hour(datetime) // 시간대 별로 묶음
order by hour;