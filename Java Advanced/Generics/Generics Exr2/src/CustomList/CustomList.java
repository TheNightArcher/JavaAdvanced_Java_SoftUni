package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void remove(int element) {
        this.elements.remove(element);
    }

    public boolean contains(T element) {
        if (elements.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap(int first, int second) {
        Collections.swap(elements, first, second);
    }

    public int greater(T element) {
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T max() {
        return elements.stream().max(Comparable::compareTo).get();
    }

    public T min() {
        return elements.stream().min(Comparable::compareTo).get();
    }

    public void forEach() {
        elements.forEach(System.out::println);
    }

    public int size() {
        return elements.size();
    }

    public T get(int index) {
        return elements.get(index);
    }

}
