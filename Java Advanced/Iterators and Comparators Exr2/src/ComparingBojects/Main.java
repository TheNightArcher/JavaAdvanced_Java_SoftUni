package ComparingBojects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Person> peoples = new ArrayList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String town = tokens[2];

                peoples.add(new Person(name,age,town));

            input = scanner.nextLine();
        }
        int comparePeron = Integer.parseInt(scanner.nextLine());
        Person otherPerson = peoples.remove(comparePeron -1);

        int samePeople = 0;
        int diffPeople = 0;

        for (Person person : peoples) {
            if (person.compareTo(otherPerson) == 0){
                samePeople++;
            }else {
                diffPeople++;
            }
        }

        int totalPeoples = peoples.size() + 1;
        if (samePeople == 0){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d% d",++samePeople,diffPeople,totalPeoples);
        }
    }
}
