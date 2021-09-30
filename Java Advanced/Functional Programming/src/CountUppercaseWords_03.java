import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> uppercaseFilter = e -> Character.isUpperCase(e.charAt(0));

        List<String> result = Arrays.stream(input)
                .filter(uppercaseFilter)
                .collect(Collectors.toList());

        System.out.println(result.size());
        System.out.println(String.join(System.lineSeparator(),result));
    }
}
