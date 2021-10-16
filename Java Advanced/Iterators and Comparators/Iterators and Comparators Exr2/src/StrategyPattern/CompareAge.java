package StrategyPattern;

import java.util.Comparator;

public class CompareAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getAge(),o2.getAge());
        return result;
    }
}
