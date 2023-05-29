package com.example.ui;

import com.example.controller.UserController;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import com.example.model.productModel.ProductsModel;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {
    private CustomerModel customerModel ;
    private AdminModel adminModel = AdminModel.getAdmin();

    @FXML
    private Button backButton;

    @FXML
    private Button saveScoreButton;

    @FXML
    private Text saveScoreSet;

    @FXML
    private Slider scoreValue;

    @FXML
    private TextField textFieldId;
    @FXML
    private TableView<ProductsModel> tableOldPurchases;


    @FXML
    void backButtonFromScoreFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("after-login-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    void saveScoreButtonFunction(ActionEvent event) {
        UserController userController = new UserController();
        int check = userController.setScore(customerModel,scoreValue.getValue(),adminModel,textFieldId.getText());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(check==-1){
            alert.setAlertType(Alert.AlertType.ERROR);
            saveScoreSet.setText(null);
            alert.show();
        }
        else if (check ==-2){
            alert.setAlertType(Alert.AlertType.ERROR);
            saveScoreSet.setText(null);
            alert.show();
        }
        else{
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Score recorded!!");
            alert.setTitle("Success!");
            alert.setHeaderText(null);
            alert.show();
            saveScoreSet.setText("The score was recorded!");
            ObservableList<ProductsModel> data= FXCollections.observableArrayList(customerModel.getPurchaseHistory());
            tableOldPurchases.setItems(data);
        }

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
        tableOldPurchases.getColumns().addAll(IDColumn,nameColumn,priceColumn,averageColumn);
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(customerModel.getPurchaseHistory());
        tableOldPurchases.setItems(data);

    }
}
