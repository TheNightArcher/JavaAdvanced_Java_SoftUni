package GenericScale_03;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(13, 25);

        System.out.println(scale.getHeavier());
        System.out.println(getGreater(12, 22));
        System.out.println(getGreater("75", "56"));
        System.out.println(new Scale<>("A", "Z").getHeavier());
        System.out.println(new Scale<>(0,0).getHeavier());
    }

    public static <T extends Comparable<T>> T getGreater(T first, T second) {
        int result = first.compareTo(second);

        return result >= 0 ? first : second;
    }
}
