package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    //boolean variable to store the answers
    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);// block user interactions until this is complete.
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        // create two buttons
        Button YesButton = new Button("yes");
        Button NoButton = new Button("no");
        YesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        NoButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,YesButton,NoButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}