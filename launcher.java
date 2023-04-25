import java.io.*;

public class launcher {
    public static void main(String []args) throws IOException {
        Runtime.getRuntime().exec("python scriptrunner.py");
        ArduinoInterface.main(args);
    }
}
