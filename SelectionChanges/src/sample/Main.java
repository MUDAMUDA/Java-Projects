package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("ChoiceBox Demo");
        button = new Button("Click me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().add("grapes");
        choiceBox.getItems().add("cherry");
        choiceBox.getItems().addAll("watermelons", "pineapples", "Lemons");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
