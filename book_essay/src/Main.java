import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("책 제목을 입력하세요.");
        String bookName = scanner.nextLine();

        System.out.println("입력한 책 제목: " + bookName);
        System.out.println();

//        System.out.println("책에 대한 질문을 입력하세요.");
//        String question = scanner.nextLine();
        System.out.println("생성된 질문입니다.");
        List<String> questions = List.of(
                "가장 인상깊은 부분은?",
                "이해가 되질 않았던 부분은?",
                "이 책에서 강조하는 메세지 무엇인가?"
        );
        Random random = new Random();
        int questionIndex = random.nextInt(questions.size());
        String question = questions.get(questionIndex);

        System.out.println("오늘의 책 질문: " + question);
        System.out.println();

        System.out.println("당신의 생각을 입력하세요.");
        String answer = scanner.nextLine();
        System.out.println(
                "== 독후감 == \n" +
                "나는 " + bookName + "이란 책을 읽었다.\n" +
                        "나는 \"" + question + "\" 라는 질문을 하게 되었다. \n" +
                        "이 질문에 대해 " + answer + "이라고 생각한다.");
    }
}
