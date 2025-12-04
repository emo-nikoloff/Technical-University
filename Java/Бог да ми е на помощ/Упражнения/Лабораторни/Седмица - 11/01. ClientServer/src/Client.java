import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        new Client().connect();
    }

    private void connect() {
        try {
            Scanner console = new Scanner(System.in);
            System.out.println("Enter name:");
            String myName = console.nextLine();

            Socket socket = new Socket("localhost", 2101);

            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());

            Thread writerThread = new Thread(() -> {
                try {
                    String input = null;
                    while (true) {
                        input = console.nextLine();
                        out.println(myName + ": " + input);
                        if (input.contains("quit")) {
                            in.close();
                            out.close();
                            socket.close();
                            break;
                        }
                    }
                } catch (IOException error) {
                    error.printStackTrace();
                }
            });

            Thread readerThread = new Thread(() -> {
                while (true) {
                    if (in.hasNext()) {
                        System.out.println(in.nextLine());
                    }
                }
            });

            writerThread.start();
            readerThread.start();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
