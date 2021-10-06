package SpeedRacing_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());

        Map<String, Car> drivenCars = new LinkedHashMap<>();
        while (carsCount-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelConsumption = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelConsumption);
            drivenCars.putIfAbsent(model, car);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputDate = input.split("\\s+");
            String model = inputDate[1];
            int distance = Integer.parseInt(inputDate[2]);

            Car car = drivenCars.get(model);

            if (!car.requiredFuel(distance)){
                System.out.println("Insufficient fuel for the drive");
            }else {
                drivenCars.put(model,car);
            }
            input = scanner.nextLine();
        }
        drivenCars.values().forEach(System.out::println);
    }
}
