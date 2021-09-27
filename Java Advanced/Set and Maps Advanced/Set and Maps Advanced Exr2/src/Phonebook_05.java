import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> phoneBook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] inputDate = input.split("-");
            String name = inputDate[0];
            String phoneNumber = inputDate[1];

            phoneBook.putIfAbsent(name, phoneNumber);
            phoneBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }
        String lookingForPerson = scanner.nextLine();

        while (!lookingForPerson.equals("stop")) {

            if (phoneBook.containsKey(lookingForPerson)) {
                String personNumber = phoneBook.get(lookingForPerson);

                System.out.printf("%s -> %s%n",lookingForPerson,personNumber);
            }else {
                System.out.printf("Contact %s does not exist.%n",lookingForPerson);
            }
            lookingForPerson = scanner.nextLine();
        }
    }
}
