-- 코드를 작성해주세요
SELECT F.ID, N.FISH_NAME, F.LENGTH
FROM FISH_INFO F,
FISH_NAME_INFO N
WHERE F.FISH_TYPE = N.FISH_TYPE
AND F.LENGTH = (
                 SELECT MAX(LENGTH)
                 FROM FISH_INFO FF
                 GROUP BY FF.FISH_TYPE
                 HAVING FF.FISH_TYPE = F.FISH_TYPE
                )
ORDER BY F.ID;