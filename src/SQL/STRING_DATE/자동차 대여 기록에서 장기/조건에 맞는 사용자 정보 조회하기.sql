/*
USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서
중고 거래 게시물을 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성해주세요.
이때, 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력되도록 해주시고,
전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력해주세요.
결과는 회원 ID를 기준으로 내림차순 정렬해주세요.
 */
SELECT user_id, nickname,
       -- 주소 함께 출력
       concat(city, ' ', street_address1, ' ',street_address2)as address,
       -- 전화 번호 출력 형식 변경
       concat(substr(tlno, 1,3), '-', substr(tlno, 4,4), '-', substr(tlno, 8))
                                                              as tlno
from used_goods_user
-- 중고 거래 게시물을 3건 이상 등록
where user_id in (select writer_id
                  from used_goods_board
                  group by writer_id
                  having count(*) >=3)
order by user_id desc   -- 정렬