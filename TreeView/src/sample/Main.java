package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.collections.FXCollections;


public class Main extends Application {
    Stage window;
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("JavaFX - TreeView");

        TreeItem<String> root, Sonic, Tails;

        //setting up root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Sonic branch
        Sonic = makeBranch("Sonic", root);
        makeBranch("Rings", Sonic);
        makeBranch("Chili Dog", Sonic);
        makeBranch("Chaos Emeralds", Sonic);
        makeBranch("going fast", Sonic);
        //Tails branch
        Tails = makeBranch("Tails", root);
        makeBranch("Inventions", Tails);
        makeBranch("Sonic", Tails);
        makeBranch("Miles", Tails);
        makeBranch("Per Hour", Tails);

        //create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });
        //layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

        // create branches adding items into it
        public TreeItem<String> makeBranch (String title, TreeItem<String> parent) {
            TreeItem<String> item = new TreeItem<>(title);
            item.setExpanded(true);
            parent.getChildren().add(item);
            return item;
        }

        public static void main (String[]args){
            launch(args);
        }
    }


