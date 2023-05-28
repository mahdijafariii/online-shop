package com.example.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.example.model.accountModel.AdminModel;
import com.example.model.productModel.ProductsModel;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private TableView<ProductsModel> tableView = new TableView<>();
    @FXML
    private Button backLogin;



    @FXML
    void backFromLoginToOnlineShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Online shop!!");
        stage.show();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AdminModel adminModel = AdminModel.getAdmin();
        TableColumn<ProductsModel,String> IDColumn=new TableColumn<>("Id");
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductsModel,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ProductsModel,Double> priceColumn=new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ProductsModel,Integer> quantityColumn=new TableColumn<>("amount");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("countInCapacity"));
        TableColumn<ProductsModel,Double> averageColumn=new TableColumn<>("average Score");
        averageColumn.setCellValueFactory(new PropertyValueFactory<>("averageOfScores"));
        tableView.getColumns().addAll(IDColumn,nameColumn,priceColumn,quantityColumn,averageColumn);
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(adminModel.getProductsOfStore());
        tableView.setItems(data);
        tableView.set



    }
}
