package SecondTest.groomingSalon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OS_Planing_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stackTasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(stackTasks::push);

        Deque<Integer> queueThreads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueThreads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (!queueThreads.isEmpty()){
            int stackTaskValue = stackTasks.peek();
            int queueThreadValue = queueThreads.peek();

            if (stackTaskValue != taskToKill){
                if (queueThreadValue >= stackTaskValue){
                    stackTasks.pop();
                    queueThreads.poll();
                }else {
                    queueThreads.poll();
                }
            }else {
                System.out.printf("Thread with value %d killed task %d%n",queueThreadValue,stackTaskValue);
                queueThreads.forEach(e -> System.out.printf("%d ",e));
                break;
            }
        }


    }
}
