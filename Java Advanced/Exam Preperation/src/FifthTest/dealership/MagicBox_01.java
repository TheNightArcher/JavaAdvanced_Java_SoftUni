package FifthTest.dealership;

import java.util.*;

public class MagicBox_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queueBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueBox::offer);


        Deque<Integer> stackBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackBox::push);

        int collectionValue = 0;
        while (!queueBox.isEmpty() && !stackBox.isEmpty()) {

            int sumFirstBox = queueBox.peek();
            int sumSecondBox = stackBox.peek();
            int sum = sumFirstBox + sumSecondBox;

            if (sum % 2 == 0) {
                collectionValue += sum;
                queueBox.poll();
                stackBox.pop();
            }else {
                int removeLastItemFromSecondBox = stackBox.pop();
                queueBox.offer(removeLastItemFromSecondBox);
            }
        }

        if (queueBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }

        if (collectionValue >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d",collectionValue);
        }else {
            System.out.printf("Poor prey... Value: %d",collectionValue);
        }
    }
}
