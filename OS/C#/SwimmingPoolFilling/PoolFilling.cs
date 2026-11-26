/* Три нишки обслужват басейн. Първата нишка на всеки 30 милисек. влива 10 л, втората на всеки 70 милисек. излива 50 литра, 
третата излива 300 литра всяка секунда. Капацитетът на басейна е 5000 литра. Когато басейнът е празен или пълен 
съотвенитните нишки заспиват за 10 секунди. Пълнененето и изпразването става в критична секция. */

namespace SwimmingPoolFilling;

class Program
{
    static public int maxPoolCapacity = 5000;
    static public int currentPoolCapacity = 0;
    static public Mutex poolMutex = null!;

    static void Main(string[] args)
    {
        poolMutex = new();
        int timeRunning = 0;

        Thread thread1 = new(() =>
            ThreadFunction(10, 30));

        Thread thread2 = new(() =>
            ThreadFunction(-50, 70));

        Thread thread3 = new(() =>
            ThreadFunction(-300, 1000));

        thread1.Start();
        thread2.Start();
        thread3.Start();

        while (true)
        {
            if (poolMutex.WaitOne())
            {
                Console.WriteLine($"Time {timeRunning} -> Pool Capacity {currentPoolCapacity}");
                poolMutex.ReleaseMutex();
            }

            timeRunning++;
            Thread.Sleep(1000);
        }
    }

    static void ThreadFunction(int updateVolume, int sleepTimeMilliseconds)
    {
        bool sleepFlag = false;
        while (true)
        {
            if (poolMutex.WaitOne())
            {
                if ((currentPoolCapacity + updateVolume > maxPoolCapacity) ||
                    (currentPoolCapacity + updateVolume < 0))
                {
                    sleepFlag = true;
                }
                else
                {
                    currentPoolCapacity += updateVolume;
                }

                poolMutex.ReleaseMutex();
            }

            if (sleepFlag)
            {
                Thread.Sleep(10_000); // 10 seconds
                sleepFlag = false;
            }
            else
            {
                Thread.Sleep(sleepTimeMilliseconds);
            }
        }
    }
}
