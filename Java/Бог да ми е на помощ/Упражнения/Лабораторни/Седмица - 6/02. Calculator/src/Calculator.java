import Operations.Operation;

public class Calculator {
    public double performCalculation(Operation operation, double firstNumber, double secondNumber) {
        return operation.calculate(firstNumber, secondNumber);
    }
}
