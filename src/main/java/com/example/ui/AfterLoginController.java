package com.example.ui;

import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AfterLoginController implements Initializable {
    private AdminModel adminModel = AdminModel.getAdmin();
    private CustomerModel customer ;
    @FXML
    private Text balanceField;

    @FXML
    private Button cartButton;

    @FXML
    private Button chargeButton;

    @FXML
    private Button commentButton;

    @FXML
    private Button editInfoButton;

    @FXML
    private Button finalizeBuyButton;

    @FXML
    private Text nameField;

    @FXML
    private Text numberField;

    @FXML
    private Button productButton;

    @FXML
    private Button scoreButton;

    @FXML
    private Text userNameField;

    @FXML
    void chargeButtonFunction(ActionEvent event) {

    }

    @FXML
    void commentButton(ActionEvent event) {

    }

    @FXML
    void cartButton(ActionEvent event) {

    }

    @FXML
    void editInfoButtonFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit-info-user.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Edit info!!");
        stage.show();
    }

    @FXML
    void finalizeBuyButtonFunction(ActionEvent event) {

    }

    @FXML
    void productButtonFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("after-login-product-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Product");
        stage.show();

    }

    @FXML
    void scoreButtonFunction(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        customer = adminModel.getCustomerGui();
        System.out.println(customer.toString());
        nameField.setText(customer.getFullName());
        userNameField.setText(customer.getUserName());
        numberField.setText(customer.getPhoneNumber());
        balanceField.setText(String.valueOf(customer.getBalance()));

    }
}
