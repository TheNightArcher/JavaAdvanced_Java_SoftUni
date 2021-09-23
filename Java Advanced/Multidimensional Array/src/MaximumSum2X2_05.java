import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2X2_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);

        int[][] matrix = readMatrix(rows, scanner);

        int[][] maxMatrix = new int[2][2];
        int maxSum = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int current = matrix[i][j];
                int currentPlsOne = matrix[i][j + 1];
                int bottom = matrix[i + 1][j];
                int bottomPlsOne = matrix[i + 1][j + 1];

                int currentSum = current + currentPlsOne + bottomPlsOne + bottom;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxMatrix = new int[][]{
                            {current, currentPlsOne},
                            {bottom, bottomPlsOne}
                    };
                }
            }
        }

        printMax(maxMatrix);
        System.out.println(maxSum);

    }

    private static void printMax(int[][] maxMatrix) {
        for (var arr : maxMatrix) {
            for (int nums : arr) {
                System.out.print(nums + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
