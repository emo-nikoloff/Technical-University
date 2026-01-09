public class User {
    private String username;
    private String password;

    public User(String username, String password) throws UserException {
        if (!username.matches("[a-zA-Z0-9]{6,}") && !password.matches("\\w{6,}")) {
            throw new UserException("Invalid login details!");
        }
        this.username = username;
        this.password = password;
    }
}
