USE school_sport_clubs;

DELIMITER $
CREATE TRIGGER before_salarypayments_delete
BEFORE DELETE ON salarypayments
FOR EACH ROW
BEGIN
	INSERT INTO salarypayments_log(
		operation,
		old_coach_id,
		old_month,
		old_year,
		old_salaryAmount,
		old_dateOfPayment,
		dateOfLog
	)
	VALUES(
		'DELETE',
		OLD.coach_id,
		OLD.month,
		OLD.year,
		OLD.salaryAmount,
		OLD.dateOfPayment,
		NOW()
	);
END $
DELIMITER ;

DELETE FROM salarypayments WHERE id > 0;

INSERT INTO salarypayments(coach_id, month, year, salaryAmount, dateOfPayment)
SELECT 
	old_coach_id,
	old_month,
	old_year,
	old_salaryAmount,
	old_dateOfPayment
FROM salarypayments_log
WHERE operation = 'DELETE';

SELECT * FROM salarypayments_log;

DELIMITER $
CREATE TRIGGER before_student_sport_insert
BEFORE INSERT ON student_sport
FOR EACH ROW
BEGIN
	DECLARE group_count INT;

	SELECT COUNT(*) INTO group_count
	FROM student_sport
	WHERE student_id = NEW.student_id;

	IF group_count >= 2 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Student cannot participate in more than 2 groups!';
	END IF;
END $
DELIMITER ;

SELECT * FROM student_sport WHERE student_id = 1;

INSERT INTO student_sport VALUES (1, 2);

CREATE VIEW students_groups_count AS
SELECT 
	students.name,
	COUNT(student_sport.sportGroup_id) AS groups_count
FROM students
JOIN student_sport ON students.id = student_sport.student_id
GROUP BY students.id, students.name;

SELECT * FROM students_groups_count;

DELIMITER $
CREATE PROCEDURE students_by_coach(IN coach_name VARCHAR(255))
BEGIN
	SELECT 
		students.name,
		sportGroups.id,
		sports.name
	FROM coaches
	JOIN sportGroups ON coaches.id = sportGroups.coach_id
	JOIN student_sport ON sportGroups.id = student_sport.sportGroup_id
	JOIN students ON students.id = student_sport.student_id
	JOIN sports ON sports.id = sportGroups.sport_id
	WHERE coaches.name = coach_name;
END $
DELIMITER ;

CALL students_by_coach('Ivan Todorov Petkov');

DELIMITER $
CREATE PROCEDURE coaches_by_sport(IN sport_name VARCHAR(255))
BEGIN
	SELECT 
		coaches.name,
		sportGroups.location,
		sportGroups.hourOfTraining,
		sportGroups.dayOfWeek
	FROM sports
	JOIN sportGroups ON sports.id = sportGroups.sport_id
	JOIN coaches ON coaches.id = sportGroups.coach_id
	WHERE sports.name = sport_name;
END $
DELIMITER ;

CALL coaches_by_sport('Football');