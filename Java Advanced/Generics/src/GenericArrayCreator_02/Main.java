package GenericArrayCreator_02;

public class Main {
    public static void main(String[] args) {


        Integer[] integers = ArrayCreator.create(10,13);


        String[] strings = ArrayCreator.create(String.class,3,"Java");

        for (Integer integer : integers) {
            System.out.println(integer);
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
