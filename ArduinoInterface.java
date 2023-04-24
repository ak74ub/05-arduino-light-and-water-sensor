package com.example.arduinointerface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import java.text.DecimalFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;


public class ArduinoInterface extends Application {

    private TextArea  textArea2, textArea3;

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a Label and add it to the GridPane
        Label label2 = new Label("Welcome to our Software Design Project!");
        gridPane.add(label2, 0, 2);

        // Create a Label and add it to the GridPane
        Label label3 = new Label("Data Value:");
        gridPane.add(label3, 0, 4);

        // Create a TextArea for file 3 and add it to the GridPane
        textArea3 = new TextArea();
        gridPane.add(textArea3, 0, 5, 3, 1);

        // // Create a Button to read the contents of soil
        // Button button2 = new Button("Soil moisture");
        // button2.setOnAction(event -> readFile("file2.txt", textArea2));
        // gridPane.add(button2, 1, 6);

        // Create a Button to read the contents of Sun
        Button button3 = new Button("Analyze Data");
        button3.setOnAction(event -> findColumnAverages("SensorData.txt", textArea3));
        gridPane.add(button3, 0, 6);

        // Create a Scene and display it on the Stage
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void readFile(String filename, TextArea textArea) {
        // Read the contents of the specified file
        try {
            String fileContents = new String(Files.readAllBytes(new File(filename).toPath()));
            // Set the contents of the TextArea
            textArea.setText(fileContents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void findAverage(String filename, TextArea textArea) {
        try {
            // Read the lines from the specified file
            Stream<String> lines = Files.lines(new File(filename).toPath());

            // Split each line into an array of numbers
            double[][] numbers = lines.map(line -> {
                String[] tokens = line.split("\\s+");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                return row;
            }).toArray(double[][]::new);

            // Calculate the average of each row and display it in the TextArea
            for (double[] row : numbers) {
                double sum = Arrays.stream(row).sum();
                double average = sum / row.length;
                textArea.appendText(String.format("Average: %.2f\n", average));
            }

            // Close the stream
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void findColumnAverages(String filename, TextArea textArea) {
        try {
            // Read the contents of the specified file
            List<String> lines = Files.readAllLines(new File(filename).toPath());

            // Parse each line as an array of doubles and calculate the column-wise average
            double[] sums = new double[3];
            for (String line : lines) {
                double[] numbers = Arrays.stream(line.split("\\s+")).mapToDouble(Double::parseDouble).toArray();
                for (int i = 0; i < numbers.length; i++) {
                    sums[i] += numbers[i];
                }
            }
            double[] averages = new double[3];
            for (int i = 0; i < averages.length; i++) {
                averages[i] = sums[i] / lines.size();
            }

            // Format the averages to 5 significant figures
            DecimalFormat df = new DecimalFormat("#.###");
            String tempAvg = df.format(averages[0]);
            String luxAvg = df.format(averages[1]);
            String voltageAvg = df.format(averages[2]);

            // Display the column-wise averages in the TextArea
            textArea.setText("Average Temperature: " + tempAvg + "\n" +
                    "----------------------------------------------------------------"+"\n"+
                    "Average Lux: " + luxAvg + "\n" +
                    "----------------------------------------------------------------"+"\n"+
                    "Average Voltage Capacity: " + voltageAvg);

            // Check if the soil is wet or dry based on the average voltage capacity
            if (averages[2] > 500) {
                textArea.appendText("\nSoil Status: The soil is wet"+"\n"+"----------------------------------------------------------------");
            } else {
                textArea.appendText("\nSoil Status: The soil is dry"+"\n"+"----------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
