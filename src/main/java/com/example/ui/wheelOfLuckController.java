package com.example.ui;

import com.example.controller.AdminController;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import com.example.model.accountModel.DiscountCode;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class wheelOfLuckController implements Initializable {
    @FXML
    private Button backFromWheelLuck;
    private CustomerModel customerModel ;
    private AdminModel adminModel = AdminModel.getAdmin();
    private com.example.controller.AdminController adminController = new AdminController();

    @FXML
    private TextField balance;

    @FXML
    private Button rotateButton;

    @FXML
    private PieChart wheel;

    @FXML
    void backFromWheelLuckFunc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("after-login-controller.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(400);
        stage.setY(100);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    void rotateButtonFunc(ActionEvent event) {

        Random random = new Random();
        int check =random.nextInt(100)+1;
        if(customerModel.getBalance()>100000){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            customerModel.setBalance(customerModel.getBalance()-100000);
            if(check<=15){
                DiscountCode discountCode = new DiscountCode(15,new Date(5000,12,30),1);
                adminModel.getDiscountCodes().add(discountCode);
                customerModel.getDiscountCodes().add(discountCode);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Huuuraa");
                alert.setContentText("You wonnnn 15 percent Discount !! your discount is in your discounts!!!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));


            }
            else if (15<check && check<=25){
                alert.setTitle("Ohhh!!");
                alert.setContentText("You didn't win  :(  if you want try your luck again!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));

            }
            else if (25<check && check<=30){
                DiscountCode discountCode = new DiscountCode(30,new Date(5000,12,30),1);
                adminModel.getDiscountCodes().add(discountCode);
                customerModel.getDiscountCodes().add(discountCode);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Huuuraa");
                alert.setContentText("You wonnnn 30 percent Discount !! your discount is in your discounts!!!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));

            }
            else if (30<check && check<=40){
                alert.setTitle("Ohhh!!");
                alert.setContentText("You didn't win  :(  if you want try your luck again!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));


            }
            else if (40<check && check<=50){
                DiscountCode discountCode = new DiscountCode(10,new Date(5000,12,30),1);
                adminModel.getDiscountCodes().add(discountCode);
                customerModel.getDiscountCodes().add(discountCode);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Huuuraa");
                alert.setContentText("You wonnnn 10 percent Discount !! your discount is in your discounts!!!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));

            }
            else if (50<check && check<=60){
                alert.setTitle("Ohhh!!");
                alert.setContentText("You didn't win  :(  if you want try your luck again!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));



            }
            else if (60<check && check<=90){
                DiscountCode discountCode = new DiscountCode(5,new Date(5000,12,30),1);
                adminModel.getDiscountCodes().add(discountCode);
                customerModel.getDiscountCodes().add(discountCode);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Huuuraa");
                alert.setContentText("You wonnnn 5 percent Discount !! your discount is in your discounts!!!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));

            }
            else if (90<check && check<=100){
                alert.setTitle("Ohhh!!");
                alert.setContentText("You didn't win  :(  if you want try your luck again!");
                alert.show();
                balance.setText(String.valueOf(customerModel.getBalance()));

            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough money!!!");
            alert.show();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        customerModel = adminModel.getCustomerGui();
        PieChart.Data percent20 =new PieChart.Data("Percent 5",30);
        PieChart.Data percent5 =new PieChart.Data("Percent 30",5);
        PieChart.Data percent15 =new PieChart.Data("Percent 15",15);
        PieChart.Data percent10 =new PieChart.Data("Percent 10",10);
        PieChart.Data empty =new PieChart.Data("Empty",10);
        PieChart.Data empty2 =new PieChart.Data("Empty",10);
        PieChart.Data empty3 =new PieChart.Data("Empty",10);
        PieChart.Data empty4 =new PieChart.Data("Empty",10);
        wheel.getData().add(percent5);
        wheel.getData().add(empty2);
        wheel.getData().add(percent10);
        wheel.getData().add(empty3);
        wheel.getData().add(percent20);
        wheel.getData().add(empty4);
        wheel.getData().add(percent15);
        wheel.getData().add(empty);
        wheel.setLegendVisible(false);

        balance.setText(String.valueOf(customerModel.getBalance()));






    }
}
