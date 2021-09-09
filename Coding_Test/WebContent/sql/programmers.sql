-- 입양 시각 구하기(1)
-- https://programmers.co.kr/learn/courses/30/lessons/59412
SELECT hour(DATETIME), count(1)
from ANIMAL_OUTS
where hour(DATETIME) between 9 and 19
group by hour(DATETIME)
order by hour(DATETIME);

-- ============================================================
-- 입양 시각 구하기(2)
-- https://programmers.co.kr/learn/courses/30/lessons/59413
-- mysql
SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR,
       (SELECT COUNT(HOUR(DATETIME))
        FROM ANIMAL_OUTS
        WHERE HOUR(DATETIME)=@HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23
-- oracle
SELECT HOUR, COUNT(AO.DATETIME) AS COUNT
FROM
    (
    SELECT LEVEL-1 AS HOUR
    FROM DUAL
    CONNECT BY LEVEL<=24
    )A LEFT JOIN ANIMAL_OUTS AO
ON A.HOUR = TO_CHAR(AO.DATETIME,'HH24')
GROUP BY HOUR
ORDER BY HOUR;

-- ============================================================
-- NULL 처리하기
-- https://programmers.co.kr/learn/courses/30/lessons/59410
-- mysql
SELECT ANIMAL_TYPE, IFNULL(NAME,'NO NAME'), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
-- oracle
SELECT ANIMAL_TYPE, NVL(NAME,'NO NAME'), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- ============================================================
-- 없어진 기록 찾기
-- https://programmers.co.kr/learn/courses/30/lessons/59042
-- mysql
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_OUTS B
WHERE B.ANIMAL_ID NOT IN (
    SELECT DISTINCT A.ANIMAL_ID
    FROM ANIMAL_INS A );
-- oracle
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A
LEFT OUTER JOIN ANIMAL_INS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.ANIMAL_ID

-- ============================================================
-- 있었는데요 없었습니다
-- https://programmers.co.kr/learn/courses/30/lessons/59043
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A
JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.DATETIME > B.DATETIME
ORDER BY A.DATETIME;

-- ============================================================
-- 오랜 기간 보호한 동물(1)
-- https://programmers.co.kr/learn/courses/30/lessons/59044
-- mysql
SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS A
LEFT JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME
LIMIT 3;
-- oracle
SELECT X.* FROM
    ( SELECT  A.NAME, A.DATETIME
      FROM ANIMAL_INS A
      LEFT JOIN ANIMAL_OUTS B
      ON A.ANIMAL_ID = B.ANIMAL_ID
      WHERE B.ANIMAL_ID IS NULL
      ORDER BY A.DATETIME ) X
WHERE ROWNUM <= 3;

-- ============================================================
-- 보호소에서 중성화한 동물
-- https://programmers.co.kr/learn/courses/30/lessons/59045?language=oracle
SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A , ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID
AND A.SEX_UPON_INTAKE LIKE 'Intact%'
AND ( B.SEX_UPON_OUTCOME LIKE 'Spayed%'
    AND B.SEX_UPON_OUTCOME LIKE 'Neutered%');

SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A , ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID
AND  A.SEX_UPON_INTAKE LIKE 'Intact%'
AND  REGEXP_LIKE( B.SEX_UPON_OUTCOME ,'^Spayed|^Neutered');









