-- https://leetcode.com/problems/combine-two-tables/submissions/
-- Combine Two Tables
SELECT A.FirstName, A.LastName, B.City, B.State
FROM Person A
LEFT JOIN Address B
ON A.PersonId = B.PersonId;


-- https://leetcode.com/problems/second-highest-salary/
-- Second Highest Salary
SELECT Salary AS SecondHighestSalary
FROM (SELECT Salary
      FROM Employee
      ORDER BY Salary DESC LIMIT 2) AS A
ORDER BY Salary LIMIT 1;
-- 2번째로 큰 값이 없을 경우에는 null 값을 나오게 하면 된다 => 무조건 MAX 사용
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary NOT IN ( SELECT Max(Salary) FROM Employee);


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