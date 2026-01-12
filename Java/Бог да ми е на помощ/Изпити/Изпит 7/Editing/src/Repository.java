import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Repository implements Serializable {
    private String name;
    private Stack<Commit> commits;
    private List<String> editors;

    public Repository(String name) {
        this.name = name;
        this.commits = new Stack<>();
        this.editors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getEditors() {
        return editors;
    }

    public void commit(Commit newCommit) {
        commits.push(newCommit);
    }

    public void revert() {
        commits.pop();
    }

    public void push() {
        for (Commit commit : commits) {
            try (FileWriter writer = new FileWriter(name + "/" + commit.getFileName())) {
                writer.write(commit.getFileContent());
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }
}
