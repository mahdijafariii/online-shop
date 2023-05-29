package com.example.ui;

import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InvoiceController implements Initializable {
    private AdminModel admin = AdminModel.getAdmin();
    private CustomerModel customer;


    @FXML
    private Button backFromInvoice;

    @FXML
    private TextArea invoiceTextField;

    @FXML
    private Label labelTransition;

    @FXML
    void backFromInvoiceController(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("after-login-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(410);
        stage.setY(300);
        stage.setTitle("Login");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        customer=admin.getCustomerGui();
//        StringBuilder string = new StringBuilder();
//        for(int i = 0 ; i<customer.getInvoiceHistory().size() ; i ++){
//            string.append(customer.getInvoiceHistory().get(i).toString());
//            string.append("--------------------------------------------------------");
//        }
//        if(!(string.toString().equals("")|| string.toString()==null)){
//            invoiceTextField.setText(string.toString());
//        }

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(labelTransition);
        transition.setDuration(new Duration(4000));
        transition.setCycleCount(500);
        transition.setByX(1100);
        transition.play();
    }
}
