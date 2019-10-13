package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;
import javafx.collections.FXCollections;
import javafx.scene.layout.VBox;


public class Main extends Application {
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Simple Table");

        //name column
        TableColumn<Product,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product,Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMaxWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity
        TableColumn<Product,Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMaxWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        //priceInput.setMinWidth(100);

        //Quantity input
        quantityInput= new TextField();
        quantityInput.setPromptText("quantity");
        //quantityInput.setMinWidth(100);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);



        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table,hBox);


        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();



        }
        //AddButton Method
    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

        //DeleteButton Method
        public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
        }



    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop",859.00,20));
        products.add(new Product("bouncy ball",2.00,22));
        products.add(new Product("toilet",150.00,200));
        products.add(new Product("dildo",100.00,20));
        products.add(new Product("tricycle",1.00,250));
        return products;
    }


}



