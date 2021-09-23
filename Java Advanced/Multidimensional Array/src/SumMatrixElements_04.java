import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] elements = scanner.nextLine().split(",\\s+");

            for (int j = 0; j < cols; j++) {
                sum += Integer.parseInt(elements[j]);
            }
        }

        System.out.printf("%d%n%d%n%d",rows,cols,sum);
    }
}
