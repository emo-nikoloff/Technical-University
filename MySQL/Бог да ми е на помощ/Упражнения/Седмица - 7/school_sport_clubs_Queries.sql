USE school_sport_clubs;

SELECT s1.name AS student1, s2.name AS student2, sg.id AS group_id
FROM student_sport ss1
JOIN student_sport ss2 ON ss1.sportGroup_id = ss2.sportGroup_id AND ss1.student_id < ss2.student_id
JOIN students s1 ON ss1.student_id = s1.id
JOIN students s2 ON ss2.student_id = s2.id
JOIN sportGroups sg ON ss1.sportGroup_id = sg.id
JOIN sports sp ON sg.sport_id = sp.id
WHERE sp.name = 'Football';

CREATE VIEW morning_trainings AS
SELECT students.name AS student_name, students.class, sportGroups.location, coaches.name AS coach_name
FROM students 
JOIN student_sport ON students.id = student_sport.student_id
JOIN sportGroups ON student_sport.sportGroup_id = sportGroups.id
JOIN coaches ON sportGroups.coach_id = coaches.id
WHERE sportGroups.hourOfTraining = '08:00:00';

SELECT sports.name, COUNT(student_sport.student_id)
FROM sports 
JOIN sportGroups ON sports.id = sportGroups.sport_id
JOIN student_sport ON sportGroups.id = student_sport.sportGroup_id
GROUP BY sports.name;