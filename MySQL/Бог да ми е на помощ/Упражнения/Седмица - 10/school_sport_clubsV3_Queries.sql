USE school_sport_clubs;

CREATE VIEW coaches_salary_view AS
SELECT 
    coaches.name as coach_name,
    CONCAT(sportGroups.location, ' - ', sportGroups.id) AS groupInfo,
    sports.name as sport_name,
    salaryPayments.year,
    salaryPayments.month,
    salaryPayments.salaryAmount
FROM coaches
JOIN sportGroups ON coaches.id = sportGroups.coach_id
JOIN sports ON sportGroups.sport_id = sports.id
JOIN salaryPayments ON coaches.id = salaryPayments.coach_id
WHERE salaryPayments.month = MONTH(NOW()) AND salaryPayments.year = YEAR(NOW());

SELECT * FROM coaches_salary_view;

DELIMITER $
CREATE PROCEDURE students_in_multiple_groups()
BEGIN
    SELECT students.name
    FROM students
    JOIN student_sport ON students.id = student_sport.student_id
    GROUP BY students.id, students.name
    HAVING COUNT(student_sport.sportGroup_id) > 1;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE coaches_without_groups()
BEGIN
    SELECT coaches.name
    FROM coaches
    LEFT JOIN sportGroups ON coaches.id = sportGroups.coach_id
    WHERE sportGroups.id IS NULL;
END $
DELIMITER ;