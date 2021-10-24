import java.util.Scanner;

public class Mouse_02 {
    static int mRow = 0;
    static int mCol = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(scanner, matrix, size);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                char currentSymbol = matrix[i][j];

                if (currentSymbol == 'M') {
                    mRow = i;
                    mCol = j;
                }
            }
        }

        String command = scanner.nextLine();
        int countCheese = 0;
        boolean isOut = false;
        while (!command.equals("end")) {
            matrix[mRow][mCol] = '-';
            switch (command) {
                case "up":
                    if (mRow > 0) {
                        mRow--;
                        if (matrix[mRow][mCol] == 'B'){
                            matrix[mRow][mCol] = '-';
                           mRow--;
                        }
                    } else {
                        isOut = true;
                    }
                    break;
                case "down":
                    if (mRow < size - 1) {
                        mRow++;
                        if (matrix[mRow][mCol] == 'B'){
                            matrix[mRow][mCol] = '-';
                                mRow++;
                        }
                    } else {
                        isOut = true;
                    }
                    break;
                case "left":
                    if (mCol > 0) {
                        mCol--;
                        if (matrix[mRow][mCol] == 'B'){
                            matrix[mRow][mCol] = '-';
                            mCol--;
                        }
                    } else {
                        isOut = true;
                    }
                    break;
                case "right":
                    if (mCol < size - 1) {
                        mCol++;
                        if (matrix[mRow][mCol] == 'B'){
                            matrix[mRow][mCol] = '-';
                            mCol++;
                        }
                    } else {
                        isOut = true;
                    }
                    break;
            }
            char currentSymbol = matrix[mRow][mCol];

            if (currentSymbol == 'c'){
                countCheese++;
            }
            if (isOut){
                break;
            }
            command = scanner.nextLine();
        }
        if (isOut){
            System.out.println("Where is the mouse?");
        }else {
            matrix[mRow][mCol] = 'M';
        }

        int neededCheese = 5 - countCheese;
        if (countCheese < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",neededCheese);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",countCheese);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.printf("%c",col);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
        }
    }
}
