USE school_sport_clubs;

SELECT students.name, students.class, students.phone
FROM students
JOIN student_sport ON students.id = student_sport.student_id
JOIN sportGroups ON student_sport.sportGroup_id = sportGroups.id
JOIN sports ON sportGroups.sport_id = sports.id
WHERE sports.name = 'Football';

SELECT coaches.name
FROM coaches
JOIN sportGroups ON coaches.id = sportGroups.coach_id
JOIN sports ON sportGroups.sport_id = sports.id
WHERE sports.name = 'Volleyball';

SELECT coaches.name, sports.name, sportGroups.dayOfWeek, sportGroups.location
FROM students
JOIN student_sport ON students.id = student_sport.student_id
JOIN sportGroups ON student_sport.sportGroup_id = sportGroups.id
JOIN coaches ON sportGroups.coach_id = coaches.id
JOIN sports ON sportGroups.sport_id = sports.id
WHERE students.name = 'Maria Hristova Dimova';

SELECT taxesPayments.month, taxesPayments.year, SUM(taxesPayments.paymentAmount)
FROM taxesPayments
JOIN sportGroups ON taxesPayments.group_id = sportGroups.id
JOIN coaches ON sportGroups.coach_id = coaches.id
WHERE coaches.egn = '7509041245'
GROUP BY taxesPayments.month, taxesPayments.year
HAVING SUM(taxesPayments.paymentAmount) > 700;

SELECT COUNT(students.id)
FROM students
JOIN student_sport ON students.id = student_sport.student_id
JOIN sportGroups ON student_sport.sportGroup_id = sportGroups.id
JOIN sports ON sportGroups.sport_id = sports.id
WHERE sports.name = 'Football';

SELECT coaches.name, sports.name
FROM coaches
LEFT JOIN sportGroups ON coaches.id = sportGroups.coach_id
LEFT JOIN sports ON sportGroups.sport_id = sports.id;

SELECT sports.name, sportGroups.location, COUNT(student_sport.student_id)
FROM sportGroups
JOIN sports ON sportGroups.sport_id = sports.id
JOIN student_sport ON sportGroups.id = student_sport.sportGroup_id
GROUP BY sportGroups.id, sports.name, sportGroups.location
HAVING COUNT(student_sport.student_id) > 2;