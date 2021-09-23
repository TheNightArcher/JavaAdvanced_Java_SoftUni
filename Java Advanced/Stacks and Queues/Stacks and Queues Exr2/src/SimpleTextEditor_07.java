import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder currentText = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] commandDate = scanner.nextLine().split("\\s+");
            String command = commandDate[0];

            switch (command) {
                case "1":
                    String textAdded = commandDate[1];
                    currentText.append(textAdded);
                    stack.push(currentText.toString());
                    break;
                case "2":
                    int countLastElement = Integer.parseInt(commandDate[1]);
                    int startIndex = currentText.length() - countLastElement;
                    currentText.delete(startIndex, startIndex + countLastElement);
                    stack.push(currentText.toString());
                    break;
                case "3":
                    int printChar = Integer.parseInt(commandDate[1]);
                    System.out.println(currentText.charAt(printChar - 1));
                    break;
                case "4":
                    if (stack.size() > 1) {
                        stack.pop();
                        currentText = new StringBuilder(stack.peek());
                    } else {
                        currentText = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
