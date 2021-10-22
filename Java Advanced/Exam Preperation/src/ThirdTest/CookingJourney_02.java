package ThirdTest;

import java.util.Scanner;

public class CookingJourney_02 {
    static int sRow = 0;
    static int sCol = 0;
    static int countP = 0;
    static int p1Row = 0;
    static int p1Col = 0;
    static int p2Row = 0;
    static int p2Col = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(matrix, scanner, size);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentSymbol = matrix[i][j];
                if (currentSymbol == 'S') {
                    sRow = i;
                    sCol = j;
                }

                if (currentSymbol == 'P' && countP == 0) {
                    p1Row = i;
                    p1Col = j;
                    countP++;
                } else if (currentSymbol == 'P') {
                    p2Row = i;
                    p2Col = j;
                    countP++;
                }
            }
        }

        boolean isOut = false;
        int sumForRent = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[sRow][sCol] = '-';
            switch (command) {
                case "up":
                    if (sRow > 0) {
                        sRow--;
                    } else {
                        isOut = true;
                    }
                    break;
                case "right":
                    if (sCol < size - 1) {
                        sCol++;
                    } else {
                        isOut = true;
                    }
                    break;
                case "left":
                    if (sCol > 0) {
                        sCol--;
                    } else {
                        isOut = true;
                    }
                    break;
                case "down":
                    if (CookingJourney_02.sRow < size - 1) {
                        CookingJourney_02.sRow++;
                    } else {
                        isOut = true;
                    }
                    break;
            }
            char digit = matrix[sRow][sCol];
            if (matrix[sRow][sCol] == 'P') {
                if (matrix[sRow][sCol] == matrix[p1Row][p1Col]) {
                    matrix[sRow][sCol] = '-';
                    sRow = p2Row;
                    sCol = p2Col;
                    matrix[sRow][sCol] = '-';
                } else if (matrix[sRow][sCol] == matrix[p2Row][p2Col]) {
                    sRow = p1Row;
                    sCol = p1Col;
                    matrix[sRow][sCol] = '-';
                }
            } else if (Character.isDigit(digit)) {
                int number = Integer.parseInt(String.valueOf(digit));
                sumForRent += number;
            }
            if (isOut) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (sumForRent >= 50) {
                matrix[sRow][sCol] = 'S';
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }
        System.out.printf("Money: %d%n", sumForRent);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.printf("%c", col);
            }
            System.out.println();
        }
    }
    private static void fillMatrix(char[][] matrix, Scanner scanner, int size) {
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
        }
    }
}
