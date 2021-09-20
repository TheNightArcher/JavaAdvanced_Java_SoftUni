import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] players = scanner.nextLine().split("\\s+");
        int potatoCounter = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child: players) {
            queue.offer(child);
        }

        while (queue.size() > 1) {

            for (int i = 1; i < potatoCounter; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
