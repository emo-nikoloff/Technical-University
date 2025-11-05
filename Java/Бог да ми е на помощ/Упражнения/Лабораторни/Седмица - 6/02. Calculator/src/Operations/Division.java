package Operations;

public class Division extends Operation {
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("Не можеш да делиш на нула");
        }
        return firstNumber / secondNumber;
    }
}
