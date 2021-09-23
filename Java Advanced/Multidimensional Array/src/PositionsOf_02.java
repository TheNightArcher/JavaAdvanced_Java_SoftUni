import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositionsOf_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);

        List<int[]> indexes = new ArrayList<>();

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }

        int lookingNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int current = matrix[i][j];
                if (current == lookingNumber) {
                    int[] fountAt = {i, j};
                    indexes.add(fountAt);
                }
            }
        }

        if (!indexes.isEmpty()){
                String output = indexes.stream().map(arr -> arr[0] + " " + arr[1])
                        .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(output);
        }else {
            System.out.println("not found");
        }

    }
}
