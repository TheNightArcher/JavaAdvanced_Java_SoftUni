import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String currentPage = "";
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    currentPage = stack.pop();
                }else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else if (input.equals("forward")) {
                if (!queue.isEmpty()){
                    currentPage = queue.poll();
                }else {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentPage.equals("")) {
                    stack.push(currentPage);
                   queue.push(input);
                }
                currentPage = input;

            }
            System.out.println(currentPage);
            input = scanner.nextLine();
        }
    }
}
