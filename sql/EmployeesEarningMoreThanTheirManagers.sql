/* Leetcode 181. Employees Earning More Than Their Managers
SQL Schema
The Employee table holds all employees including their managers. Every employee has an Id, and 
there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. 
For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+
*/

SELECT Name as Employee
FROM Employee as E
WHERE Salary > (SELECT Salary
FROM Employee
WHERE Id = E.ManagerId);