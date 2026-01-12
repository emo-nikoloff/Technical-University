import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Email {
    private String sender;
    private String subject;
    private String content;

    public Email(String sender, String subject, String content) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void appendToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(sender + "#" + subject + "#" + content + "$");
            writer.newLine();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static List<Email> loadFromFile(String path) {
        List<Email> emails = new ArrayList<>();

        File file = new File(path);

        if (!file.exists())
            return emails;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("#");
                String sender = parts[0];
                String subject = parts[1];
                String content = parts[2];

                Email email = new Email(sender, subject, content);
                emails.add(email);
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        return emails;
    }
}
