import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask_6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            map.putIfAbsent(input, 0);
            int currentQuantity = map.get(input);
            map.put(input, currentQuantity + quantity);
            input = scanner.nextLine();
        }

        map.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
