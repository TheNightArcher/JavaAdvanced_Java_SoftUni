package SecondTest.groomingSalon;

import java.util.Scanner;

public class Python_02 {
    static int rowSnake = 0;
    static int colSnake = 0;
    static int foods = 0;
    static int snakeLength = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner, size);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentSymbol = matrix[i][j];

                if (currentSymbol == 's') {
                    rowSnake = i;
                    colSnake = j;
                }

                if (currentSymbol == 'f') {
                    foods++;
                }
            }
        }
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            int newRow = 0;
            int newCol = 0;
            if (foods != 0 && snakeLength != -1) {
                switch (currentCommand) {
                    case "up":
                        newRow = checkIsOutOfSide(rowSnake - 1, size);
                        newCol = checkIsOutOfSide(colSnake, size);
                        if (matrix[newRow][newCol] == 'f') {
                            foods--;
                            snakeLength++;
                        } else if (matrix[newRow][newCol] == 'e') {
                            snakeLength = -1;
                            break;
                        }
                        break;
                    case "down":
                        newRow = checkIsOutOfSide(rowSnake + 1, size);
                        newCol = checkIsOutOfSide(colSnake, size);
                        if (matrix[newRow][newCol] == 'f') {
                            foods--;
                            snakeLength++;
                        } else if (matrix[newRow][newCol] == 'e') {
                            snakeLength = -1;
                            break;
                        }
                        break;
                    case "left":
                        newRow = checkIsOutOfSide(rowSnake, size);
                        newCol = checkIsOutOfSide(colSnake - 1, size);
                        if (matrix[newRow][newCol] == 'f') {
                            foods--;
                            snakeLength++;
                        } else if (matrix[newRow][newCol] == 'e') {
                            snakeLength = -1;
                            break;
                        }
                        break;
                    case "right":
                        newRow = checkIsOutOfSide(rowSnake, size);
                        newCol = checkIsOutOfSide(colSnake + 1, size);
                        if (matrix[newRow][newCol] == 'f') {
                            foods--;
                            snakeLength++;
                        } else if (matrix[newRow][newCol] == 'e') {
                            snakeLength = -1;
                            break;
                        }
                        break;
                }

                rowSnake = newRow;
                colSnake = newCol;
            }
        }

        if (foods > 0 && snakeLength != -1) {
            System.out.printf("You lose! There is still %d food to be eaten.", foods);
        } else if (snakeLength == -1) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You win! Final python length is %d", snakeLength);
        }
    }

    private static int checkIsOutOfSide(int i, int size) {
        if (i >= size) {
            i = 0;
        } else if (i < 0) {
            i = size - 1;
        }
        return i;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner, int size) {

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
        }
    }

}
