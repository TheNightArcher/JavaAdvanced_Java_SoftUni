import java.util.*;

public class HandsOfCards_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] inputDate = input.split(":\\s+");
            String namePlayer = inputDate[0];
            String cardsStr = inputDate[1];

            String[] arrCards = cardsStr.split(",\\s+");
            Set<String> cards = new LinkedHashSet<>();
            Collections.addAll(cards, arrCards);

            if (playersCards.containsKey(namePlayer)) {
                Set<String> currentCards = playersCards.get(namePlayer);
                currentCards.addAll(cards);

                playersCards.put(namePlayer, currentCards);
            } else {
                playersCards.put(namePlayer, cards);
            }
            input = scanner.nextLine();
        }

        playersCards.forEach((k, v) -> {
            int points = getPoints(v);

            System.out.printf("%s: %d%n",k,points);
        });
    }

    private static int getPoints(Set<String> v) {
        Map<Character, Integer> verifiedCard = getValue();

        int sumOfPoints = 0;
        for (var card : v) {

            int points;
            if (card.contains("10")) {
                char type = card.charAt(card.length() - 1);
                points = 10 * verifiedCard.get(type);
            } else {
                char value = card.charAt(0);
                char type = card.charAt(1);
                points = verifiedCard.get(value) * verifiedCard.get(type);
            }
            sumOfPoints += points;
        }
        return sumOfPoints;
    }

    private static Map<Character, Integer> getValue() {

        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
    }
}
