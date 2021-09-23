import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean realQueen;

        char[][] matrixChest = readMatrix(scanner);
        StringBuilder queenPosition = new StringBuilder();

        int rows, cols;

        for (int i = 0; i < matrixChest.length; i++) {
            realQueen = true;
            for (int j = 0; j < matrixChest[i].length; j++) {
                char queen = matrixChest[i][j];
                rows = i;
                cols =j;
                if (queen == 'q') {
                    while (rows < matrixChest.length - 1 && cols < matrixChest[rows].length - 1) {
                        char currentQueen = matrixChest[rows + 1][cols + 1];
                        if (currentQueen == 'q') {
                            realQueen = false;
                            break;
                        }
                        rows++;
                        cols++;
                    }
                    if (!realQueen) {
                        break;
                    } else {
                        rows = i;
                        cols = j;
                        while (rows > 0 && cols < matrixChest[rows].length -1) {
                            char currentQueen = matrixChest[rows - 1][cols + 1];

                            if (currentQueen == 'q') {
                                realQueen = false;
                                break;
                            }
                            rows--;
                            cols++;
                        }

                        if (!realQueen) {
                            break;
                        } else {
                            rows = i;
                            cols = j;
                            while (rows > 0 && cols > 0) {
                                char currentQueen = matrixChest[rows - 1][cols - 1];

                                if (currentQueen == 'q') {
                                    realQueen = false;
                                    break;
                                }
                                rows--;
                                cols--;
                            }

                            if (!realQueen) {
                                break;
                            } else {
                                rows = i;
                                cols = j;
                                while (rows < matrixChest.length -1 && cols > 0) {
                                    char currentQueen = matrixChest[rows + 1][cols - 1];

                                    if (currentQueen == 'q') {
                                        realQueen = false;
                                        break;
                                    }
                                    rows++;
                                    cols--;
                                }

                                if (realQueen) {
                                    queenPosition.append(i).append(" ");
                                    queenPosition.append(j);
                                    System.out.println(queenPosition);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static char[][] readMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int j = 0; j < 8; j++) {
                char currentChar = elements[j].charAt(0);
                matrix[i][j] = currentChar;
            }
        }
        return matrix;
    }
}
