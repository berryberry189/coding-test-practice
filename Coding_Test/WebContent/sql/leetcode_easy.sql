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


-- https://leetcode.com/problems/employees-earning-more-than-their-managers/
-- Employees Earning More Than Their Managers
SELECT Name AS Employee
FROM
    (SELECT A.Id, A.Name, A.Salary, A.ManagerId, B.Salary AS ManagerSalary
     FROM Employee A
     JOIN Employee B
     ON B.Id = A.ManagerId) X
WHERE X.Salary >= X.ManagerSalary
----
SELECT A.Name AS Employee
JOIN Employee B
ON B.Id = A.ManagerId
WHERE A.Salary > B.Salary


-- https://leetcode.com/problems/duplicate-emails/
-- Duplicate Emails
SELECT Email
FROM (SELECT Email, count(Email) AS CNT
      FROM Person
      GROUP BY Email) X
WHERE CNT > 1
----
SELECT Email
FROM Person
GROUP BY Email
HAVING count(*) > 1


-- https://leetcode.com/problems/customers-who-never-order/
-- Customers Who Never Order
SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN (SELECT CustomerId
                 FROM Orders)
----
SELECT A.Name AS Customers
FROM Customers A
LEFT JOIN Orders B
ON B.CustomerId = A.Id
WHERE B.Id is null


-- https://leetcode.com/problems/delete-duplicate-emails/submissions/
-- Delete Duplicate Emails
DELETE p1
FROM Person p1, Person p2
WHERE p1.Email = p2.Email
AND p1.Id > p2.Id

-- https://leetcode.com/problems/rising-temperature/submissions/
-- Rising Temperature
SELECT w1.Id AS Id
FROM Weather w1, Weather w2
WHERE w1.RecordDate = w2.RecordDate + INTERVAL 1 DAY
AND w1.temperature > w2.temperature

-- https://leetcode.com/problems/big-countries/submissions/
-- Big Countries
SELECT name, population, area
FROM World
WHERE population > 25000000 OR area > 3000000
-- ⇩ 왕빠름,,!
SELECT name, population, area
FROM World
WHERE EXISTS (
              SELECT population, area
              WHERE (population > 25000000) OR (area > 3000000)
          )


-- https://leetcode.com/problems/classes-more-than-5-students/
-- Classes More Than 5 Students
-- 개느림
SELECT class
FROM courses
GROUP BY class
HAVING count(distinct student) >= 5
--
SELECT class
FROM (
         SELECT distinct student, class
         FROM courses) X
GROUP BY class
HAVING count(class)>=5


-- https://leetcode.com/problems/not-boring-movies/
-- Not Boring Movies
SELECT *
FROM Cinema
WHERE id%2 <> 0
AND description <> 'boring'
ORDER BY rating DESC


-- https://leetcode.com/problems/swap-salary/
-- Swap Salary
UPDATE salary
SET sex =
        CASE sex
            when 'f' then 'm'
            when 'm' then 'f'
            else sex
        END;


-- https://leetcode.com/problems/reformat-department-table/submissions/
-- Reformat Department Table
SELECT id
     , SUM(CASE WHEN month = "Jan" THEN revenue END) AS Jan_Revenue
     , SUM(CASE WHEN month = "Feb" THEN revenue END) AS Feb_Revenue
     , SUM(CASE WHEN month = "Mar" THEN revenue END) AS Mar_Revenue
     , SUM(CASE WHEN month = "Apr" THEN revenue END) AS Apr_Revenue
     , SUM(CASE WHEN month = "May" THEN revenue END) AS May_Revenue
     , SUM(CASE WHEN month = "Jun" THEN revenue END) AS Jun_Revenue
     , SUM(CASE WHEN month = "Jul" THEN revenue END) AS Jul_Revenue
     , SUM(CASE WHEN month = "Aug" THEN revenue END) AS Aug_Revenue
     , SUM(CASE WHEN month = "Sep" THEN revenue END) AS Sep_Revenue
     , SUM(CASE WHEN month = "Oct" THEN revenue END) AS Oct_Revenue
     , SUM(CASE WHEN month = "Nov" THEN revenue END) AS Nov_Revenue
     , SUM(CASE WHEN month = "Dec" THEN revenue END) AS Dec_Revenue
FROM Department
GROUP BY id

