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
SELECT st.name AS student_name, st.class, sg.location, c.name AS coach_name
FROM students st JOIN student_sport ss ON st.id = ss.student_id
JOIN sportGroups sg ON ss.sportGroup_id = sg.id
JOIN coaches c ON sg.coach_id = c.id
WHERE sg.hourOfTraining = '08:00:00';

SELECT sp.name AS sport_name, COUNT(ss.student_id) AS students_count
FROM sports sp JOIN sportGroups sg ON sp.id = sg.sport_id
JOIN student_sport ss ON sg.id = ss.sportGroup_id
GROUP BY sp.name;