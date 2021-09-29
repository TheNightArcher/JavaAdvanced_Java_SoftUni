import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\theni\\Desktop\\New folder\\input.txt";

        Files.readAllLines(Path.of(path)).stream()
                .map(String::toCharArray)
                .forEach(c -> {

                    int sum = 0;

                    for (var word : c) {

                        sum += word;
                    }

                    System.out.println(sum);
                });
    }
}
