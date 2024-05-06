-- 코드를 작성해주세요
SELECT  I.ITEM_ID,
        I.ITEM_NAME,
        I.RARITY
FROM    ITEM_INFO I,
        ITEM_TREE T
WHERE   I.ITEM_ID = T.ITEM_ID
AND     NOT EXISTS (SELECT 'X'
                    FROM    ITEM_TREE TT
                    WHERE   T.ITEM_ID = TT.PARENT_ITEM_ID)
ORDER BY I.ITEM_ID DESC;