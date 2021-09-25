import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillMatrix(scanner, rows);

        int primeSum = leftBottom(matrix);
        int secondarySum = rightBottom(matrix);

        int result = primeSum - secondarySum;

        System.out.println(Math.abs(result));
    }

    private static int rightBottom(int[][] matrix) {
        int row = 0, col = matrix.length - 1;
        int sum2 = 0;

        for (int i = row; i < matrix.length - 1; i++) {
            for (int j = col; j >= 0; j--) {

                sum2 += matrix[row][col];
                row++;
                col--;
            }
        }
        return sum2;

    }

    private static int leftBottom(int[][] matrix) {
        int row = 0, col = 0;
        int sum1 = 0;

        for (int i = row; i < matrix.length  ; i++) {
                sum1 += matrix[row][col];
                row++;
                col++;
        }
        return sum1;
    }

    private static int[][] fillMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][rows];
        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }
}
