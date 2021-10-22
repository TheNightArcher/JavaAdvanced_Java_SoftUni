package ThirdTest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stackTulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackTulips::push);

        Deque<Integer> queueDaffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(queueDaffodils::offer);

        int leftFlowers = 0;
        int bouquets = 0;
        while (!queueDaffodils.isEmpty() && !stackTulips.isEmpty()) {
            int tulipsValue = stackTulips.peek();
            int daffodilsValue = queueDaffodils.peek();
            int sum = tulipsValue + daffodilsValue;

            if (sum == 15) {
                stackTulips.pop();
                queueDaffodils.poll();
                bouquets++;
            } else if (sum < 15) {
                leftFlowers += sum;
                stackTulips.pop();
                queueDaffodils.poll();
            } else {
                sum -= 2;
                while (sum > 15) {
                    sum -= 2;
                }
                if (sum == 15) {
                    bouquets++;
                } else {
                    leftFlowers += sum;
                }
                stackTulips.pop();
                queueDaffodils.poll();
            }
        }

        while (leftFlowers > 15) {
            bouquets++;
            leftFlowers -= 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
