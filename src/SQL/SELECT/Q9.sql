/*
 USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서
 2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요.
 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고,
 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬해주세요.
 */
SELECT ub.TITLE, ub.BOARD_ID, ur.REPLY_ID, ur.WRITER_ID, ur.CONTENTS,
       date_format(ur.CREATED_DATE,'%Y-%m-%d') CREATED_DATE
from USED_GOODS_BOARD ub, USED_GOODS_REPLY ur
where year(ub.created_date) = 2022 and month(ub.created_date)=10
  and ur.board_id = ub.board_id
order by ur.created_date asc, ub.title