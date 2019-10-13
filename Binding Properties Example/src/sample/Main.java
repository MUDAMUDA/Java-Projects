package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {

    Stage window;

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("The Pierre");

        //Inputs and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();
        HBox bottomText = new HBox(firstLabel,secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10,userInput,bottomText);
        vbox.setAlignment(Pos.CENTER);
        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene = new Scene(vbox,300,200);
        window.setScene(scene);
        window.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
