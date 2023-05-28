package com.example.ui;

import com.example.controller.UserController;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.example.model.accountModel.AdminModel;
import com.example.model.productModel.ProductsModel;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private Button backLogin;

    @FXML
    private Button checkSpecialProduct;

    @FXML
    private ImageView imageSearch;

    @FXML
    private TextArea labelInfoProducts;

    @FXML
    private TextField seeInfoProduct;

    @FXML
    private TableView<ProductsModel> tableView;



    @FXML
    void checkSpecialProduct(ActionEvent event) {
        UserController userController = new UserController();
        AdminModel adminModel = AdminModel.getAdmin();
        String check = userController.searchExactInProduct(adminModel.getProductsOfStore(),seeInfoProduct.getText());
        if(check.equals("-")){
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(seeInfoProduct);
            transition.setByX(3);
            transition.setDuration(new Duration(50));
            TranslateTransition transition1 = new TranslateTransition();
            transition1.setNode(seeInfoProduct);
            transition1.setByY(3);
            transition1.setDuration(new Duration(50));
            TranslateTransition transition2 = new TranslateTransition();
            transition2.setNode(seeInfoProduct);
            transition2.setByX(-3);
            transition2.setDuration(new Duration(50));
            TranslateTransition transition3 = new TranslateTransition();
            transition3.setNode(seeInfoProduct);
            transition3.setByY(-3);
            transition3.setDuration(new Duration(50));
            RotateTransition rotateTransition = new RotateTransition();
            rotateTransition.setNode(checkSpecialProduct);
            rotateTransition.setByAngle(360);
            rotateTransition.setDuration(new Duration(50));
            rotateTransition.play();
            SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().add(transition);
            sequentialTransition.getChildren().add(transition1);
            sequentialTransition.getChildren().add(transition2);
            sequentialTransition.getChildren().add(transition3);
            sequentialTransition.play();
        }
        else {
            labelInfoProducts.setText(check);
        }


    }



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




    }
}
