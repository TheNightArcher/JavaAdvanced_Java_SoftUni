import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbol_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Map<Character, Integer> counter = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);

            counter.putIfAbsent(currentSymbol, 0);
            int currentCount = counter.get(currentSymbol);
            counter.put(currentSymbol, currentCount + 1);
        }

        counter.forEach((k,v) -> System.out.printf("%c: %d time/s%n",k,v));
    }
}
