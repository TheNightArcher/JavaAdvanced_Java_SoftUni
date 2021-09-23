import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int[][] firstMatrix = checkMarice(rows, scanner);

        String[] input2 = scanner.nextLine().split("\\s+");
        rows = Integer.parseInt(input2[0]);
        int[][] secondMatrix = checkMarice(rows, scanner);

        boolean areEqual = checkIs(firstMatrix, secondMatrix);
        String output = areEqual ? "equal" : "not equal";

        System.out.println(output);
    }

    private static int[][] checkMarice(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {

            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static boolean checkIs(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int j = 0; j < firstArr.length; j++) {
                if (firstArr[j] != secondArr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
