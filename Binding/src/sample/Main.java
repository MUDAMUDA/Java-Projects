package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {
    Stage window;
    Button button;
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Binding_Project");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();
        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");

        button = new Button("Submit");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
