package Constructors_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        CarConstructors car;
        while (count-- > 0){

            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];
          if (input.length == 1){
              car = new CarConstructors(brand);
          }else {
              String model = input[1];
              int horsePower = Integer.parseInt(input[2]);

              car = new CarConstructors(brand,model,horsePower);

          }
            System.out.printf("The car is: %s %s - %d HP.%n",car.getBrand(),car.getModel(),car.getHorsePower());
        }
    }
}
