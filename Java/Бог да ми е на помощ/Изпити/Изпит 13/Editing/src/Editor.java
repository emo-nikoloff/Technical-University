import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Editor {
    private StringBuilder internalBuffer;

    public Editor() {
        this.internalBuffer = new StringBuilder();
    }

    public String getContent() {
        return internalBuffer.toString();
    }

    public void read(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                internalBuffer.append(line).append("\n");
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void insert(int offset, String string) {
        internalBuffer.insert(offset, string);
    }

    public void delete(int start, int end) {
        internalBuffer.delete(start, end);
    }

    public void write(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(internalBuffer.toString());
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
