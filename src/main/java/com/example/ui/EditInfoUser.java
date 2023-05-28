package com.example.ui;

import com.example.controller.UserController;
import com.example.exception.InvalidFormatEmailException;
import com.example.exception.InvalidFormatPhoneNumberException;
import com.example.exception.InvalidInputException;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditInfoUser implements Initializable {
    private AdminModel adminModel = AdminModel.getAdmin();
    private CustomerModel customerModel ;
    private UserController userController  =new UserController();
    @FXML
    private Button backToLogin;

    @FXML
    private Button checkEmail;

    @FXML
    private Button checkFullName;

    @FXML
    private Button checkPassword;

    @FXML
    private Button checkPhoneNumber;

    @FXML
    private Text email;

    @FXML
    private Text fullName;

    @FXML
    private Text number;

    @FXML
    private Text password;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private Text userName;

    @FXML
    void backToLoginFunction(ActionEvent event) throws IOException {
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
    void checkEmailFunction(ActionEvent event) {
        try{
            userController.changeEmail(customerModel,customerModel.getUserName(),customerModel.getPassword(),textFieldEmail.getText());
        }
        catch (InvalidFormatEmailException i){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(i.getMessage());
            alert.show();
        }
        email.setText(customerModel.getEmail());
    }

    @FXML
    void checkFullNameFunction(ActionEvent event) {
        userController.changeName(customerModel,customerModel.getUserName(),customerModel.getPassword(),textFieldName.getText());
        fullName.setText(customerModel.getFullName());
    }

    @FXML
    void checkPasswordFunction(ActionEvent event) {
        try{
            userController.changePassword(customerModel,customerModel.getUserName(),customerModel.getPassword(),textFieldPassword.getText());
        }
        catch (InvalidInputException i){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(i.getMessage());
            alert.show();
        }
        password.setText(customerModel.getPassword());
    }

    @FXML
    void checkPhoneNumberFunction(ActionEvent event) {
        try{
            userController.changePhoneNumber(customerModel,customerModel.getUserName(),customerModel.getPassword(),textFieldPhoneNumber.getText());
        }
        catch (InvalidFormatPhoneNumberException i){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(i.getMessage());
            alert.show();
        }
        number.setText(customerModel.getPhoneNumber());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerModel=adminModel.getCustomerGui();
        fullName.setText(customerModel.getFullName());
        userName.setText(customerModel.getUserName());
        number.setText(customerModel.getPhoneNumber());
        email.setText(customerModel.getEmail());
        password.setText(customerModel.getPassword());

    }
}
