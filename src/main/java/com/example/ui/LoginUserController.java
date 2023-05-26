package com.example.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginUserController {
    @FXML
    private PasswordField PasswordLogin;

    @FXML
    private TextField UserNameLogin;

    @FXML
    private Button backFromLoginSystem;

    @FXML
    private Button deleteFieldsOfLoginSystem;

    @FXML
    private Button loginInLoginSystem;

    @FXML
    void backFromLogin(ActionEvent event) {

    }

    @FXML
    void checkUserLoginSystem(ActionEvent event) {

    }

    @FXML
    void deleteFieldsOfLoginSystem(ActionEvent event) {
        PasswordLogin.setText(null);
        UserNameLogin.setText(null);
    }
}
