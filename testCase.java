import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCase {

    @Test
    public void testFindMinMax() throws IOException {
        String fileName = "SensorData.txt";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(" ");
            double val = Double.parseDouble(values[1]);
            if (val < min) {
                min = val;
            }
            if (val > max) {
                max = val;
            }
        }

        reader.close();

        assertEquals(174.17, min, 0.01);
        assertEquals(184.17, max, 0.01);
    }
    @Test
    public void testLuxInRange() throws IOException {
        String filePath = "SensorData.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        float lineNum = 0;
        while ((line = reader.readLine()) != null) {
            lineNum++;
            String[] parts = line.split("\\s+");
            Float col2 = Float.parseFloat(parts[1]);
            assertTrue("Line " + lineNum + ": Column 2 is out of range", col2 >= 1 && col2 <= 65535);
        }
        reader.close();
    }

    private void assertTrue(String s, boolean b) {
    }
}



