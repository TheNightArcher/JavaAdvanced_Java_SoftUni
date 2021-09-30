import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> getEvenNumbers = input.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        String beforeResult = getEvenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(beforeResult);

        String result = getEvenNumbers.stream().sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(result);


    }
}
