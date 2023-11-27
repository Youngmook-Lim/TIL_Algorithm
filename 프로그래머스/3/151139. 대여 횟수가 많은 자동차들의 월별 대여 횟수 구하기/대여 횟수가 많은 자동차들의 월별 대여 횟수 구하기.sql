-- 코드를 입력하세요
SELECT TO_NUMBER(TO_CHAR(START_DATE, 'mm')) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT CAR_ID
     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
     WHERE START_DATE >= TO_DATE('20220801', 'YYYYMMDD')
     AND START_DATE <= TO_DATE('20221031', 'YYYYMMDD')
     GROUP BY CAR_ID
     HAVING COUNT(*) >= 5
     )
AND START_DATE >= TO_DATE('20220801', 'YYYYMMDD')
AND START_DATE <= TO_DATE('20221031', 'YYYYMMDD')
GROUP BY TO_NUMBER(TO_CHAR(START_DATE, 'mm')), CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH, CAR_ID DESC;