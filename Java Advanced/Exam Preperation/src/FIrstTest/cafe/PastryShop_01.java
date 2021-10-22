package FIrstTest.cafe;

import java.util.*;
public class PastryShop_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queueLiquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueLiquids::offer);

        Deque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackIngredients::push);

        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;


        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            int sumOfProducts;

            int firstProduct = queueLiquids.poll();
            int secondProduct = stackIngredients.peek();

            sumOfProducts = firstProduct + secondProduct;

            switch (sumOfProducts) {

                case 25:
                    biscuit++;
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
                    pie++;
                    stackIngredients.pop();
                    break;
                default:
                    int currentValue = stackIngredients.pop();
                    stackIngredients.push(currentValue + 3);
                    break;
            }
        }

        if (biscuit != 0 && cake != 0 && pastry != 0 && pie != 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (!queueLiquids.isEmpty()) {
            System.out.print("Liquids left: ");
            String result = String.join(", ",print(queueLiquids));
            System.out.println(result);
        } else {
            System.out.println("Liquids left: none");
        }

        if (!stackIngredients.isEmpty()) {
            System.out.print("Ingredients left: ");
            String result = String.join(", ",print(stackIngredients));
            System.out.println(result);
        } else {
            System.out.println("Ingredients left: none");
        }

        System.out.printf("Biscuit: %d%nCake: %d%nPie: %d%nPastry: %d", biscuit, cake, pie, pastry);
    }
    private static String[] print(Deque<Integer> e) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : e) {
            sb.append(number).append(" ");
        }
        return sb.toString().split("\\s+");
    }
}
