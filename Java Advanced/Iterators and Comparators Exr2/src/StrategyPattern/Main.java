package StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<Person> nameSet = new TreeSet<>(new CompareName());
        Set<Person> ageSet = new TreeSet<>(new CompareAge());

        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            ageSet.add(person);
            nameSet.add(person);
        }
        for (Person byName : nameSet) {
            System.out.println(byName);
        }
        for (Person byAge : ageSet) {
            System.out.println(byAge);
        }
    }
}
