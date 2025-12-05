/*Създайте интерфейс Logger с имплементации ConsoleLogger и FileLogger. Създайте клас Application, който приема Logger като зависимост през конструктора и има метод logInfo().
Обяснение:
1. Интерфейс Logger - Създаваме интерфейс Logger, който има метод log(String message). Това дава възможност за разнообразни видове логиране.
2. Имплементации ConsoleLogger и FileLogger - Създаваме два класа, които имплементират Logger: ConsoleLogger, който извежда съобщението в конзолата, и FileLogger, който записва съобщението във
файл (или симулира тази операция).
3. DI в Application - Класът Application получава обект Logger чрез конструктора си. Това прави класа независим от конкретния вид логване и му позволява да работи с всеки обект, който
имплементира Logger.*/

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
