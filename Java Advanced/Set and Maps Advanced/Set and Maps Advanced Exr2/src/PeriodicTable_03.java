import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Set<String> result = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            result.addAll(Arrays.asList(input));
        }

        result.forEach(e -> System.out.printf("%s ",e));
    }
}
