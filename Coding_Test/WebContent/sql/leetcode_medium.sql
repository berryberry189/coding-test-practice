-- https://leetcode.com/problems/nth-highest-salary/submissions/
-- Nth Highest Salary
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN SET N = N-1;
RETURN (
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET N
    );
END

-- https://leetcode.com/problems/rank-scores/submissions/
-- Rank Scores
SELECT score, DENSE_RANK() OVER (ORDER BY Score DESC) AS 'Rank'
FROM Scores


-- https://leetcode.com/problems/consecutive-numbers/submissions/
-- Consecutive Numbers
-- 느림
SELECT distinct a.num as ConsecutiveNums
FROM logs a
INNER JOIN logs b
ON a.id + 1 = b.id AND a.num = b.num
INNER JOIN logs c
ON a.id + 2 = c.id AND a.num = c.num;

-- 빠름
SELECT DISTINCT L.Num as ConsecutiveNums
FROM(
    SELECT Id, Num
         , Lag(Num) OVER (ORDER BY Id) as 'Lag'    -- Num - 1
         , Lead(Num) OVER (ORDER By Id) as 'Lead'  -- Num + 1
    FROM Logs) L
WHERE L.Num = L.Lag AND L.Lag = L.Lead


-- https://leetcode.com/problems/department-highest-salary/
-- Department Highest Salary
SELECT d.Name AS Department
     , m.Name AS Employee
     , m.Maxsalary AS Salary
FROM (  SELECT *, MAX(Salary) OVER (PARTITION BY DepartmentId) AS MaxSalary
        FROM Employee ) m
INNER JOIN Department d
ON m.DepartmentId = d.Id
WHERE m.Salary = m.Maxsalary


-- https://leetcode.com/problems/exchange-seats/
-- Exchange Seats
SELECT (CASE WHEN mod(id,2)=0 THEN id-1
             WHEN id= (SELECT COUNT(*) FROM seat) then id
             ELSE id+1 END) AS id, student
FROM seat
ORDER BY id ASC










