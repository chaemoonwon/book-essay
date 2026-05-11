import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputAnswer() {
        System.out.println("당신의 생각을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputBook() {
        System.out.println("책 제목을 입력하세요.");
        return scanner.nextLine();
    }

    public int inputChoice() {
        System.out.print("질문 번호를 선택하세요: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            return -1;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }
}
