import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class testCase {
    
    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("SensorData.txt"))) {
            
            String line;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                double num = Double.parseDouble(values[1]);
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
            
            System.out.println("Minimum of column 2: " + min);
            System.out.println("Maximum of column 2: " + max);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}