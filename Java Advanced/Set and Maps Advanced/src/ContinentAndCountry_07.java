import java.util.*;

public class ContinentAndCountry_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countries = map.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countries.get(country);
            cities.add(city);
        }

        map.forEach((k, v) -> {
            System.out.printf("%s:%n", k);

            v.forEach((vk,cv) -> System.out.printf("  %s -> %s%n",vk,String.join(", ",cv)));
        });
    }
}
