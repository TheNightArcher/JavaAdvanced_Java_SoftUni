import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pushN = scanner.nextInt();
        int popS = scanner.nextInt();
        int compareX = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < pushN; i++) {

            int givenNumbers = scanner.nextInt();
            queue.offer(givenNumbers);
        }

        for (int i = 0; i < popS; i++) {

            queue.poll();
        }

        if (queue.contains(compareX)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }
    }
}
