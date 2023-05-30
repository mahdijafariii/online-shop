package com.example.ui;

import com.example.controller.UserController;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import com.example.model.productModel.ProductsModel;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private CustomerModel customerModel ;
    private AdminModel adminModel =AdminModel.getAdmin();
    private UserController userController= new UserController();
    @FXML
    private Button buyButton;

    @FXML
    private TextField count;


    @FXML
    private TextField buyField;

    @FXML
    private ImageView cartImage;

    @FXML
    private TableView<ProductsModel> cartTable;

    @FXML
    private TextField deleteField;

    @FXML
    private Button deleteFromCart;
    @FXML
    private TableView<ProductsModel> productStore;
    @FXML
    private Button backToLogin;


    @FXML
    void buyButtonFunction(ActionEvent event) {
        if(buyField.getText().equals("") || buyField.getText()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("We do not have product with this id in our store!!");
            alert.show();
        }
        else {
            int check = userController.buyProductByID(customerModel, buyField.getText(), adminModel,Integer.parseInt(count.getText()));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            if (check == 1) {
                TranslateTransition transitionCart = new TranslateTransition();
                TranslateTransition transitionField = new TranslateTransition();
                transitionCart.setNode(cartImage);
                transitionCart.setByX(-230);
                transitionCart.setDuration(new Duration(4000));
                transitionCart.setAutoReverse(true);
                transitionField.setNode(buyField);
                transitionField.setDuration(new Duration(4000));
                transitionField.setByY(330);
                transitionField.setAutoReverse(true);
                transitionField.setCycleCount(2);
                transitionCart.setCycleCount(2);
                transitionField.play();
                transitionCart.play();
                buyField.setText(null);
                ObservableList<ProductsModel> data = FXCollections.observableArrayList(customerModel.getCart());
                cartTable.setItems(data);
            } else if (check == -1) {
                alert.setTitle("Error!");
                alert.setContentText("We do not have this volume of this product in our store!!");
                alert.show();
            } else if (check == -2) {
                alert.setTitle("Error!");
                alert.setContentText("We do not have product with this id in our store!!");
                alert.show();
            }
        }
    }


    @FXML
    void deleteFromCartFunc(ActionEvent event) {
        int check =customerModel.getCart().size();
        for(int i = 0 ; i<customerModel.getCart().size() ;i++){
            if(customerModel.getCart().get(i).getProductID().equals(deleteField.getText())){
                customerModel.getCart().remove(i);
                TranslateTransition transitionCart = new TranslateTransition();
                transitionCart.setNode(cartImage);
                transitionCart.setByX(410);
                transitionCart.setDuration(new Duration(4000));
                RotateTransition rotateTransition = new RotateTransition();
                rotateTransition.setByAngle(90);
                rotateTransition.setNode(cartImage);
                rotateTransition.setDuration(new Duration(2000));
                rotateTransition.setAutoReverse(true);
                rotateTransition.setCycleCount(2);
                TranslateTransition transitionCart2 = new TranslateTransition();
                transitionCart2.setNode(cartImage);
                transitionCart2.setByX(-330);
                transitionCart2.setDuration(new Duration(4000));
                SequentialTransition sequentialTransition = new SequentialTransition();
                sequentialTransition.getChildren().add(transitionCart);
                sequentialTransition.getChildren().add(rotateTransition);
                sequentialTransition.getChildren().add(transitionCart2);
                sequentialTransition.play();
                deleteField.setText(null);
                ObservableList<ProductsModel> data= FXCollections.observableArrayList(customerModel.getCart());
                cartTable.setItems(data);
                break;
            }
        }
        if(check==customerModel.getCart().size()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You do not have this product in your cart!!");
            alert.show();
        }

    }
    @FXML
    void backFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("after-login-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Sign up page");
        stage.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerModel=adminModel.getCustomerGui();
        TableColumn<ProductsModel,String> IDColumn=new TableColumn<>("Id");
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductsModel,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ProductsModel,Double> priceColumn=new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ProductsModel,Double> averageColumn=new TableColumn<>("average Score");
        averageColumn.setCellValueFactory(new PropertyValueFactory<>("averageOfScores"));
        cartTable.getColumns().addAll(IDColumn,nameColumn,priceColumn,averageColumn);
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(customerModel.getCart());
        cartTable.setItems(data);



        TableColumn<ProductsModel,String> IDColumn2=new TableColumn<>("Id");
        IDColumn2.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductsModel,String> nameColumn2=new TableColumn<>("Name");
        nameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ProductsModel,Double> priceColumn2=new TableColumn<>("Price");
        priceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ProductsModel,Integer> quantityColumn=new TableColumn<>("amount");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("countInCapacity"));
        TableColumn<ProductsModel,Double> averageColumn2=new TableColumn<>("average Score");
        averageColumn2.setCellValueFactory(new PropertyValueFactory<>("averageOfScores"));
        productStore.getColumns().addAll(IDColumn2,nameColumn2,priceColumn2,quantityColumn,averageColumn2);
        ObservableList<ProductsModel> data2= FXCollections.observableArrayList(adminModel.getProductsOfStore());
        productStore.setItems(data2);

    }
}
