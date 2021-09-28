import java.io.*;

public class WriteEveryThirdLIne_05 {
    public static void main(String[] args) throws IOException {

        String path = ("D:\\Soft_Uni_pops\\Java Advanced\\Streams, Files  and Directories\\input.txt");
        FileInputStream fileInputStream = new FileInputStream(path);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter("out-ThirdLine.txt"));

        String line = reader.readLine();

        int counter = 1;
        while (line != null) {
            if (counter % 3 == 0) {
                bufferedWriter.write(line + System.lineSeparator());
            }
            counter++;
            line = reader.readLine();
        }

        reader.close();
        bufferedWriter.close();
    }
}
