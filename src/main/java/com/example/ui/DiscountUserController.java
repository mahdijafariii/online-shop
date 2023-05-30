package com.example.ui;

import com.example.controller.UserController;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DiscountUserController implements Initializable {
    private CustomerModel customerModel;
    private AdminModel admin = AdminModel.getAdmin();
    private UserController userController= new UserController();



    @FXML
    private Button backFromDiscount;

    @FXML
    private TextArea labelDiscount;

    @FXML
    void backFromDiscountFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("after-login-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Login");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerModel = admin.getCustomerGui();
        labelDiscount.setText(userController.showDiscounts(customerModel));
    }
}
