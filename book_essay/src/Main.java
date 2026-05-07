import service.EssayService;
import service.QuestionResult;
import service.QuestionStatus;

import java.util.*;

//입력(controller)역할

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EssayService service = new EssayService();

        //입력
        String book = inputBook(scanner);
        System.out.println();

        //로직 처리
        System.out.println("생성된 질문입니다.");
        List<String> questions = service.createQuestions();

        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
        }

        //입력 + 로직 처리
        String question = null;
        while (true) {
            System.out.println("번호를 입력하세요:");
            //hasNextInt() : 입력 데이터가 정수형인지 미리 검사
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();//enter를 소비하지 않음.
                scanner.nextLine();
                QuestionResult result = service.selectQuestion(questions, choice);
                if (result.getStatus() == QuestionStatus.SUCCESS) {
                    question = result.getQuestion();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } else {
                scanner.nextLine();
                System.out.println("숫자를 입력하세요.");
            }
        }

        System.out.println("오늘의 책 질문: " + question);

        //입력
        String answer = inputAnswer(scanner);

        //출력
        String essay = service.generateEssay(book, question, answer);
        System.out.println(essay);

    }

    private static String inputAnswer(Scanner scanner) {
        System.out.println("당신의 생각을 입력하세요.");
        String answer = scanner.nextLine(); //입력 받기
        return answer;
    }

    private static String inputBook(Scanner scanner) {
        System.out.println("책 제목을 입력하세요.");
        String book = scanner.nextLine();   //입력 받기
        System.out.println("입력한 책 제목: " + book);

        return book;
    }

}
