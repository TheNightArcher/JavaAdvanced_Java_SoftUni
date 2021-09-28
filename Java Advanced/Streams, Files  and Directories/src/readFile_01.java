import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readFile_01 {
    public static void main(String[] args) throws IOException {

        String path = ("D:\\Soft_Uni_pops\\Java Advanced\\Streams, Files  and Directories\\input.txt");

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int value = inputStream.read();

            while (value != -1) {
                System.out.print(Integer.toBinaryString(value) + " ");
                value = inputStream.read();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
