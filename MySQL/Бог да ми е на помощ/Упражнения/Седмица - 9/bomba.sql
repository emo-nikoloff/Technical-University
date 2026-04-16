USE school_sport_clubs;

DELIMITER $
CREATE PROCEDURE getCoachInfo(IN coachName VARCHAR(255))
BEGIN

SELECT sports.name, sportgroups.location, sportgroups.hourOfTraining, sportgroups.dayOfWeek, students.name, students.phone
FROM coaches
JOIN sportgroups ON sportgroups.coach_id = coaches.id
JOIN sports ON sports.id = sportgroups.sport_id
JOIN student_sport ON student_sport.sportGroup_id = sportgroups.id
JOIN students ON students.id = student_sport.student_id
WHERE coaches.name = coachName;

END $
DELIMITER ;

CALL getCoachInfo('Ivan Todorov Petkov');

DELIMITER $
CREATE PROCEDURE getSportInfo(IN sportId INT)
BEGIN

SELECT sports.name, students.name, coaches.name
FROM sports
JOIN sportgroups ON sportgroups.sport_id = sports.id
JOIN coaches ON coaches.id = sportgroups.coach_id
JOIN student_sport ON student_sport.sportGroup_id = sportgroups.id
JOIN students ON students.id = student_sport.student_id
WHERE sports.id = sportId;

END $
DELIMITER ;

CALL getSportInfo(1);

drop procedure getAvgTaxes;
DELIMITER $
CREATE PROCEDURE getAvgTaxes(IN studentName VARCHAR(255), IN yearInput INT)
BEGIN

SELECT students.name, AVG(taxespayments.paymentAmount)
FROM students
JOIN taxespayments ON taxespayments.student_id = students.id
WHERE students.name = studentName AND taxespayments.year = yearInput
GROUP BY students.name;
    
END $
DELIMITER ;

CALL getAvgTaxes('Iliyan Ivanov', 2022);

DELIMITER $
CREATE PROCEDURE getCoachGroupsCount(IN coachName VARCHAR(255))
BEGIN

DECLARE groupCount INT;
SELECT COUNT(*)
INTO groupCount
FROM coaches
JOIN sportgroups ON sportgroups.coach_id = coaches.id
WHERE coaches.name = coachName;
IF groupCount = 0 THEN
	SELECT 'Няма водени групи' AS message;
ELSE
	SELECT groupCount;
END IF;
    
END $
DELIMITER ;

CALL getCoachGroupsCount('Ivan Todorov Petkov');