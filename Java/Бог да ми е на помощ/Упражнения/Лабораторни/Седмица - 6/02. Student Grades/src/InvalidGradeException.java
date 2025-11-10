public class InvalidGradeException extends Exception {
    private String customMessage;

    public InvalidGradeException() {
        this.customMessage = null;
    }

    public InvalidGradeException(String message) {
        super(message);
        this.customMessage = message;
    }

    @Override
    public String getMessage() {
        if (customMessage != null) {
            return "Грешка: " + customMessage + "!";
        }
        return "Грешка: Оценката трябва да е в диапазона 2-6";
    }

}
