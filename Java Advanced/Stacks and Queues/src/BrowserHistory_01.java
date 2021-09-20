import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        String currentPage = "";
        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!stack.isEmpty()) {
                    currentPage = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentPage.equals("")) {
                    stack.push(currentPage);
                }
                currentPage = command;
            }
            System.out.println(currentPage);
            command = scanner.nextLine();
        }
    }
}
