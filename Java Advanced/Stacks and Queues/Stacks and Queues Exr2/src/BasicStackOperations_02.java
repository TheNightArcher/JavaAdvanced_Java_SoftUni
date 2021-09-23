import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pushN = scanner.nextInt();
        int popS = scanner.nextInt();
        int compareX = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushN; i++) {

            int givenNumbers = scanner.nextInt();
            stack.push(givenNumbers);
        }

        for (int i = 0; i < popS; i++) {

            stack.pop();
        }

        if (stack.contains(compareX)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {
                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }
    }

}
