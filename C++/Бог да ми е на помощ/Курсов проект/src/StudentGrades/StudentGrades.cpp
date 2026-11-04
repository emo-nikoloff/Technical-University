#include "StudentGrades.h"

#include <stdexcept>

const array<int, StudentGrades::SUBJECTS_COUNT> &StudentGrades::getFirstSemesterGrades() const
{
    return firstSemesterGrades;
}

void StudentGrades::setFirstSemesterGrades(const array<int, StudentGrades::SUBJECTS_COUNT> &grades)
{
    for (int grade : grades)
    {
        if (grade < 2 || grade > 6)
        {
            throw invalid_argument("Grades must be between 2 and 6.");
        }
    }

    firstSemesterGrades = grades;
}

const array<int, StudentGrades::SUBJECTS_COUNT> &StudentGrades::getSecondSemesterGrades() const
{
    return secondSemesterGrades;
}

void StudentGrades::setSecondSemesterGrades(const array<int, StudentGrades::SUBJECTS_COUNT> &grades)
{
    for (int grade : grades)
    {
        if (grade < 2 || grade > 6)
        {
            throw invalid_argument("Grades must be between 2 and 6.");
        }
    }

    secondSemesterGrades = grades;
}

double StudentGrades::getAverage() const
{
    int sum = 0;

    for (int grade : firstSemesterGrades)
    {
        sum += grade;
    }

    for (int grade : secondSemesterGrades)
    {
        sum += grade;
    }

    return static_cast<double>(sum) / (2 * SUBJECTS_COUNT);
}

ostream &operator<<(ostream &out, const StudentGrades &student)
{
    out << "Name: " << student.getName() << '\n';
    out << "Faculty: " << student.getFaculty() << '\n';
    out << "Faculty number: " << student.getFacultyNumber() << '\n';
    out << "Group: " << student.getGroupNumber() << '\n';

    out << "First semester grades: ";
    for (int grade : student.firstSemesterGrades)
    {
        out << grade << ' ';
    }

    out << "\nSecond semester grades: ";
    for (int grade : student.secondSemesterGrades)
    {
        out << grade << ' ';
    }

    out << "\nAverage: " << student.getAverage() << '\n';

    return out;
}