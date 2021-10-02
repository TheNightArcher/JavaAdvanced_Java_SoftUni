import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int minNum = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .min().orElse(0);
        System.out.println(minNum);
    }
}
