#include "Student.h"

#include <stdexcept>

string Student::getName() const
{
    return name;
}

void Student::setName(const string &name)
{
    this->name = name;
}

string Student::getFaculty() const
{
    return faculty;
}

void Student::setFaculty(const string &faculty)
{
    this->faculty = faculty;
}

string Student::getFacultyNumber() const
{
    return facultyNumber;
}

void Student::setFacultyNumber(const string &facultyNumber)
{
    this->facultyNumber = facultyNumber;
}

int Student::getGroupNumber() const
{
    return groupNumber;
}

void Student::setGroupNumber(int groupNumber)
{
    if (groupNumber <= 0)
    {
        throw invalid_argument("Group number must be positive.");
    }

    this->groupNumber = groupNumber;
}
