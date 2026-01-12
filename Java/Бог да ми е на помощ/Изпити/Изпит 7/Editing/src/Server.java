import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private final Map<String, Object> repositoriesLock;

    public Server() {
        repositoriesLock = new HashMap<>();
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

    private Repository loadRepository(String name) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name + ".repo"))) {
            return (Repository) in.readObject();
        } catch (IOException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }

        return null;
    }

    private void userMenu(Scanner sc, PrintStream out) {
        while (true) {
            out.println("Enter repository name: ");
            String repositoryName = sc.nextLine();

            repositoriesLock.putIfAbsent(repositoryName, new Object());

            synchronized (repositoriesLock.get(repositoryName)) {
                Repository repository = loadRepository(repositoryName);

                out.println("Enter your name: ");
                String name = sc.nextLine();

                if (!repository.getEditors().contains(name)) {
                    out.println("You don't have access to this repository!");
                    out.println("Choose another repository.");
                    continue;
                }

                out.println("Choose between 3 options:");
                out.println("Options 1 - edit the file and create a new commit");
                out.println("Options 2 - remove the last commit");
                out.println("Options 3 - save the changes");
                out.println("Your option is: ");
                String option = sc.nextLine();

                switch (option) {
                    case "1":
                        out.println("Enter the file you want to edit: ");
                        String fileName = sc.nextLine();

                        Editor editor = new Editor();
                        editor.read(repositoryName + "/" + fileName);

                        out.println("Choose between 3 options for editing:");
                        out.println("Options 1 - insert");
                        out.println("Options 2 - delete");
                        out.println("Options 3 - new commit");
                        out.println("Your option is: ");

                        String editingOption = sc.nextLine();
                        switch (editingOption) {
                            case "1":
                                out.println("Enter starting position: ");
                                int startPosition = sc.nextInt();
                                out.println("Enter text: ");
                                String text = sc.nextLine();
                                editor.insert(startPosition, text);
                                break;
                            case "2":
                                out.println("Enter starting position: ");
                                int start = sc.nextInt();
                                out.println("Enter ending position: ");
                                int end = sc.nextInt();
                                editor.delete(start, end);
                                break;
                            case "3":
                                Commit commit = new Commit(new Random().nextInt(),
                                        "message",
                                        fileName,
                                        editor.getContent());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    default:
                        break;
                }
            }
        }
    }
}
