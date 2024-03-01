/*
 PATIENT, DOCTOR 그리고 APPOINTMENT 테이블에서
 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회하는 SQL문을 작성해주세요.
 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목이 출력되도록 작성해주세요.
 결과는 진료예약일시를 기준으로 오름차순 정렬해주세요.
 */
SELECT ap.apnt_no, pt_name, ap.pt_no, ap.mcdp_cd, d.dr_name, ap.apnt_ymd
-- 세 테이블의 교집합
from appointment ap
         join doctor d on ap.mddr_id = d.dr_id
         join patient p on ap.pt_no = p.pt_no
where d.mcdp_cd ='CS'   -- 흉부외과 한정
  and apnt_ymd like '2022-04-13%'   -- 2022년 4월 13일 한정
  and apnt_cncl_yn = 'N'    -- 취소 되지 않은
order by apnt_ymd