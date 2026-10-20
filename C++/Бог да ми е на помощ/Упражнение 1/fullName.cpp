#include <iostream>

using namespace std;

int main()
{
    cout << "First name: ";
    string firstName;
    cin >> firstName;

    cout << "Family name: ";
    string familyName;
    cin >> familyName;

    string fullName = firstName + " " + familyName;
    cout << fullName;

    return 0;
}
