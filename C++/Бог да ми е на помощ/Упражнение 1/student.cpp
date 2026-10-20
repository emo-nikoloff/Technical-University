#include <iostream>
#include <string>

using namespace std;

class Student
{
private:
    string name;
    int age;
    float averageGrade;

public:
    Student(string name, int age, float averageGrade)
    {
        this->name = name;
        this->age = age;
        this->averageGrade = averageGrade;
    }

    float getAverageGrade()
    {
        return averageGrade;
    }

    void print()
    {
        cout << "Student: " << name << "is " << age << "years old and his average grade is: " << averageGrade;
    }
};

int main()
{
    Student firstStudent("Emiliyan", 21, 5.99);
    Student secondStudent("Rozhda", 21, 5.99);

    if (firstStudent.getAverageGrade() > secondStudent.getAverageGrade())
    {
        firstStudent.print();
    }
    else if (firstStudent.getAverageGrade() < secondStudent.getAverageGrade())
    {
        secondStudent.print();
    }
    else
    {
        cout << "Both students have the same grade.";
    }

    return 0;
}
