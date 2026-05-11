import service.EssayService;
import service.QuestionResult;
import service.QuestionStatus;

import java.util.*;

//입력(controller)역할

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        EssayService service = new EssayService();


        //입력
        String book = inputView.inputBook();

        //로직 처리
        List<String> questions = service.createQuestions();

        //출력
        outputView.printQuestions(questions);

        //입력 + 로직 처리
        int choice = inputView.inputChoice();
        //정상 숫자가 아닐 때
        while (choice < 0) {
            outputView.printNotNumberMessage();
            choice = inputView.inputChoice();
        }

        QuestionResult result = service.selectQuestion(questions, choice);
        while (result.getStatus() != QuestionStatus.SUCCESS) {
            outputView.printInvalidChoiceMessage();
            choice = inputView.inputChoice();
            result = service.selectQuestion(questions, choice);
        }

        String question = result.getQuestion();

        outputView.printSelectedQuestion(question);
        String answer = inputView.inputAnswer();

        //출력
        String essay = service.generateEssay(book, question, answer);
        outputView.printEssay(essay);

    }
}
