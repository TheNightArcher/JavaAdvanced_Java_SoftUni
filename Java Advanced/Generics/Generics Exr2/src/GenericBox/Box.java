package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {

    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstElement, int secondElement) {
        T tempElement = elements.get(firstElement);

        elements.set(firstElement, elements.get(secondElement));
        elements.set(secondElement, tempElement);

    }

    public int countGreaterElements(T element) {
        return (int) elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
