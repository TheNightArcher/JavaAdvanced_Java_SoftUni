import java.util.Scanner;

public class IntersectionOfTow_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = addElements(rows, cols, scanner);
        char[][] secondMatrix = addElements(rows, cols, scanner);

        char[][] output = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char fillChar = firstMatrix[i][j] == secondMatrix[i][j]
                        ? firstMatrix[i][j] : '*';
                output[i][j] = fillChar;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }
    private static char[][] addElements(int rows, int cols, Scanner scanner) {

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
           String[] elements = scanner.nextLine().split("\\s+");

            for (int j = 0; j < cols; j++) {
                char current = elements[j].charAt(0);
                matrix[i][j] = current;
            }
        }
        return matrix;
    }
}
