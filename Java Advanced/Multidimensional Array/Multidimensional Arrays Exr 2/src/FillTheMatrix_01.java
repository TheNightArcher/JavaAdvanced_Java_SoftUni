import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[rows][rows];

        if (pattern.equals("A")) {
            int[][] patternA = fillMatrixA(matrix);
        } else if (pattern.equals("B")) {
            int[][] patternB = fillMatrixB(matrix);
        }
         printResult(matrix);
    }

    private static void printResult(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixB(int[][] matrix) {

        int startPoint = 1;

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = startPoint++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = startPoint++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixA(int[][] matrix) {

        int startPoint = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[j][i] = startPoint++;
            }
        }
        return matrix;
    }

}
