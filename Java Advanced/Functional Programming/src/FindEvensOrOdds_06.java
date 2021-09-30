import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        String condition = scanner.nextLine();

        printNumbers(start, end,
                condition.equals("even")
                        ? p -> p % 2 == 0
                        : p -> p % 2 != 0);

    }

    public static void printNumbers(int startInclusive, int endInclusive, Predicate<Integer> type) {
        System.out.println(IntStream.rangeClosed(startInclusive, endInclusive)
                .boxed()
                .filter(type)
                .map(String::valueOf)
        .collect(Collectors.joining(" ")));
    }
}
