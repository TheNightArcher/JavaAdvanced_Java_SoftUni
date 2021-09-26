import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        Set<String> parking = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] commandDate = input.split(", ");
            String command = commandDate[0];
            String cars = commandDate[1];

            if (command.equals("IN")) {
                parking.add(cars);
            } else if (command.equals("OUT")) {
                parking.remove(cars);
            }
            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (var car : parking) {
                System.out.println(car);
            }
        }
    }
}
