import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumber_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> counter = new LinkedHashMap<>();

        for (var num : numbers) {
            counter.putIfAbsent(num, 0);

            int currentCount = counter.get(num);
            counter.put(num, currentCount + 1);
        }

        counter.forEach((k, v) -> System.out.printf("%.1f -> %d%n",k,v));
    }
}
