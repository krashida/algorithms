/* Leetcode 182. Duplicate Emails

SQL Schema
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.*/


/* Solution 1 */
SELECT DISTINCT P1.Email
FROM Person P1, Person P2
WHERE P1.Email = P2.Email
    AND P1.id <> P2.id;


/* Solution 2 */
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(id) > 1