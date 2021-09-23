import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                stack.push(currentSymbol);
            } else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {
                queue.offer(currentSymbol);

                if (stack.isEmpty()){
                    isBalanced = false;
                    break;
                }

                char queueSymbol = queue.poll();
                char stackSymbol = stack.pop();

                if (stackSymbol == '(' && queueSymbol == ')') {
                    isBalanced = true;
                } else if (stackSymbol == '{' && queueSymbol == '}') {
                    isBalanced = true;
                } else if (stackSymbol == '[' && queueSymbol == ']') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
