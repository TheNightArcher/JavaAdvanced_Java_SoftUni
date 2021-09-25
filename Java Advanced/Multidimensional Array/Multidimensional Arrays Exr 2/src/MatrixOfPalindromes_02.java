import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char firstLetter = 97;

        if (rows > 0 && rows <= 27 && cols > 0 && cols <= 27) {
            for (char i = firstLetter; i < firstLetter + rows; i++) {
                for (char j = i; j < i + cols ; j++) {
                    System.out.printf("%c%c%c ",i,j,i);
                }
                System.out.println();
            }
        }
    }
}
