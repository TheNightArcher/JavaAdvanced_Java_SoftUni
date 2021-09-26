import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0 && !firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty()) {

            int firstPlayer = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayer);

            int secondPlayer = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayer);

            if (firstPlayer > secondPlayer) {
                firstPlayerDeck.add(firstPlayer);
                firstPlayerDeck.add(secondPlayer);
            } else if (secondPlayer > firstPlayer) {
                secondPlayerDeck.add(firstPlayer);
                secondPlayerDeck.add(secondPlayer);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
