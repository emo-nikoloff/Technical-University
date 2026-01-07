import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Quiz implements Serializable {
    private static final String QUESTIONS_FILENAME = "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Изпити\\Изпит 9\\Q&A\\src\\questions.bin";
    private static final String ANSWERS_FILENAME = "C:\\Users\\Емо Николов\\Desktop\\Проекти\\От университета\\Java\\Бог да ми е на помощ\\Изпити\\Изпит 9\\Q&A\\src\\answers.bin";

    private Student student;
    private List<Question> questions;
    private int currentQuestion;

    public Quiz(Student student) {
        this.student = student;
        questions = loadQuestions();
        this.currentQuestion = 0;
    }

    @SuppressWarnings("unchecked")
    private List<Question> loadQuestions() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(QUESTIONS_FILENAME))) {
            List<Question> questions = (List<Question>) in.readObject();
            Collections.shuffle(questions);

            return questions;
        } catch (IOException error) {
            if (error instanceof InvalidClassException) {
                throw new RuntimeException("..." +
                        "Serializable versions are not supported." +
                        "...", error);
            }

            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            throw new RuntimeException(error);
        }

        return null;
    }

    public int getQuestionId() {
        return questions.get(currentQuestion).getId();
    }

    public boolean hasNext() {
        return currentQuestion < questions.size();
    }

    public String getCurrentQuestion() {
        return questions.get(currentQuestion).getQuestionText();
    }

    public void setAnswer(Question.Answer answer) {
        questions.get(currentQuestion).setAnswer(answer);
        currentQuestion++;
    }

    @SuppressWarnings("unchecked")
    public boolean isPassed(Map<Integer, Question.Answer> clientAnswers) {
        int correctCount = 0;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ANSWERS_FILENAME))) {
            Map<Integer, Question.Answer> correctAnswers = (Map<Integer, Question.Answer>) in.readObject();

            for (Map.Entry<Integer, Question.Answer> entry : clientAnswers.entrySet()) {
                if (entry.getValue().equals(correctAnswers.get(entry.getKey()))) {
                    correctCount++;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return correctCount > (questions.size() / 2);
    }
}
