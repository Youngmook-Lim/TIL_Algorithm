-- 코드를 작성해주세요
SELECT ROUTE, CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km')  AS TOTAL_DISTANCE,
              CONCAT(ROUND((SUM(D_BETWEEN_DIST)) / COUNT(*), 2), 'km')  AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE S
GROUP BY ROUTE
ORDER BY ROUND(SUM(D_BETWEEN_DIST), 1) DESC;