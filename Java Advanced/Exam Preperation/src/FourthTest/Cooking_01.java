package FourthTest;

import java.util.*;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queueLiquid = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueLiquid::offer);

        Deque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackIngredients::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!queueLiquid.isEmpty() && !stackIngredients.isEmpty()) {
            int queueValue = queueLiquid.poll();
            int stackValue = stackIngredients.peek();

            int sum = queueValue + stackValue;

            switch (sum) {
                case 25:
                    bread++;
                    stackIngredients.pop();
                    break;
                case 50:
                    cake++;
                    stackIngredients.pop();
                    break;
                case 75:
                    pastry++;
                    stackIngredients.pop();
                    break;
                case 100:
                    fruitPie++;
                    stackIngredients.pop();
                    break;
                default:
                    int currentValue = stackIngredients.pop();
                    stackIngredients.push(currentValue + 3);
                    break;
            }
        }

        if (bread != 0 && cake != 0 && pastry != 0 && fruitPie != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (queueLiquid.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String result = String.join(", ", print(queueLiquid));
            System.out.printf("Liquids left: %s%n", result);
        }

        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String result = String.join(", ", print(stackIngredients));
            System.out.printf("Ingredients left: %s%n", result);
        }
        Map<String,Integer> result = new TreeMap<>();
        result.put("Bread",bread);
        result.put("Cake",cake);
        result.put("Fruit Pie",fruitPie);
        result.put("Pastry",pastry);

       result.forEach((k,v) -> System.out.printf("%s: %d%n",k,v));
    }

    private static String[] print(Deque<Integer> elements) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : elements) {
            sb.append(number).append(" ");
        }
        return sb.toString().split("\\s+");
    }
}
