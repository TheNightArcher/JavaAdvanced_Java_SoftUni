import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVAT = e -> e * 1.20;

        System.out.println("Prices with VAT:");

        Arrays.stream(input)
                .map(Double::parseDouble)
                .map(addVAT)
                .forEach(price -> System.out.printf("%.2f%n", price));

    }
}
