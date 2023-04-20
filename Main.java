import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
Button button, waterButton, sunButton, soilButton;
Scene scene, scene1;


public static void main(String[] args){
    launch(args); 
}
@Override
public void start (Stage primaryStage) throws Exception{
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10,100,10,100));
    grid.setVgap(8);
    grid.setHgap(10);
    //Menu
    Label userLabel = new Label("Weclome to our Arduino Project!");
    Button submitButton = new Button("Click here to start");
    Label label1 = new Label();

    HBox hBox = new HBox(100, userLabel);
    VBox vBox = new VBox(100,hBox, submitButton, label1);
    hBox.setAlignment(Pos.TOP_CENTER);
    vBox.setAlignment(Pos.CENTER);
    vBox.setPadding(new Insets(10));
    submitButton.setOnAction(e->primaryStage.setScene(scene1));
    

    //2nd scence
    GridPane gridTwo = new GridPane();
    gridTwo.setPadding(new Insets(10,100,10,100));
    gridTwo.setVgap(8);
    gridTwo.setHgap(10);
    //labels
    Label labelTwo = new Label("Here are the options!");
    Label labelWater = new Label("Water Sensor");
    Label labelSun = new Label("Sun Sensor");
    Label labelSoil = new Label("Soil Sensor");
    
    Button waterButton = new Button("Analyze");
    waterButton.setOnAction(event -> {
        File file = new File("water.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            TextArea textArea = new TextArea();
            textArea.setText(content.toString());
            // Add the text area to your GUI layout as appropriate
        } catch (IOException e) {
            // Handle any exceptions that may occur when reading the file
        }
    });





    Button sunButton = new Button("Analyze");
    Button soilButton = new Button("Analyze");


    HBox hbox1 = new HBox(100, labelTwo);
    HBox hbox2 = new HBox(190, labelWater,labelSun,labelSoil);
    HBox buttonBox = new HBox(200, waterButton, sunButton, soilButton);
    hbox1.setAlignment(Pos.TOP_CENTER);
    
    VBox vbox1 = new VBox(20, hbox1,hbox2,buttonBox);

    //gridTwo.getChildren().addAll(labelTwo,waterButton);
    scene1 = new Scene(vbox1,700,400);
    

   
    




    Scene scene = new Scene(vBox);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Arduino Project");
    primaryStage.show();



}
    

// }
// public void start(Stage primaryStage) throws Exception{
//     Group root = new Group();
//     Scene scene = new Scene(root, Color.LIGHTBLUE);

//     primaryStage.setTitle("Arduino Sensor");
    
//     primaryStage.setScene(scene);
//     primaryStage.show();

//     Text text = new Text();
//     text.setText(STYLESHEET_CASPIAN);

// }
}