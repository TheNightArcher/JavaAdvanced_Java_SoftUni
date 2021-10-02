import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> add = array -> Arrays.stream(array).map(number -> number += 1).toArray();
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(e -> e *= 2).toArray();
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e -= 1).toArray();

        Consumer<int[]> print = array -> Arrays.stream(array).forEach(number -> System.out.print(number + " "));

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            switch (input) {
                case "add":
                    nums = add.apply(nums);
                    break;
                case "multiply":
                    nums = multiply.apply(nums);
                    break;
                case "subtract":
                    nums = subtract.apply(nums);
                    break;
                case "print":
                    print.accept(nums);
                    System.out.println();
            }

            input = scanner.nextLine();
        }
    }
}
