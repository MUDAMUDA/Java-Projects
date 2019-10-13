package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;

public class Main extends Application {
    Stage window;
    BorderPane layout;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Pierre");

        //File menu
        Menu fileMenu = new Menu("_File");

        //Menu items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(event -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);


        //fileMenu.getItems().add(new MenuItem("New..."));
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Setting..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        //Edit menu
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(event -> System.out.println("Pasting items"));
        fileMenu.getItems().add(paste);

        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Paste from History..."));
        editMenu.getItems().add(new MenuItem("Paste Simple"));
        editMenu.getItems().add(new MenuItem("Delete"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(new MenuItem("Find"));
        editMenu.getItems().add(new MenuItem("Macros"));
        editMenu.getItems().add(new MenuItem("Column Selection Mode"));

        //Help Menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("hiding line numbers");
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Auto save");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItem
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem Easy = new RadioMenuItem("Easy");
        RadioMenuItem Medium = new RadioMenuItem("Medium");
        RadioMenuItem Hard = new RadioMenuItem("Hard");

        Easy.setToggleGroup(difficultyToggle);
        Medium.setToggleGroup(difficultyToggle);
        Hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(Easy, Medium, Hard);


        //Main Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
