import service.EssayService;

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
        List<String> questions = service.createQuestions();

        //입력 + 로직 처리
        String question = service.selectQuestion(questions, scanner);
        System.out.println();

        //입력
        String answer = inputAnswer(scanner);
        System.out.println();

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
