#pragma once

#include "../Student/Student.h"

#include <array>
#include <iostream>

using namespace std;

class StudentGrades : public Student
{
public:
    static constexpr int SUBJECTS_COUNT = 5;

private:
    array<int, SUBJECTS_COUNT> firstSemesterGrades{};
    array<int, SUBJECTS_COUNT> secondSemesterGrades{};

public:
    StudentGrades() = default;

    const array<int, SUBJECTS_COUNT> &getFirstSemesterGrades() const;
    void setFirstSemesterGrades(const array<int, SUBJECTS_COUNT> &grades);

    const array<int, SUBJECTS_COUNT> &getSecondSemesterGrades() const;
    void setSecondSemesterGrades(const array<int, SUBJECTS_COUNT> &grades);

    double getAverage() const;

    friend ostream &operator<<(ostream &out, const StudentGrades &student);
};