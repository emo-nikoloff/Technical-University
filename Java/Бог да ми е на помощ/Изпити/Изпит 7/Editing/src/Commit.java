import java.io.Serializable;

public class Commit implements Serializable {
    private int id;
    private String message;
    private String fileName;
    private String fileContent;

    public Commit(int id, String message, String fileName, String fileContent) {
        this.id = id;
        this.message = message;
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileContent() {
        return fileContent;
    }

}
