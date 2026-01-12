import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Server {
    private static final String REGEXES_FILENAME = "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Изпити\\Изпит 5\\Regex Test\\src\\regexes.bin";
    private final Object lock;
    private ServerSocket server;

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
                        if (sc != null) {
                            sc.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                    }
                });

                clientThread.start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Regex> readFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(REGEXES_FILENAME))) {
            return (List<Regex>) in.readObject();
        } catch (IOException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }
        return null;
    }

    public void saveFile(List<Regex> regexes) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REGEXES_FILENAME))) {
            out.writeObject(regexes);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private void userMenu(Scanner sc, PrintStream out) {
        while (true) {
            out.print("Choose between creating(1) a regex or searching(2) for a one or (exit): ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    out.print("Creating a regex: ");
                    out.print("Enter a pattern: ");
                    String pattern = sc.nextLine();
                    out.print("Enter a description: ");
                    String description = sc.nextLine();

                    Regex regex = new Regex(pattern, description);

                    List<String> stringsList = new ArrayList<>();
                    out.println("Enter strings to test:");
                    String command;
                    while (!(command = sc.nextLine()).equals("end")) {
                        stringsList.add(command + "\n");
                    }
                    String[] strings = stringsList.toArray(new String[stringsList.size()]);

                    List<Boolean> results = RegexTester.test(regex, strings);
                    for (int i = 0; i < results.size(); i++) {
                        String string = strings[i];
                        boolean tested = results.get(i);
                        out.printf("%s - %b%n", string, tested);
                    }

                    out.print("Do you want to add your regex to the file? Y/N:");
                    option = sc.nextLine();

                    if (option.equalsIgnoreCase("Y")) {
                        synchronized (lock) {
                            List<Regex> regexes = readFile();
                            boolean exists = regexes.stream()
                                    .anyMatch(r -> r.getPattern().equals(pattern));
                            if (!exists) {
                                regexes.add(regex);
                                saveFile(regexes);
                                out.println("Regex added successfully!");
                            }
                        }
                    }
                    break;
                case "2":
                    out.print("Searching for a regex: ");
                    out.print("Enter a keyword to filter the regexes: ");
                    String keyWord = sc.nextLine();

                    List<Regex> filteredRegexes;
                    synchronized (lock) {
                        filteredRegexes = readFile().stream()
                                .filter(r -> r.getDescription().contains(keyWord))
                                .sorted((r1, r2) -> Integer.compare(r2.getRating(), r1.getRating()))
                                .collect(Collectors.toList());
                    }

                    out.println("Filtered regexes by description and rating:");
                    for (Regex r : filteredRegexes) {
                        out.print(r);
                    }

                    if (!filteredRegexes.isEmpty()) {
                        out.print("Enter regex's id: ");
                        int regexId = Integer.parseInt(sc.nextLine());

                        Regex selectedRegex;
                        synchronized (lock) {
                            selectedRegex = filteredRegexes.stream()
                                    .filter(r -> r.getId() == regexId)
                                    .findFirst().orElse(null);
                        }

                        if (selectedRegex != null) {
                            List<String> list = new ArrayList<>();
                            out.println("Enter strings to test:");
                            String input;
                            while (!(input = sc.nextLine()).equals("end")) {
                                list.add(input + "\n");
                            }
                            String[] stringsArray = list.toArray(new String[list.size()]);

                            List<Boolean> resultsList = RegexTester.test(selectedRegex, stringsArray);
                            for (int i = 0; i < resultsList.size(); i++) {
                                String string = stringsArray[i];
                                boolean tested = resultsList.get(i);
                                out.printf("%s - %b%n", string, tested);
                            }

                            out.print("Change the rating by '+1' or '-1': ");
                            int ratingChange = sc.nextInt();

                            synchronized (lock) {
                                List<Regex> allRegexes = readFile();
                                for (Regex r : allRegexes) {
                                    if (r.getId() == selectedRegex.getId()) {
                                        r.setRating(r.getRating() + ratingChange);
                                        break;
                                    }
                                }
                                saveFile(allRegexes);
                                out.println("Rating updated successfully!");
                            }
                        }
                    }
                    break;
                case "exit":
                    return;
            }
        }
    }
}
