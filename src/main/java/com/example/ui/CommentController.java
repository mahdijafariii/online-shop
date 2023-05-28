package com.example.ui;

import com.example.controller.AdminController;
import com.example.controller.ProductController;
import com.example.controller.UserController;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CommentController implements Initializable {
    private CustomerModel customerModel;
    @FXML
    private Button backFromComment;

    @FXML
    private TextField checkProductInput;


    @FXML
    private Button deleteStringComment;

    @FXML
    private ImageView imageComment;

    @FXML
    private Button saveComment;

    @FXML
    private TextArea showProductInfo;

    @FXML
    private TextField stringComment;
    @FXML
    void backFromCommentFunc(ActionEvent event) throws IOException {
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
    void checkProductFunc(ActionEvent event) {
        ProductController productController = new ProductController();
        String test =productController.showProductInfo(checkProductInput.getText());
        if(test.equals("-")){
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(checkProductInput);
            transition.setDuration(new Duration(50));
            transition.setByX(5);
            TranslateTransition transition2 = new TranslateTransition();
            transition2.setNode(checkProductInput);
            transition2.setDuration(new Duration(50));
            transition2.setByX(-5);
            TranslateTransition transition3 = new TranslateTransition();
            transition3.setNode(checkProductInput);
            transition3.setDuration(new Duration(50));
            transition3.setByY(-5);
            TranslateTransition transition1 = new TranslateTransition();
            transition1.setNode(checkProductInput);
            transition1.setDuration(new Duration(50));
            transition1.setByY(5);
            SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().add(transition1);
            sequentialTransition.getChildren().add(transition);
            sequentialTransition.getChildren().add(transition3);
            sequentialTransition.getChildren().add(transition2);
            sequentialTransition.play();
        }
        else {
            showProductInfo.setText(test);
        }

    }

    @FXML
    void deleteStringComment(ActionEvent event) {
        stringComment.setText(null);
    }

    @FXML
    void saveCommentFunc(ActionEvent event) {
        UserController userController = new UserController();
        AdminModel admin = AdminModel.getAdmin();
        customerModel=admin.getCustomerGui();
        userController.comment(customerModel,checkProductInput.getText(),admin,stringComment.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("The request was send to admin !! ");
        alert.setHeaderText(null);
        alert.setTitle("Success!");
        alert.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageComment);
        transition.setByX(210);
        transition.setCycleCount(500);
        transition.setDuration(new Duration(5000));
        transition.setAutoReverse(true);
        transition.play();
    }
}
