package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application {
    Stage window;
    Scene scene1,scene2;
    @Override
    public void start(Stage primaryStage) throws Exception{
    window = primaryStage;
    Label label1 = new Label("Welcome to the first scene!");
    Button button1 = new Button("Go to scene 2");
    button1.setOnAction(e ->window.setScene(scene2));

    //Layout 1 - note** children are laid out in vertical column
        VBox layout1 = new VBox(50);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1,300,200);

        //Button two
        Button button2 = new Button("You need to go back, back, I mean scene1");
        button2.setOnAction(e ->window.setScene(scene1));

        //layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,600,300);
        window.setScene(scene1);
        window.setTitle("Greetings, Scumlord");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
