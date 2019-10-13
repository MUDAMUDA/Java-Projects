
import com.sun.deploy.xml.XMLable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.*;


public class AlertBox {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);// block user interactions until this is complete.
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the fucking window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
