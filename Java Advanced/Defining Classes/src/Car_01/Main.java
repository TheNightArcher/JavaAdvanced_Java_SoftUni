package Car_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Car car;
        while (count-- > 0) {

            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);
            car = new Car(brand, model, horsePower);

            System.out.printf("The car is: %s %s - %d HP.%n",car.getBrand(),car.getModel(),car.getHorsePower());
        }
    }
}
