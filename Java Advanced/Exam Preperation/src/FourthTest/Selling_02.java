package FourthTest;

import java.util.Scanner;

public class Selling_02 {
    static int bRow = 0;
    static int bCol = 0;
    static int o1Row = 0;
    static int o1Col = 0;
    static int o2Row = 0;
    static int o2Col = 0;
    static int countO = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(matrix, scanner, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentSymbol = matrix[i][j];

                if (currentSymbol == 'S') {
                    bRow = i;
                    bCol = j;
                }

                if (currentSymbol == 'O' && countO == 0) {
                    o1Row = i;
                    o1Col = j;
                    countO++;
                } else if (currentSymbol == 'O') {
                    o2Row = i;
                    o2Col = j;
                    countO++;
                }
            }
        }
        boolean isOut = false;
        int bakeryRent = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[bRow][bCol] = '-';
            switch (command) {
                case "up":
                    if (bRow > 0) {
                        bRow--;
                    } else {
                        isOut = true;
                    }
                    break;
                case "down":
                    if (bRow < size - 1) {
                        bRow++;
                    } else {
                        isOut = true;
                    }
                    break;
                case "left":
                    if (bCol > 0) {
                        bCol--;
                    } else {
                        isOut = true;
                    }
                    break;
                case "right":
                    if (bCol < size - 1) {
                        bCol++;
                    } else {
                        isOut = true;
                    }
                    break;
            }
            char element = matrix[bRow][bCol];
            if (element == 'O') {
                if (element == matrix[o1Row][o1Col]) {
                    matrix[bRow][bCol] = '-';
                    bRow = o2Row;
                    bCol = o2Col;
                    matrix[bRow][bCol] = '-';
                } else if (element == matrix[o2Row][o2Col]) {
                    matrix[bRow][bCol] = '-';
                    bRow = o1Row;
                    bCol = o1Col;
                    matrix[bRow][bCol] = '-';
                }
            } else if (Character.isDigit(element)) {
                int income = Integer.parseInt(String.valueOf(element));
                bakeryRent += income;
            }
            if (isOut) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            if (bakeryRent >= 50) {
                matrix[bRow][bCol] = 'S';
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }
        System.out.printf("Money: %d%n", bakeryRent);
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
