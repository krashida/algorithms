/* Leetcode 596. Classes More Than 5 Students
SQL Schema
There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.

For example, the table:

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
Should output:

+---------+
| class   |
+---------+
| Math    |
+---------+
 
Note: The students should not be counted duplicate in each course.*/

/* Using DISTINCT only for test cases where same Student Class combination is
add into table multiple times. Otherwise same student won't take the class twice
in a semester. However, if student is name, its possible to have two different 
students with same name, and with DISTINCT we incorrectly remove one.*/

SELECT studentcount.class
FROM
    (SELECT COUNT(DISTINCT student) as count, class
    FROM courses
    GROUP BY class) as studentcount
WHERE studentcount.count >= 5;