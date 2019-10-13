package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class Main extends Application {
    Stage window;
    Button button;

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("PeePee World");

       Person peter = new Person();

       peter.firstNameProperty().addListener( (v, oldValue,newValue) -> {
           System.out.println("Name changed to " + newValue);
           System.out.println("firstNameProperty():" + peter.firstNameProperty());
           System.out.println("getFirstName()" + peter.getFirstName());
       } );

        button = new Button("Submit");
        button.setOnAction(e -> peter.setFirstName("Cunt_Slayer"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }


}
