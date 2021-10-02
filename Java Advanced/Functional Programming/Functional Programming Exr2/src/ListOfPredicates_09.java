import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //TODO: divide all elements !

        BiFunction<List<Integer>, Integer, Boolean> idDivided = ((matrix, i) -> {
            for (var numMatrix : matrix) {
                if (i % numMatrix != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int i = 1; i <= n; i++) {

            if (idDivided.apply(numSequence,i)){
                System.out.printf("%d ",i);
            }
        }
    }
}
