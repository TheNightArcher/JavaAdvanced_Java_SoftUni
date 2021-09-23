import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersStack_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split("\\s+");

        for (var number : numbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
