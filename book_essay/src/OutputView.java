import java.util.List;

public class OutputView {

    public void printQuestions(List<String> questions) {
        System.out.println("생성된 질문입니다.");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
        }

    }

    public void printInvalidChoiceMessage() {
        System.out.println("잘못된 번호입니다.");

    }

    public void printEssay(String essay) {
        System.out.println(essay);
    }

    public void printNotNumberMessage() {
        System.out.println("숫자를 입력하세요.");
    }

    public void printSelectedQuestion(String question) {
        System.out.println("오늘의 책 질문: " + question);

    }

}
