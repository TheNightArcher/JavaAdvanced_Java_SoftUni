import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int maxLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        List<String> names = Arrays.stream(input.split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> checkLength = e -> e.length() <= maxLength;

        names.stream().filter(checkLength).forEach(System.out::println);
    }
}
