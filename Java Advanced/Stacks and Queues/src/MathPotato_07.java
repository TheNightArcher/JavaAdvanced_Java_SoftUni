import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] players = scanner.nextLine().split("\\s+");
        int potatoCounter = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String children : players) {
            queue.offer(children);
        }

        int counter = 1;

        while (queue.size() > 1) {


            for (int i = 1; i < potatoCounter; i++) {
                queue.offer(queue.poll());
            }


            if (isPrime(counter)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            counter++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int counter) {
        if (counter == 1){
            return false;
        }
        for (int i = 2; i < counter; i++) {
            if (counter % i == 0){
                return false;
            }
        }
        return true;
    }
}