#include "StudentManager/StudentManager.h"

#include <iostream>
#include <string>
#include <array>
#include <sstream>
#include <stdexcept>
#include <exception>

using namespace std;

const string STUDENTS_FILE_PATH = "data/students.txt";

int readInt()
{
    string input;

    while (true)
    {
        getline(cin, input);

        stringstream inputStream(input);

        int value;
        char extra;

        if (inputStream >> value && !(inputStream >> extra))
        {
            return value;
        }

        cout << "Invalid input. Enter an integer: ";
    }
}

string readText()
{
    string value;

    while (true)
    {
        getline(cin, value);

        if (!value.empty() && value.find('|') == string::npos)
        {
            return value;
        }

        cout << "Input cannot be empty or contain '|'. Try again: ";
    }
}

array<int, StudentGrades::SUBJECTS_COUNT> readGrades()
{
    array<int, StudentGrades::SUBJECTS_COUNT> grades{};

    for (int i = 0; i < StudentGrades::SUBJECTS_COUNT; i++)
    {
        while (true)
        {
            cout << "Subject " << i + 1 << ": ";
            int grade = readInt();

            if (grade >= 2 && grade <= 6)
            {
                grades[i] = grade;
                break;
            }

            cout << "Grade must be between 2 and 6.\n";
        }
    }

    return grades;
}

StudentGrades readStudent()
{
    StudentGrades student;

    cout << "\n--- Enter student information ---\n";

    cout << "Name: ";
    student.setName(readText());

    cout << "Faculty: ";
    student.setFaculty(readText());

    cout << "Faculty number: ";
    student.setFacultyNumber(readText());

    int groupNumber = 0;
    while (groupNumber <= 0)
    {
        cout << "Group number: ";
        groupNumber = readInt();

        if (groupNumber <= 0)
        {
            cout << "Group number must be positive.\n";
        }
    }

    student.setGroupNumber(groupNumber);

    cout << "\nEnter grades for the first semester:\n";
    auto firstGrades = readGrades();

    cout << "\nEnter grades for the second semester:\n";
    auto secondGrades = readGrades();

    student.setFirstSemesterGrades(firstGrades);
    student.setSecondSemesterGrades(secondGrades);

    return student;
}

void printMenu()
{
    cout << "\n========== STUDENT MANAGEMENT ==========\n";
    cout << "1. Add student\n";
    cout << "2. Print all students\n";
    cout << "3. Print students by group\n";
    cout << "4. Print average grades for all groups\n";
    cout << "5. Print minimum and maximum average by group\n";
    cout << "0. Exit\n";
    cout << "========================================\n";
}

int main()
{
    StudentManager manager(STUDENTS_FILE_PATH);

    try
    {
        manager.loadFromFile();
    }
    catch (const exception &e)
    {
        cerr << "Error loading data: " << e.what() << '\n';
        return 1;
    }

    bool running = true;

    while (running)
    {
        printMenu();

        cout << "Choose an option: ";
        int choice = readInt();

        try
        {
            switch (choice)
            {
            case 1:
            {
                StudentGrades student = readStudent();

                manager.addStudent(student);
                manager.saveToFile();

                cout << "Student added successfully.\n";
                break;
            }

            case 2:
            {
                manager.printAllStudents();
                break;
            }

            case 3:
            {
                cout << "Enter group number: ";
                int group = readInt();

                if (group <= 0)
                {
                    cout << "Invalid group number.\n";
                    break;
                }

                manager.printStudentsByGroup(group);
                break;
            }

            case 4:
            {
                manager.printGroupAverages();
                break;
            }

            case 5:
            {
                cout << "Enter group number: ";
                int group = readInt();

                if (group <= 0)
                {
                    cout << "Invalid group number.\n";
                    break;
                }

                manager.printMinMaxAverageByGroup(group);
                break;
            }

            case 0:
            {
                running = false;
                cout << "Goodbye!\n";
                break;
            }

            default:
            {
                cout << "Invalid menu option.\n";
                break;
            }
            }
        }
        catch (const exception &e)
        {
            cerr << "Error: " << e.what() << '\n';
        }
    }

    return 0;
}
