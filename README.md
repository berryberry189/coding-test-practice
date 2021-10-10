# coding-test-practice

## 백준, 프로그래머스 풀이 

### 수학

#### 시간 복잡도
- 코드를 짰을때 이 코드가 시간이 얼마나 걸릴지 예측하는 것
- 입력의 크기 N에 대하여 시간이 얼마나 걸릴지 나타내는 방법
- Big O Nation
- 최악의 경우( Big O )에 시간이 얼마나 걸릴지 알 수 있음

#### 소수
- 임의로 N = a*b라고 했을때, a≤√N , b≥√N로 나타낼수 있으므로  √N까지만 검사하면 된다.  (O(√N)) → 제일 빠름

#### 에라토스테네스의 채
- 지워지지 않은 수 중 가장 작은 수를 제외한 모든 배수 삭제
- 6n+1 , 6n+5는 모두 소수

#### 조합 0의 개수
- nCm의 0의 개수를 구하는 문제
- n! / (n-m)! * m!
- 조합은 2와 5의 개수는 동시에 세어줘야함. 둘중 작은 개수로

---

### 다이나믹 프로그래밍- 큰 문제를 작은 문제로 나눠서 푸는 알고리즘  

- 다이나믹 프로그래밍의 조건
    1. Overlapping Subproblem (겹치는 부분문제) 
    2. Optimal Substructure (문제의 정답을 작은 문제의 부분에서 구할 수 있을 때) 
- 각 문제를 한번만 풀어야 함 → 한번 구했으면 정답을 어딘가에 메모해놓는다 ( memoization )

---

### 브루트 포스
- 모든 경우의 수를 다 해보는 방법
- ex) 비밀번호 숫자 4자리일 경우 0000부터 9999까지 다 해보는 것 - 경우의 수 10000
- 브루트 포스로 문제를 풀기 위해서는 다음과 같은 3가지 단계
    1. 문제의 가능한 경우의 수를 계산해본다.
    2. 가능한 모든 방법을 다 만들어본다.
    3. 각각의 방법을 이용해 답을 구해본다

#### 경우의 수
- N명의 사람이 한 줄로 서는 경우의 수 → N × (N-1) × … × 1 = N!  **O(N!)**
- N명의 사람 중에서 대표 두 명을 뽑는 경우의 수 → N × (N-1) / 2!  **O(N^2)**
- N명의 사람 중에서 대표 세 명을 뽑는 경우의 수 → N × (N-1) × (N-2) / 3!  **O(N^3)**
- N명의 사람 중에서 반장 1명과 부반장 1명을 뽑는 경우의 수 → N × (N-1)  **O(N^2)**
- N명의 사람이 있을 때, 각 사람이 영화를 볼지, 보지 않을지 결정한다. 가능한 조합의 수 → 2N  **O(2^N)**

---
### 그래프
- 임의의 정점에서 시작해서 연결되어있는 모든 정점을 1번씩 방문하는 것
#### DFS 깊이 우선 탐색
- Stack
- 스택을 이용해서 갈 수 있는 만큼 최대한 많이 가고 갈 수 없으면 이전 정점으로 돌아간다
- 정점을 방문했는지 안했는지 확인하는 배열을 만든다( 1:방문O , 2:방문X )

#### ⭐BFS 너비 우선 탐색 
- Queue
- 큐를 이용해서 지금 위치에서 갈 수 있는 것을 모두 큐에 넣는 방식
- 큐에 넣을 때 방문했다고 체크해야 한다

#### 문제 유형
1. 모든 정점을 방문하는 것이 주요한 문제 : 둘 다
2. 경로의 특징을 저장해둬야 하는 문제 : DFS
3. 최단거리를 구해야 하는 문제 : BFS

---

## leetcode SQL 풀이

### 기록(21.10.10~)

[185. Department Top Three Salaries](https://leetcode.com/problems/department-top-three-salaries/)
```sql
SELECT d.Name as Department, e.Name as Employee, e.Salary
FROM (
    SELECT *,
        DENSE_RANK() OVER(PARTITION BY DepartmentId ORDER BY Salary DESC) as sal_rank
    FROM Employee ) e
INNER JOIN Department d
ON e.DepartmentId = d.Id
WHERE e.sal_rank <= 3

```

[262. Trips and Users](https://leetcode.com/problems/trips-and-users/)
```sql
SELECT Request_at as Day, 
    ROUND(COUNT(IF(Status != 'completed', TRUE, NULL)) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips 
WHERE (Request_at BETWEEN '2013-10-01' AND '2013-10-03')
AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes') 
AND Driver_Id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
GROUP BY Request_at;

```

