import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {
    private static final String RESULTS_FILENAME = "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Изпити\\Изпит 9\\Q&A\\src\\results.bin";
    private ServerSocket server;
    private static Object lock;

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
                        sc.close();
                        out.close();
                    }
                });

                clientThread.start();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private void userMenu(Scanner sc, PrintStream out) {
        try {
            out.println("Enter UCN: ");
            String UCN = sc.nextLine();

            out.println("Enter facultyNumber: ");
            String facultyNumber = sc.nextLine();

            Student student = new Student(UCN, facultyNumber);
            Quiz quiz = new Quiz(student);
            Map<Integer, Question.Answer> studentAnswers = new HashMap<>();

            while (quiz.hasNext()) {
                out.println(quiz.getCurrentQuestion());
                out.println("Choose (A, B, C, D, EMPTY): ");
                String input = sc.nextLine().toUpperCase();

                Question.Answer answer = Question.Answer.valueOf(input);

                studentAnswers.put(quiz.getQuestionId(), answer);
                quiz.setAnswer(answer);
            }

            String status = null;
            if (quiz.isPassed(studentAnswers)) {
                status = "Passed!";
                out.println(status);
            } else {
                status = "Failed!";
                out.println(status);
            }

            synchronized (lock) {
                try (FileWriter fileWriter = new FileWriter(RESULTS_FILENAME, true)) {
                    fileWriter.write("Student: " + UCN + " | Result: " + status);
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        } catch (StudentException error) {
            out.println("Error: " + error.getMessage());
        }
    }
}
