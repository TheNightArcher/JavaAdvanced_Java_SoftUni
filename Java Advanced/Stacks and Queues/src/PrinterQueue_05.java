import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String document = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!document.equals("print")) {

            if (document.equals("cancel")) {
                if (!queue.isEmpty()) {
                    System.out.println("Canceled " + queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                    document = scanner.nextLine();
                    continue;
                }
            } else {
                if (!document.equals("")) {
                    queue.offer(document);
                }
            }
            document = scanner.nextLine();
        }

        for (var print : queue) {
            System.out.println(print);
        }
    }
}
