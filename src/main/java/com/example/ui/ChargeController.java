package com.example.ui;

import com.example.controller.UserController;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChargeController {
    private AdminModel adminModel =AdminModel.getAdmin();
    private CustomerModel customerModel;
    private UserController userController =new UserController();

    @FXML
    private TextField amountField;

    @FXML
    private Button backFromChargeRequest;

    @FXML
    private TextField cardNumberField;

    @FXML
    private PasswordField cvv2Field;

    @FXML
    private Button deleteButton;

    @FXML
    private PasswordField passwordCardField;

    @FXML
    private Button requestButton;

    @FXML
    void RequestButtonField(ActionEvent event) {
       int check=  userController.chargeBalance(customerModel,amountField.getText(),cardNumberField.getText(),cvv2Field.getText(),passwordCardField.getText(),adminModel);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
       if(check==1){
           alert.setTitle("Success!");
           alert.setContentText("Your request was send to admin !!");
           alert.show();
       }
       else if (check==-1){
           alert.setTitle("Error!");
           alert.setContentText("Your card Number is incorrect !!");
           alert.show();
       }
       else if(check==-2){
           alert.setTitle("Error!");
           alert.setContentText("Your CVV2 is incorrect !!");
           alert.show();
       }
       else if(check==-3){
           alert.setTitle("Error!");
           alert.setContentText("Your password is incorrect !!");
           alert.show();
       }

    }

    @FXML
    void backChargeFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("products-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    void deleteButtonFunc(ActionEvent event) {
        passwordCardField.setText(null);
        cvv2Field.setText(null);
        cardNumberField.setText(null);
        amountField.setText(null);
    }

}
