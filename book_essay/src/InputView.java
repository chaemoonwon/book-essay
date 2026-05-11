import service.EssayService;
import service.QuestionResult;
import service.QuestionStatus;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputAnswer() {
        System.out.println("당신의 생각을 입력하세요.");
        String answer = scanner.nextLine(); //입력 받기
        return answer;
    }

    public String inputBook() {
        System.out.println("책 제목을 입력하세요.");
        String book = scanner.nextLine();   //입력 받기
        System.out.println("입력한 책 제목: " + book);

        return book;
    }

    public int inputChoice() {
        System.out.print("질문 번호를 선택하세요: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
//            return Integer.parseInt(scanner.nextLine());
        }
        return 0;
    }
}
