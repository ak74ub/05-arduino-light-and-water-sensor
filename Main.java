import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Main extends Application {
Button button;

public static void main(String[] args){
    launch(args); 
}

public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("Water, Light, and Soil Sensor");
    Label welcome = new Label("Welcome to our group project");
    welcome.relocate(10, 20);

    button = new Button();
    button.setText("Analyze");

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    layout.getChildren().add(welcome);
    
    

    Scene scene = new Scene(layout,600,400);
    primaryStage.setScene(scene);
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