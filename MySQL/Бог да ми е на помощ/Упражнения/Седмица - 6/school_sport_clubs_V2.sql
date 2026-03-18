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

SELECT coaches.name, sports.name, students.name
FROM students
JOIN student_sport ON students.id = student_sport.student_id
JOIN sportGroups ON student_sport.sportGroup_id = sportGroups.id
JOIN coaches ON sportGroups.coach_id = coaches.id
JOIN sports ON sportGroups.sport_id = sports.id
WHERE students.name = 'Iliyan Ivanov';

SELECT students.name, students.class, sportGroups.location, coaches.name
FROM students
JOIN student_sport ON students.id = student_sport.student_id
JOIN sportGroups ON student_sport.sportGroup_id = sportGroups.id
JOIN coaches ON sportGroups.coach_id = coaches.id
WHERE sportGroups.hourOfTraining = '8:00:00';