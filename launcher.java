import java.io.*;

public class launcher {
    public static void main(String []args) throws IOException {
        Process p = Runtime.getRuntime().exec("python scriptrunner.py");
        ArduinoInterface.main(args);
        p.destroy();
    }
}
