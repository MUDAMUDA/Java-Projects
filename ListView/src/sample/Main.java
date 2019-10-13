package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("devil fruits");
        button = new Button("Submit");
        listView = new ListView<>();
        listView.getItems().addAll("Gum Gum","Chop Chop","Ito Ito","Mera Mera","Mochi Mochi");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView,button);

        scene = new Scene(layout,300,200);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked(){
       String message = "";
       ObservableList<String> movies;
       movies = listView.getSelectionModel().getSelectedItems();

       for(String m: movies){
           message += m +"\n";
       }
        System.out.println(message);

    }

}
