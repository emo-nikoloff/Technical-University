import java.io.Serializable;

public class Question implements Serializable {
    public enum Answer {
        A,
        B,
        C,
        D,
        EMPTY
    }

    private int id;
    private String questionText;
    private Answer answer;

    public Question(int id, String questionText, Answer answer) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
