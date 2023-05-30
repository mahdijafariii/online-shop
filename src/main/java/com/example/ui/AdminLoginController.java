package com.example.ui;

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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminLoginController  {

    @FXML
    private Button backLoginAdmin;

    @FXML
    private Button delete;
    @FXML
    private TextField nameCheckAdmin;
    @FXML
    private Label labelAlertAdmin;


    @FXML
    private PasswordField passwordCheckAdmin;


    @FXML
    private Label nameAdminField;

    @FXML
    private Label passwordAdminField;

    @FXML
    private Button save;

    @FXML
    void BackMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Online Shop!!");
        stage.show();

    }

    @FXML
    void checkInfoSave(ActionEvent event) throws IOException {
        if(nameCheckAdmin.getText().equals("") || nameCheckAdmin.getText()==null){
            labelAlertAdmin.setText("The name can not be empty!!!");
        }
        else if(passwordCheckAdmin.getText().equals("") || passwordCheckAdmin.getText()==null){
            labelAlertAdmin.setText(null);
            labelAlertAdmin.setText("The password can not be empty !!!");
        }
        else if(nameCheckAdmin.getText().equals("admin") && passwordCheckAdmin.getText().equals("admin")){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin-view.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
            stage.setX(500);
            stage.setY(200);
            stage.setTitle("Admin Page!!");
            stage.show();
        }


    }

    @FXML
    void deleteFields(ActionEvent event) {
        labelAlertAdmin.setText(null);
        passwordCheckAdmin.setText(null);
        nameCheckAdmin.setText(null);

    }


}
