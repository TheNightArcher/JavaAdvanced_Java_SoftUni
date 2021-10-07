package RawDate_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());

        Set<String> fragile = new LinkedHashSet<>();
        Set<String> flamable = new LinkedHashSet<>();
        List<Car> allCars = new ArrayList<>();

        while (countCars-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            int enginePower = Integer.parseInt(input[2]);
            String carGO = input[4];
            double tirePressure1 = Double.parseDouble(input[5]);
            double tirePressure2 = Double.parseDouble(input[7]);
            double tirePressure3 = Double.parseDouble(input[9]);
            double tirePressure4 = Double.parseDouble(input[11]);

            Car car = new Car(model, enginePower, carGO, tirePressure1, tirePressure2, tirePressure3, tirePressure4);
            allCars.add(car);
        }
        String typeCar = scanner.nextLine();

        if (typeCar.equals("fragile")) {
            for (Car car : allCars) {

                if (car.getCarGoType().equals("fragile") && car.getTirePressure1() < 1.0 || car.getTirePressure2() < 1.0 || car.getTirePressure3() < 1.0 || car.getTirePressure4() < 1.0){
                    fragile.add(car.getModel());
                }
            }
            fragile.forEach(System.out::println);
        }else if (typeCar.equals("flamable")){
            for ( Car car : allCars) {

                if (car.getCarGoType().equals("flamable") && car.getEnginePower() > 250){
                    flamable.add(car.getModel());
                }
            }
            flamable.forEach(System.out::println);
        }
    }
}
