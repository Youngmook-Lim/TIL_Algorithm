-- 코드를 작성해주세요
SELECT   YEAR(T.YM)               AS YEAR,
         ROUND(AVG(T.PM_VAL1), 2) AS PM10, 
         ROUND(AVG(T.PM_VAL2), 2) AS 'PM2.5'
FROM    (SELECT *
         FROM   AIR_POLLUTION
         WHERE  LOCATION1 = '경기도'
         AND    LOCATION2 = '수원') T
GROUP BY YEAR(T.YM)
ORDER BY YEAR;