package service;

import java.util.*;

/*
 * Service
 * 생성
 * 처리
 * 결과 반환
 *
 * */
public class EssayService {

    public List<String> createQuestions() {
        List<String> questions = new ArrayList<>(List.of(
                "가장 인상깊은 부분은?",
                "이해가 되질 않았던 부분은?",
                "이 책에서 강조하는 메세지 무엇인가?"
        ));

        Collections.shuffle(questions);

        return questions;
    }

    private boolean isValid(List<String> questions, int choice) {
        return choice >= 1 && choice <= questions.size();
    }

    private int selectIndex(int choice) {
        return choice - 1;
    }

    public QuestionResult selectQuestion(List<String> questions, int choice) {

        if (!isValid(questions, choice)) {
            return QuestionResult.invalidRange();
        }

        int index = selectIndex(choice);
        String question = questions.get(index);//처리

        return QuestionResult.success(question);
    }

    public String generateEssay(String bookName, String question, String answer) {
        return "== 독후감 == \n" +
                "나는 " + bookName + "이란 책을 읽었다.\n" +
                "나는 \"" + question + "\" 라는 질문을 하게 되었다. \n" +
                "이 질문에 대해 " + answer + "이라고 생각한다.";
    }

}
