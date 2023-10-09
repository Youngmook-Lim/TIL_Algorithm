-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, SUM(OS.SALES_AMOUNT) * (SELECT PRICE FROM PRODUCT P2 WHERE P.PRODUCT_CODE = P2.PRODUCT_CODE) AS SALES
FROM PRODUCT P
INNER JOIN OFFLINE_SALE OS
ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC, P.PRODUCT_CODE;