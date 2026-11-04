#include "StudentManager.h"

#include <fstream>
#include <iostream>
#include <iomanip>
#include <sstream>
#include <stdexcept>
#include <map>
#include <utility>

StudentManager::StudentManager(const string &filePath)
    : filePath(filePath)
{
}

void StudentManager::addStudent(const StudentGrades &student)
{
    students.push_back(student);
}

void StudentManager::loadFromFile()
{
    students.clear();

    ifstream file(filePath);

    // If the file does not exist, start with an empty collection.
    if (!file.is_open())
    {
        return;
    }

    string line;

    while (getline(file, line))
    {
        if (line.empty())
        {
            continue;
        }

        stringstream studentDataStream(line);

        string studentName;
        string studentFaculty;
        string studentFacultyNumber;
        string studentGroupNumberText;
        string firstSemesterText;
        string secondSemesterText;

        if (!getline(studentDataStream, studentName, '|') ||
            !getline(studentDataStream, studentFaculty, '|') ||
            !getline(studentDataStream, studentFacultyNumber, '|') ||
            !getline(studentDataStream, studentGroupNumberText, '|') ||
            !getline(studentDataStream, firstSemesterText, '|') ||
            !getline(studentDataStream, secondSemesterText, '|'))
        {
            throw runtime_error("Invalid student data in file.");
        }

        StudentGrades student;

        student.setName(studentName);
        student.setFaculty(studentFaculty);
        student.setFacultyNumber(studentFacultyNumber);
        student.setGroupNumber(stoi(studentGroupNumberText));

        array<int, StudentGrades::SUBJECTS_COUNT> firstSemesterGrades{};
        array<int, StudentGrades::SUBJECTS_COUNT> secondSemesterGrades{};

        // First semester
        stringstream firstSemesterStream(firstSemesterText);

        for (int i = 0; i < StudentGrades::SUBJECTS_COUNT; i++)
        {
            string gradeText;

            if (!getline(firstSemesterStream, gradeText, ','))
            {
                throw runtime_error("Missing grade.");
            }

            firstSemesterGrades[i] = stoi(gradeText);
        }

        // Second semester
        stringstream secondSemesterStream(secondSemesterText);

        for (int i = 0; i < StudentGrades::SUBJECTS_COUNT; i++)
        {
            string gradeText;

            if (!getline(secondSemesterStream, gradeText, ','))
            {
                throw runtime_error("Missing grade.");
            }

            secondSemesterGrades[i] = stoi(gradeText);
        }

        student.setFirstSemesterGrades(firstSemesterGrades);
        student.setSecondSemesterGrades(secondSemesterGrades);

        students.push_back(student);
    }

    if (file.bad())
    {
        throw runtime_error("Error while reading student file.");
    }
}

void StudentManager::saveToFile() const
{
    ofstream file(filePath);

    if (!file.is_open())
    {
        throw runtime_error("Cannot open file for writing.");
    }

    for (const StudentGrades &student : students)
    {
        file << student.getName() << '|'
             << student.getFaculty() << '|'
             << student.getFacultyNumber() << '|'
             << student.getGroupNumber() << '|';

        // First semester
        for (int i = 0; i < StudentGrades::SUBJECTS_COUNT; i++)
        {
            if (i > 0)
            {
                file << ',';
            }

            file << student.getFirstSemesterGrades()[i];
        }

        file << '|';

        // Second semester
        for (int i = 0; i < StudentGrades::SUBJECTS_COUNT; i++)
        {
            if (i > 0)
            {
                file << ',';
            }

            file << student.getSecondSemesterGrades()[i];
        }

        file << '|';
        file << '\n';
    }

    if (!file)
    {
        throw runtime_error("Error while saving student data.");
    }
}

void StudentManager::printAllStudents() const
{
    if (students.empty())
    {
        cout << "No students available.\n";
        return;
    }

    for (const StudentGrades &student : students)
    {
        cout << "\n-------------------------\n";
        cout << student;
    }
}

void StudentManager::printStudentsByGroup(int groupNumber) const
{
    bool found = false;

    for (const StudentGrades &student : students)
    {
        if (student.getGroupNumber() != groupNumber)
        {
            continue;
        }

        cout << "\n-------------------------\n";
        cout << student;

        found = true;
    }

    if (!found)
    {
        cout << "No students found in this group.\n";
    }
}

void StudentManager::printGroupAverages() const
{
    map<int, pair<double, int>> groupData;

    for (const StudentGrades &student : students)
    {
        int group = student.getGroupNumber();

        groupData[group].first += student.getAverage();
        groupData[group].second++;
    }

    if (groupData.empty())
    {
        cout << "No students available.\n";
        return;
    }

    cout << fixed << setprecision(2);
    cout << "\nAverage grades for all groups:\n";

    for (const auto &entry : groupData)
    {
        int group = entry.first;
        double total = entry.second.first;
        int count = entry.second.second;

        double average = total / count;

        cout << "Group " << group << ": " << average << '\n';
    }
}

void StudentManager::printMinMaxAverageByGroup(int groupNumber) const
{
    double minAverage = 0;
    double maxAverage = 0;

    bool found = false;

    for (const StudentGrades &student : students)
    {
        if (student.getGroupNumber() != groupNumber)
        {
            continue;
        }

        double average = student.getAverage();

        if (!found)
        {
            minAverage = average;
            maxAverage = average;

            found = true;

            continue;
        }

        if (average < minAverage)
        {
            minAverage = average;
        }
        else if (average > maxAverage)
        {
            maxAverage = average;
        }
    }

    if (!found)
    {
        cout << "No students found in this group.\n";
        return;
    }

    cout << fixed << setprecision(2);

    cout << "\nGroup: " << groupNumber << '\n';
    cout << "Minimum average: " << minAverage << '\n';
    cout << "Maximum average: " << maxAverage << '\n';
}
