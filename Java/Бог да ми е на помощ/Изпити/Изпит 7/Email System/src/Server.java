import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private final Object lock;

    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Double> words = new HashMap<>();

    public Server() {
        lock = new Object();
    }

    public void start() {
        try {
            server = new ServerSocket(8080);
            while (true) {
                Socket client = server.accept();

                Thread clientThread = new Thread(() -> {
                    Scanner sc = null;
                    PrintStream out = null;

                    try {
                        sc = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        userMenu(sc, out);
                    } catch (IOException error) {
                        error.printStackTrace();
                    } finally {
                        if (sc != null)
                            sc.close();
                        if (out != null)
                            out.close();
                    }
                });

                clientThread.start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private static void checkCredentials(String email, String password) throws InvalidUserException {
        if (!users.containsKey(email) || !users.get(email).equals(password)) {
            throw new InvalidUserException(password);
        }
    }

    private static boolean isSpam(Email email) {
        String[] emailContent = email.getContent().split("\\s+");

        double sum = 0;
        int count = 0;

        for (String string : emailContent) {
            if (words.containsKey(string)) {
                sum += words.get(string);
                count++;
            }
        }

        if (count == 0) {
            return false;
        }
        return (sum / count) > 0.8;
    }

    public static List<Email> filterEmails(String sender, String subject) {
        List<Email> allEmails = Email.loadFromFile(subject);
        return null;
    }

    private void userMenu(Scanner sc, PrintStream out) {

    }
}
