import java.util.*;

public class AutumnCocktails_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queueBucket = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueBucket::offer);

        Deque<Integer> stackFreshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshness::push);


        Map<String, Integer> result = new TreeMap<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        boolean isDone = false;

        while (!queueBucket.isEmpty() && !stackFreshness.isEmpty()) {
            int firstProduct = queueBucket.peek();
            int secondProduct = stackFreshness.peek();

            int sumOfProducts = firstProduct * secondProduct;


            if (sumOfProducts == 150) {
                queueBucket.poll();
                stackFreshness.pop();
                count1++;
                result.putIfAbsent("Pear Sour", 0);
                int currentCount1 = result.get("Pear Sour");
                result.put("Pear Sour", currentCount1 + 1);
            } else if (sumOfProducts == 250) {
                queueBucket.poll();
                stackFreshness.pop();
                count2++;
                result.putIfAbsent("The Harvest", 0);
                int currentCount2 = result.get("The Harvest");
                result.put("The Harvest", currentCount2 + 1);
            } else if (sumOfProducts == 300) {
                queueBucket.poll();
                stackFreshness.pop();
                count3++;
                result.putIfAbsent("Apple Hinny", 0);
                int currentCount3 = result.get("Apple Hinny");
                result.put("Apple Hinny", currentCount3 + 1);
            } else if (sumOfProducts == 400) {
                count4++;
                result.putIfAbsent("High Fashion", 0);
                int currentCount4 = result.get("High Fashion");
                result.put("High Fashion", currentCount4 + 1);
                queueBucket.poll();
                stackFreshness.pop();
            }else if (firstProduct == 0){
                queueBucket.poll();
            }
            else {
                stackFreshness.pop();
                int currentValue = queueBucket.poll();
                queueBucket.offer(currentValue + 5);
            }
            if (count1 >= 1 && count2 >= 1 && count3 >= 1 && count4 >= 1) {
                isDone = true;
            }
        }


        if (isDone) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");

        }

        if (!queueBucket.isEmpty()){
            int sum = 0;
            while (!queueBucket.isEmpty()) {
                int value = queueBucket.poll();
                sum += value;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        result.forEach((k, v) -> {
            System.out.printf(" # %s --> %d%n", k, v);
        });
    }
}

