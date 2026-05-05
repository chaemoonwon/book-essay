import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String book = inputBook(scanner);

        System.out.println();

//        System.out.println("책에 대한 질문을 입력하세요.");
//        String question = scanner.nextLine();
        List<String> questions = createQuestions();


        String question = selectQuestion(questions, scanner);
        System.out.println();

        String answer = inputAnswer(scanner);

        String essay = generateEssay(book, question, answer);
        System.out.println(essay);

    }

    private static String inputAnswer(Scanner scanner) {
        System.out.println("당신의 생각을 입력하세요.");
        String answer = scanner.nextLine();
        return answer;
    }

    private static String inputBook(Scanner scanner) {
        System.out.println("책 제목을 입력하세요.");
        String book = scanner.nextLine();   //입력 받기
        System.out.println("입력한 책 제목: " + book);
        
        return book;
    }

    private static String generateEssay(String bookName, String question, String answer) {
        return "== 독후감 == \n" +
                        "나는 " + bookName + "이란 책을 읽었다.\n" +
                        "나는 \"" + question + "\" 라는 질문을 하게 되었다. \n" +
                        "이 질문에 대해 " + answer + "이라고 생각한다.";
    }

    private static String selectQuestion(List<String> questions, Scanner scanner) {
        System.out.println("번호를 입력하세요:");
        int choice;

        while (true) {
            try {
                choice = scanner.nextInt(); //enter를 소비하지 않음.
                scanner.nextLine();
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

    private static List<String> createQuestions() {
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
}
