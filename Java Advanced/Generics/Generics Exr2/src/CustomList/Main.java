package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        CustomList<String> elements = new CustomList<String>();

        while (!input.equals("END")) {
            String[] inputDate = input.split("\\s+");
            String command = inputDate[0];

            switch (command) {
                case "Add":
                    String element = inputDate[1];
                    elements.add(element);
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(inputDate[1]);
                    elements.remove(removeIndex);
                    break;
                case "Contains":
                    String containsElement = inputDate[1];
                    System.out.println(elements.contains(containsElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(inputDate[1]);
                    int secondIndex = Integer.parseInt(inputDate[2]);
                    elements.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String greaterThenCurrent = inputDate[1];
                    System.out.println(elements.greater(greaterThenCurrent));
                    break;
                case "Max":
                    System.out.println(elements.max());
                    break;
                case "Min":
                    System.out.println( elements.min());
                    break;
                case "Sort":
                    Sorter.sort(elements);
                    break;
                case "Print":
                    elements.forEach();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
