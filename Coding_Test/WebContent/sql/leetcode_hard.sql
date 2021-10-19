
-- 185. Department Top Three Salaries
-- https://leetcode.com/problems/department-top-three-salaries/
SELECT d.Name as Department, e.Name as Employee, e.Salary
FROM (
    SELECT *,
        DENSE_RANK() OVER(PARTITION BY DepartmentId ORDER BY Salary DESC) as sal_rank
    FROM Employee ) e
INNER JOIN Department d
ON e.DepartmentId = d.Id
WHERE e.sal_rank <= 3


-- 262. Trips and Users
-- https://leetcode.com/problems/trips-and-users/

SELECT Request_at as Day,
    ROUND(COUNT(IF(Status != 'completed', TRUE, NULL)) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips
WHERE (Request_at BETWEEN '2013-10-01' AND '2013-10-03')
AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
AND Driver_Id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
GROUP BY Request_at;


-- 601. Human Traffic of Stadium
-- https://leetcode.com/problems/human-traffic-of-stadium/
SELECT distinct t1.*
from Stadium t1, Stadium t2, Stadium t3
WHERE t1.people >= 100 AND t2.people >= 100 AND t3.people >= 100
AND(
    (t1.id - t2.id = 1 and t1.id - t3.id = 2 and t2.id - t3.id =1)  -- t1, t2, t3
    or
    (t2.id - t1.id = 1 and t2.id - t3.id = 2 and t1.id - t3.id =1) -- t2, t1, t3
    or
    (t3.id - t2.id = 1 and t2.id - t1.id =1 and t3.id - t1.id = 2) -- t3, t2, t1
)
order by t1.id