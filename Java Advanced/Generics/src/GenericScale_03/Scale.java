package GenericScale_03;

public class Scale<T extends Comparable<T>> {

    public final T left;
    public final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int compered = left.compareTo(right);

        if (compered > 0) {
            return left;
        } else if (compered < 0) {
            return right;
        }
        return null;
    }
}
