/* Напишете програма, която въвежда име на ученик, възраст и среден успех. */
#include <iostream>

using namespace std;

int main()
{
    cout << "Student name: ";
    string studentName;
    cin >> studentName;

    cout << "Student age: ";
    int studentAge;
    cin >> studentAge;

    cout << "Student average grade: ";
    float averageGrade;
    cin >> averageGrade;

    cout << "Student: " << studentName << endl;
    cout << "Age: " << studentAge << endl;
    cout << "Average grade: " << averageGrade << endl;

    return 0;
}
