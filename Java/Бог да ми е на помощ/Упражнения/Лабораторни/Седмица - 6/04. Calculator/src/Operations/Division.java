package Operations;

public class Division extends Operation {
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Не може да се дели на нула!");
        }
        return firstNumber / secondNumber;
    }
}
