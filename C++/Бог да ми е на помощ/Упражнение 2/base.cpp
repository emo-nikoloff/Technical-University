#include <iostream>
using namespace std;

class Base
{
public:
    Base()
    {
        cout << "Base(): ";
        hello();
    }
    virtual void hello() { cout << "Base::hello" << endl; }
    void greet() { cout << "Base::greet" << endl; }
    virtual void show(int x) { cout << "Base::show(int) " << x << endl; }
    virtual ~Base()
    {
        cout << "~Base(): ";
        hello();
    }
};

class Derived : public Base
{
public:
    Derived()
    {
        cout << "Derived(): ";
        hello();
    }
    void hello() override { cout << "Derived::hello" << endl; }
    void greet() { cout << "Derived::greet" << endl; }
    void show(double x) { cout << "Derived::show(double) " << x << endl; }
    ~Derived() { cout << "~Derived()" << endl; }
};

int main()
{
    Base *p = new Derived;
    cout << "---" << endl;

    p->hello();
    p->greet();
    p->show(2.5);

    Base &r = *p;
    r.hello();

    Base b = *p;
    b.hello();

    cout << "---" << endl;
    delete p;
    cout << "---" << endl;

    return 0;
}
