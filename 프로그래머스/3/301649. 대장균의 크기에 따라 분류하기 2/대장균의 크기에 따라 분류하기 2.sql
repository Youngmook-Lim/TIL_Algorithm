-- 코드를 작성해주세요

SELECT A.ID, CASE WHEN A.NO <= A.TOTAL / 4
                THEN 'CRITICAL'
                WHEN A.NO <= A.TOTAL / 4 * 2
                THEN 'HIGH'
                WHEN A.NO <= A.TOTAL / 4 * 3
                THEN 'MEDIUM'
                ELSE 'LOW'
             END AS COLONY_NAME
FROM (SELECT ID, ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS NO, (SELECT COUNT(*) FROM ECOLI_DATA) AS TOTAL
      FROM ECOLI_DATA) A
ORDER BY ID;