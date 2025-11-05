package Operations;

public class Calculator {
    public double performAction(Operation operation, double firstNumber, double secondNumber) {
        return operation.calculate(firstNumber, secondNumber);
    }
}
