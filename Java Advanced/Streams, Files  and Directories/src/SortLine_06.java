import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLine_06 {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\Soft_Uni_pops\\Java Advanced\\Streams, Files  and Directories\\input.txt");

        List<String> lines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("out-SortLine.txt"),lines);
    }
}
