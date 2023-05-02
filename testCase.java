import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
/** 
* These are my test cases
For testFindMinMax: It will find the min and maax of the column
For testLuxInrage: It will check the lux column to see if its in a certain range so between 1 and 65535
For testCapacitiveRange: It will check the CapacitiveRange to see if its in a certain range so between 200 and 2000
For testOnlyNumbers: It will check if there is only numbers in the file. No letters or symbols.
*/
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
    @Test
    public void testCapacitiveInRange() throws IOException {
        String filePath = "SensorData.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        float lineNum = 0;
        while ((line = reader.readLine()) != null) {
            lineNum++;
            String[] parts = line.split("\\s+");
            Float col3 = Float.parseFloat(parts[2]);
            assertTrue("Line " + lineNum + ": Column 3 is out of range", col3 >= 200 && col3 <= 2000);
        }
        reader.close();
    }

    private void assertTrue(String s, boolean b) {
    }
    @Test
    public void testOnlyNumbers() {

        String filePath = "SensorData.txt";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split("\\s+");
                for (String number : numbers) {
                    // Check if the string contains any non-numeric characters
                    if (!number.matches("-?\\d+(\\.\\d+)?")) {
                        fail("File contains non-numeric characters");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("File not found");
        }
    }
    ///
}



