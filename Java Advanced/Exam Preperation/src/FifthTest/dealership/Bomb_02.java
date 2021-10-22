package FifthTest.dealership;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb_02 {

    static int sRow = 0;
    static int sCol = 0;
    static int bombsCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        List<String> commands = Arrays.stream(scanner.nextLine().
                        split(","))
                .collect(Collectors.toList());

        char[][] matrix = new char[size][size];
        fillMatrix(scanner, matrix, size);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                char currentSymbol = matrix[i][j];
                if (currentSymbol == 's') {
                    sRow = i;
                    sCol = j;
                }
                if (currentSymbol == 'B') {
                    bombsCount++;
                }
            }
        }

        boolean isRoutEnd = false;
        int counter = 0;
        while (commands.size() > counter) {
            String currentCommand = commands.get(counter);
            switch (currentCommand) {
                case "up":
                    if (sRow > 0) {
                        sRow--;
                    }
                    break;
                case "down":
                    if (sRow < size - 1) {
                        sRow++;
                    }
                    break;
                case "left":
                    if (sCol > 0) {
                        sCol--;
                    }
                    break;
                case "right":
                    if (sCol < size - 1) {
                        sCol++;
                    }
                    break;
            }
            char element = matrix[sRow][sCol];
            if (element == 'B') {
                bombsCount--;
                System.out.println("You found a bomb!");
                matrix[sRow][sCol] = '+';
            }
            if (element == 'e'){
                isRoutEnd = true;
                break;
            }
                counter++;
        }

        if (bombsCount == 0){
            System.out.println("Congratulations! You found all bombs!");
        }else if (isRoutEnd){
            System.out.printf("END! %d bombs left on the field",bombsCount);
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombsCount,sRow,sCol);
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix, int size) {

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
        }
    }
}
