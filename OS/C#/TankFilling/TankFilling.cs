/* Един резервоар в капацитет 2000 л за вода се пълни от две тръби и се източва от една тръба. Първата тръба влива 20 л за 10 секунди.
Втората тръба влива 30 л за 20 секунди. Третата тръба източва по 40 л за 15 секунди. Резервоарът не трябва да прелива,
ако тръбите не могат да влеят допълнително вода, то те спират дейността си за 30 секунди. Резервоарът не може да се източи повече от наличния си обем,
ако тръбата, която го източва, не може да излее нужното количество вода, то тя спира за 30 секунди. Направете програма с нишки,
които да симулират работата на тръбите. */

namespace TankFilling;

class Program
{
    static readonly int maxTankCapacity = 2000;
    static int currentTankCapacity = 0;
    static Mutex poolMutex = null!;

    static void Main(string[] args)
    {
        poolMutex = new();

        Thread thread1 = new(() =>
            ThreadFunction(20, 10_000));

        Thread thread2 = new(() =>
            ThreadFunction(30, 20_000));

        Thread thread3 = new(() =>
            ThreadFunction(-40, 15_000));

        thread1.Start();
        thread2.Start();
        thread3.Start();

        while (true)
        {
            if (poolMutex.WaitOne())
            {
                Console.WriteLine($"[{DateTime.Now:HH:mm:ss}] Tank Capacity: {currentTankCapacity}/{maxTankCapacity}");
                poolMutex.ReleaseMutex();
            }

            Thread.Sleep(1000);
        }
    }

    static void ThreadFunction(int updateVolume, int sleepTimeMilliseconds)
    {
        while (true)
        {
            // Time needed to complete an operation
            Thread.Sleep(sleepTimeMilliseconds);

            bool operationFailed = false;
            if (poolMutex.WaitOne())
            {
                int newCapacity = currentTankCapacity + updateVolume;

                if (newCapacity > maxTankCapacity || newCapacity < 0)
                {
                    operationFailed = true;
                }
                else
                {
                    currentTankCapacity = newCapacity;

                    Console.WriteLine(
                        $"[{DateTime.Now:HH:mm:ss}] " +
                        $"Operation: {updateVolume:+#;-#;0} L | " +
                        $"Tank: {currentTankCapacity}/{maxTankCapacity} L");
                }

                poolMutex.ReleaseMutex();
            }

            if (operationFailed)
            {
                Console.WriteLine(
                    $"[{DateTime.Now:HH:mm:ss}] " +
                    $"Operation impossible. Thread sleeping for 30 seconds.");

                Thread.Sleep(30_000);
            }
        }
    }
}
