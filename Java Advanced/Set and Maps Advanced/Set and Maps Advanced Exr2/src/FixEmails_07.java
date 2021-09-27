import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> verifiedMail = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                verifiedMail.put(input, email);
            }

            input = scanner.nextLine();
        }

        verifiedMail.forEach((k,v) -> System.out.printf("%s -> %s%n",k,v));
    }
}
