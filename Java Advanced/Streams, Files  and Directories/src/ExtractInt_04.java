import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractInt_04 {
    public static void main(String[] args) throws FileNotFoundException {

        String path = ("D:\\Soft_Uni_pops\\Java Advanced\\Streams, Files  and Directories\\input.txt");
        FileInputStream fileInputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream("out-ExtractInt.txt");
        PrintStream out = new PrintStream(fileOutputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                out.println(number);
            }
            scanner.next();
        }
    }
}
