package FIrstTest.cafe;

import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine()); //брой на редове и брой на колони
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(scanner, size, matrix);

        int rowPlayer = 0;
        int colPlayer = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'P') {
                    rowPlayer = row;
                    colPlayer = col;
                    break;
                }
            }
        }

        boolean hasWon = false;
        for (int i = 0; i < countCommands; i++) {
            String direction = scanner.nextLine();

            int newRow = 0;
            int newCol = 0;
            switch (direction) {
                case "up":
                    //row - 1
                    newRow = checkIsOutside(rowPlayer - 1, size);
                    newCol = checkIsOutside(colPlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer - 2, size);
                        newCol = checkIsOutside(colPlayer, size);
                    }
                    break;
                case "down":
                    //row + 1
                    newRow = checkIsOutside(rowPlayer + 1, size);
                    newCol = checkIsOutside(colPlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer + 2, size);
                        newCol = checkIsOutside(colPlayer, size);
                    }
                    break;
                case "left":
                    //col - 1
                    newRow = checkIsOutside(rowPlayer, size);
                    newCol = checkIsOutside(colPlayer - 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer, size);
                        newCol = checkIsOutside(colPlayer - 2, size);
                    }
                    break;
                case "right":
                    //col + 1
                    newRow = checkIsOutside(rowPlayer, size);
                    newCol = checkIsOutside(colPlayer + 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIsOutside(rowPlayer, size);
                        newCol = checkIsOutside(colPlayer + 2, size);
                    }
                    break;
            }
            if (matrix[newRow][newCol] == 'T') {


            } else {
                if (matrix[newRow][newCol] == 'F') {
                    hasWon = true;
                }
                matrix[rowPlayer][colPlayer] = '.';
                matrix[newRow][newCol] = 'P';
                rowPlayer = newRow;
                colPlayer = newCol;
            }
        }
        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static int checkIsOutside(int index, int size) {

        if (index < 0) {
            index = size - 1;
        } else if (index >= size) {
            index = 0;
        }
        return index;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = line.toCharArray();
        }
    }
}