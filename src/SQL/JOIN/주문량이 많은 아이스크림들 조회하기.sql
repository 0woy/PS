/*
 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로
 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.
 */
SELECT fh.flavor
from first_half fh left join july j
                             on fh.flavor = j.flavor    # shipment로 묶으면 안댐, 맛 별로 묶이기 때문..
group by fh.flavor
order by sum(fh.total_order+j.total_order) desc limit 3