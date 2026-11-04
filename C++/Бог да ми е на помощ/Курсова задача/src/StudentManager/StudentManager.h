#pragma once

#include "../StudentGrades/StudentGrades.h"

#include <vector>
#include <string>

using namespace std;

class StudentManager
{
private:
    vector<StudentGrades> students;
    string filePath;

public:
    explicit StudentManager(const string &filePath);

    void addStudent(const StudentGrades &student);

    void loadFromFile();
    void saveToFile() const;

    void printAllStudents() const;
    void printStudentsByGroup(int groupNumber) const;

    void printGroupAverages() const;
    void printMinMaxAverageByGroup(int groupNumber) const;
};
