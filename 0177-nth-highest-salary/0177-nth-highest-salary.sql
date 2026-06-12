CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    declare m int;
    set m = n-1;
  RETURN (
        select distinct salary from Employee order by salary desc limit 1 offset m
      # Write your MySQL query statement below.
  );
END