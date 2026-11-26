#include <iostream>
#include <string>

using namespace std;

class Sensor
{
private:
    string id;

protected:
    int rawValue;

public:
    Sensor(string id)
        : id(id), rawValue(0)
    {
    }

    void setRaw(int raw)
    {
        rawValue = raw;
    }

    virtual double value() const = 0;

    virtual string unit() const = 0;

    virtual bool isAlarm() const = 0;

    virtual ~Sensor() = default;

    friend ostream &operator<<(ostream &os, const Sensor &sensor)
    {
        os << sensor.id << ": "
           << sensor.value() << " "
           << sensor.unit();

        if (sensor.isAlarm())
        {
            os << " [ALARM]";
        }

        return os;
    }
};

class TemperatureSensor : public Sensor
{
private:
    double alarmThreshold;

public:
    TemperatureSensor(string id, double threshold)
        : Sensor(id),
          alarmThreshold(threshold)
    {
    }

    double value() const override
    {
        return -40.0 + rawValue * 165.0 / 1024.0;
    }

    string unit() const override
    {
        return "Celsius";
    }

    bool isAlarm() const override
    {
        return value() > alarmThreshold;
    }
};

class HumiditySensor : public Sensor
{
public:
    HumiditySensor(string id)
        : Sensor(id)
    {
    }

    double value() const override
    {
        return rawValue * 100.0 / 1024.0;
    }

    string unit() const override
    {
        return "%";
    }

    bool isAlarm() const override
    {
        return value() < 20.0 || value() > 80.0;
    }
};

class DistanceSensor : public Sensor
{
public:
    DistanceSensor(string id)
        : Sensor(id)
    {
    }

    double value() const override
    {
        return rawValue / 58.0;
    }

    string unit() const override
    {
        return "cm";
    }

    bool isAlarm() const override
    {
        return value() < 10.0;
    }
};

int main()
{
    TemperatureSensor temperature("T1", 40.0);
    HumiditySensor humidity("H1");
    DistanceSensor distance("D1");

    temperature.setRaw(512);
    humidity.setRaw(768);
    distance.setRaw(1160);

    Sensor *sensors[] = {
        &temperature,
        &humidity,
        &distance};

    int alarmCount = 0;
    for (Sensor *sensor : sensors)
    {
        cout << *sensor << endl;

        if (sensor->isAlarm())
        {
            alarmCount++;
        }
    }
    cout << "Sensors with alarms: " << alarmCount << endl;

    return 0;
}
