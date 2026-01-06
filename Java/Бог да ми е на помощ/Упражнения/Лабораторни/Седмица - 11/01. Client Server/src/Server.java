import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private List<PrintStream> clients;

    private Server() {
        clients = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        new Server().start();
    }

    private void start() {
        try {
            ServerSocket socket = new ServerSocket(2101);

            Object mutex = new Object();

            while (true) {
                Socket client = socket.accept();

                Thread clientThread = new Thread(() -> {
                    try {
                        Scanner in = new Scanner(client.getInputStream());
                        PrintStream out = new PrintStream(client.getOutputStream());

                        synchronized (mutex) {
                            clients.add(out);
                        }

                        String input = null;
                        while (true) {
                            input = in.nextLine();
                            if (input.contains("quit")) {
                                synchronized (mutex) {
                                    clients.remove(out);
                                }
                                in.close();
                                out.close();
                                client.close();
                                break;
                            }

                            synchronized (mutex) {
                                for (PrintStream c : clients) {
                                    c.println(input);
                                }
                            }
                        }
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                });

                clientThread.start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
