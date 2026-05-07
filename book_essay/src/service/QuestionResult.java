package service;

public class QuestionResult {
    private final QuestionStatus status;
    private final String question;

    private QuestionResult(QuestionStatus status, String question) {
        this.status = status;
        this.question = question;
    }

    public static QuestionResult success(String question) {
        if (question == null) {
            //복구 불가
            throw new IllegalArgumentException("question must not be null.");
        }
        return new QuestionResult(QuestionStatus.SUCCESS, question);
    }

    public static QuestionResult invalidRange() {
        return new QuestionResult(QuestionStatus.INVALID_RANGE, null);
    }

    public QuestionStatus getStatus() {
        return status;
    }

    public String getQuestion() {
        return question;
    }

}
