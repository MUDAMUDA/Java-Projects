package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Title of the Window");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        button = new Button("Click me");
        button.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==button){
            System.out.println("You touched my tralala");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
