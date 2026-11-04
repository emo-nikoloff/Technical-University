#pragma once

#include <string>

using namespace std;

class Student
{
private:
    string name = "";
    string faculty = "";
    string facultyNumber = "";
    int groupNumber = 0;

public:
    Student() = default;

    string getName() const;
    void setName(const string &name);

    string getFaculty() const;
    void setFaculty(const string &faculty);

    string getFacultyNumber() const;
    void setFacultyNumber(const string &facultyNumber);

    int getGroupNumber() const;
    void setGroupNumber(int groupNumber);
};
