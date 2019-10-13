package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.swing.*;

public class Main2 extends Application {
    Stage window;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    {
    }
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("A tune that often plays");

        button = new Button("Please click me");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of Window", "This is a tune that often plays!");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }



}


