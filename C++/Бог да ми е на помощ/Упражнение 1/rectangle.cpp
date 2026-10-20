#include <iostream>

using namespace std;

class Rectangle
{
private:
    double width;
    double height;

public:
    Rectangle(double width, double height)
    {
        this->width = width;
        this->height = height;
    }

    double area()
    {
        return width * height;
    }

    double perimeter()
    {
        return 2 * width + 2 * height;
    }
};

int main()
{
    Rectangle rectangle(3, 4);

    cout << "Area: " << rectangle.area();
    cout << "Perimeter: " << rectangle.perimeter();

    return 0;
}
