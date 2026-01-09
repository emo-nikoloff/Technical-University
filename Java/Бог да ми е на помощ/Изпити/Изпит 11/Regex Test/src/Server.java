import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Server {
    private static final String REGEXES_FILENAME = "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Изпити\\Изпит 11\\Regex Test\\src\\regexes.bin";
    private ServerSocket server;
    private static Object lock;

    public Server() {
        lock = new Object();
    }

    public void start() {
        try {
            System.out.println("Server started.");
            server = new ServerSocket(8080);

            while (true) {
                Socket client = server.accept();
                Thread clieThread = new Thread(() -> {
                    System.out.println("Client accepted.");
                    Scanner sc = null;
                    PrintStream out = null;

                    try {
                        sc = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        userMenu(sc, out);
                    } catch (IOException error) {
                        error.printStackTrace();
                    } finally {
                        sc.close();
                        out.close();
                    }
                });

                clieThread.start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    private List<Regex> read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(REGEXES_FILENAME))) {
            return (List<Regex>) in.readObject();
        } catch (IOException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        return null;
    }

    private void write(List<Regex> list) {
        List<Regex> fileData = read();
        for (Regex regex1 : list) {
            for (Regex regex2 : fileData) {
                if (!regex1.getPattern().equals(regex2.getPattern())) {
                    fileData.add(regex1);
                }
            }
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REGEXES_FILENAME))) {
            out.writeObject(fileData);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    private void userMenu(Scanner sc, PrintStream out) {
        while (true) {
            out.println("Choose between creating(1) or searching for a regex(2): ");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    out.println("Enter a pattern the regex");
                    String pattern = sc.nextLine();

                    out.println("Enter a description for the regex");
                    String description = sc.nextLine();

                    Regex regex = new Regex(pattern, description);

                    out.println("Enter count of texts for testing");
                    int countRegexes = sc.nextInt();

                    String[] regexTest = new String[countRegexes];
                    for (int i = 0; i < countRegexes; i++) {
                        out.println("Enter a regex for testing: ");
                        String text = sc.nextLine();
                        regexTest[i] = text;
                    }
                    List<Boolean> results = RegexTester.test(regex, regexTest);
                    for (Boolean result : results) {
                        out.println(result);
                    }
                    out.println("Do you want to add the regex to the file? Y/N: ");
                    String answer = sc.nextLine();
                    if (answer.toUpperCase().equals("Y")) {
                        List<Regex> listRegex = new ArrayList<>();
                        listRegex.add(regex);
                        write(listRegex);
                    }
                    break;
                case "2":
                    out.println("enter key word: ");
                    String keyWord = sc.nextLine();
                    List<Regex> fileData = read();
                    // return fileData.stream()
                    // .filter(r -> r.getDescription().contains(keyWord))
                    // .sorted(Comparator.comparingInt((Regex r) -> r.getRating()).reversed())
                    // .collect(Collectors.toList());
                    break;
                default:
                    out.println("Wront input!");
                    break;
            }
        }
    }
}
