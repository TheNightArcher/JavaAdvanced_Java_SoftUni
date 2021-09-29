import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class ALLCAPITALS_03 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\theni\\Desktop\\New folder\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        Files.readAllLines(Path.of(path)).forEach(words -> {

            try {
                writer.write(words.toUpperCase(Locale.ROOT));
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();
    }
}
