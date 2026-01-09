public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new WrongPhoneNumberException("wrong number");
        }
        return true;
    }

}
