#include <iostream>
#include <string>

using namespace std;

class Vehicle
{
protected:
    string brand;
    int year;
    double fuelConsumption;

public:
    Vehicle(string brand, int year, double fuelConsumption)
        : brand(brand), year(year), fuelConsumption(fuelConsumption)
    {
    }

    virtual double consumption() const
    {
        return fuelConsumption;
    }

    double tripCost(double km, double fuelPrice) const
    {
        return consumption() * km / 100.0 * fuelPrice;
    }

    virtual void print() const
    {
        cout << "Brand: " << brand << endl
             << "Year: " << year << endl
             << "Fuel Consumption: " << fuelConsumption << " l/km" << endl;
    }
};

class Car : public Vehicle
{
private:
    int seats;

public:
    Car(string brand, int year, double fuelConsumption, int seats)
        : Vehicle(brand, year, fuelConsumption),
          seats(seats)
    {
    }

    void print() const override
    {
        cout << "Brand: " << brand << endl
             << "Year: " << year << endl
             << "Seats: " << seats << endl
             << "Fuel Consumption: " << fuelConsumption << " l/km" << endl;
    }
};

class Truck : public Vehicle
{
private:
    double maxLoad;
    double currentLoad;

public:
    Truck(string brand, int year, double fuelConsumption, double maxLoad, double currentLoad)
        : Vehicle(brand, year, fuelConsumption),
          maxLoad(maxLoad), currentLoad(currentLoad)
    {
    }

    void load(double tons)
    {
        if (currentLoad + tons > maxLoad)
        {
            cout << "The load is too much. Try with smaller load." << endl;
        }

        currentLoad += tons;
    }

    void print() const override
    {
        cout << "Brand: " << brand << endl
             << "Year: " << year << endl
             << "Max Load: " << maxLoad << "tons" << endl
             << "Current Load: " << maxLoad << "tons" << endl
             << "Fuel Consumption: " << fuelConsumption << " l/km" << endl;
    }
};

int main()
{
    Car car("Skoda", 2019, 6.5, 5);
    Truck truck("MAN", 2015, 25, 20, 13);
    truck.load(8);

    Vehicle *vehicles[2] = {&car, &truck};
    for (int i = 0; i < 2; i++)
    {
        vehicles[i]->print();
        cout << "Price for 300 km: " << vehicles[i]->tripCost(300, 2.60) << " leva." << endl;
    }
}
