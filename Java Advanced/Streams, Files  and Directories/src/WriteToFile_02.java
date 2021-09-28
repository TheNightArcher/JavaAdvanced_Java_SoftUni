import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {

        String path = ("D:\\Soft_Uni_pops\\Java Advanced\\Streams, Files  and Directories\\input.txt");

        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream("out.txt");

        Set<Character> punctuations = Set.of(',', '.', '!', '?');

        int value = fileInputStream.read();

        while (value != -1) {
            char current = (char) value;
            if (!punctuations.contains(current)) {
                out.write(current);
            }

            value = fileInputStream.read();
        }
    }
}
