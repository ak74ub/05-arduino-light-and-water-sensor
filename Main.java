import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Main extends Application {
Button button;
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
    vBox.setAlignment(Pos.CENTER);
    vBox.setPadding(new Insets(10));
    submitButton.setOnAction(e->primaryStage.setScene(scene1));


    Scene scene = new Scene(vBox);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Arduino Project");
    primaryStage.show();
    scene1 = new Scene(grid,700,400);



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