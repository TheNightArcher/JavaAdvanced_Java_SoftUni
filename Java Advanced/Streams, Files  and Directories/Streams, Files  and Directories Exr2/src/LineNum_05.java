import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNum_05 {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {


        Path path = Path.of("C:\\Users\\theni\\Desktop\\New folder\\inputLineNumbers.txt");
            String outputPath = "LineNum.txt";
            PrintWriter writer = new PrintWriter(outputPath);

            Files.readAllLines(Path.of(String.valueOf(path)))
                    .forEach(line ->
                            writer.println(countRow++ + ". " + line));


            writer.close();

        }
    }