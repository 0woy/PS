/*
 USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서
 완료된 중고 거래의 총금액이 70만 원 이상인 사람의
 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요.
 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.
 */

SELECT USER_ID,	NICKNAME, sum(price) as	TOTAL_SALES
from USED_GOODS_BOARD b
         INNER JOIN USED_GOODS_USER u
                    ON b.writer_id = u.user_id
where status ='DONE'    // 완료된 중고 거래
group by u.user_id      // 회원 별
having sum(price) >= 700000 // 총 거래금액 70만원 이상
order by TOTAL_SALES
