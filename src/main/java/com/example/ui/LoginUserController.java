package com.example.ui;

import com.example.controller.AdminController;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginUserController implements Initializable {
    CustomerModel customerModel ;
    @FXML
    private PasswordField PasswordLogin;
    @FXML
    private Label labelWelcome;

    @FXML
    private TextField UserNameLogin;

    @FXML
    private Button backFromLoginSystem;

    @FXML
    private Button deleteFieldsOfLoginSystem;

    @FXML
    private Button loginInLoginSystem;

    @FXML
    void backFromLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Online shop!!");
        stage.show();
    }

    @FXML
    void checkUserLoginSystem(ActionEvent event) {
        com.example.controller.AdminController adminController  = new AdminController();
        AdminModel adminModel = AdminModel.getAdmin();
        int check = adminController.checkUserNamePass(UserNameLogin.getText(),PasswordLogin.getText());
        customerModel= adminModel.getAllCostumers().get(check);
    }

    @FXML
    void deleteFieldsOfLoginSystem(ActionEvent event) {
        PasswordLogin.setText(null);
        UserNameLogin.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(labelWelcome);
        transition.setByX(500);
        transition.setDuration(new Duration(4000));
        transition.setCycleCount(500);
        transition.setAutoReverse(true);
        transition.play();
    }
}
