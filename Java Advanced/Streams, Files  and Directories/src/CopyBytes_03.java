import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String path = ("D:\\Soft_Uni_pops\\Java Advanced\\Streams, Files  and Directories\\input.txt");

        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("out-CopyByte.txt");

        PrintStream out = new PrintStream(fileOutputStream);


        int value = fileInputStream.read();

        while (value != -1) {

            if (value != 10 && value != 32){
                out.print(value);
            }else {
                out.print((char) value);
            }
            value = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}


