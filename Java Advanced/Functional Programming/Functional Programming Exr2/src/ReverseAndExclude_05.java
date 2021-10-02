import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(nums);

        int divideNum = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkerDivide = e -> e % divideNum == 0;
        nums.removeIf(checkerDivide);

        nums.forEach(e -> System.out.printf("%d ",e));
    }
}
