/*
 MEMBER_PROFILE와 REST_REVIEW 테이블에서
 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요.
 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고,
 결과는 리뷰 작성일을 기준으로 오름차순,
 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.
 */
-- 코드를 입력하세요
SELECT member.member_name, rest.review_text, date_format(rest.review_date, '%Y-%m-%d') as REVIEW_DATE
from member_profile member join rest_review rest
                                on member.member_id = rest.member_id # join =inner join (교집합)
where member.member_id = (select member_id
                          from rest_review
                          group by member_id
                          order by count(*) desc limit 1) # 리뷰를 가장 많이 쓴 1명의 아이디
order by rest.review_date, rest.review_text