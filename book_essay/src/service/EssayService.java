package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EssayService {


    public List<String> createQuestions() {
        System.out.println("생성된 질문입니다.");
        List<String> questions = new ArrayList<>(List.of(
                "가장 인상깊은 부분은?",
                "이해가 되질 않았던 부분은?",
                "이 책에서 강조하는 메세지 무엇인가?"
        ));

        Collections.shuffle(questions);

        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
        }

        return questions;
    }

    public String selectQuestion(List<String> questions, Scanner scanner) {
        System.out.println("번호를 입력하세요:");
        int choice;

        while (true) {
            try {
                choice = scanner.nextInt(); //enter를 소비하지 않음.
                scanner.nextLine(); //enter 소비하는 역할
                if (choice >= 1 && choice <= questions.size()) {
                    break;
                } else {
                    System.out.println("범위를 초과하였습니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요");
                scanner.nextLine(); //입력 받은 버퍼를 비우는 역할을 함.
            }
        }

        String question = questions.get(choice - 1);    //처리
        System.out.println("오늘의 책 질문: " + question);
        return question;
    }

    public String generateEssay(String bookName, String question, String answer) {
        return "== 독후감 == \n" +
                "나는 " + bookName + "이란 책을 읽었다.\n" +
                "나는 \"" + question + "\" 라는 질문을 하게 되었다. \n" +
                "이 질문에 대해 " + answer + "이라고 생각한다.";
    }

}
