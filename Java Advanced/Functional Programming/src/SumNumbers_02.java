import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        Function<String[], Integer> count = e -> e.length;

        Function<String[], Integer> sum = e -> Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.printf("Count = %d%n",count.apply(input));
        System.out.printf("Sum = %d",sum.apply(input));
    }
}
