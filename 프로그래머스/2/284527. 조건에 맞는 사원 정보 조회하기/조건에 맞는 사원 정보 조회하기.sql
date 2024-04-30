-- 코드를 작성해주세요
SELECT G.TOTAL_SCORE AS SCORE, 
       E.EMP_NO,
       E.EMP_NAME,
       E.POSITION,
       E.EMAIL
FROM   HR_DEPARTMENT D,
       HR_EMPLOYEES  E,
       (SELECT *
        FROM   (SELECT EMP_NO, 
                SUM(SCORE) TOTAL_SCORE
                FROM   HR_GRADE
                GROUP BY EMP_NO) GG
        WHERE  GG.TOTAL_SCORE = (SELECT MAX(GGG.TOTAL_SCORE)
                                 FROM   (SELECT EMP_NO, 
                                         SUM(SCORE) TOTAL_SCORE
                                         FROM   HR_GRADE
                                         GROUP BY EMP_NO) GGG)) G
WHERE  D.DEPT_ID = E.DEPT_ID
AND    E.EMP_NO  = G.EMP_NO;