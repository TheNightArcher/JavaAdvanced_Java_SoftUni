import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(input[0]);
        int secondSetSize = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int nums = Integer.parseInt(scanner.nextLine());
            firstSet.add(nums);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int nums = Integer.parseInt(scanner.nextLine());
            secondSet.add(nums);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.printf("%d ",e));

    }
}
