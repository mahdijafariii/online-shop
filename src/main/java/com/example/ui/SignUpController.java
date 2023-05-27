package com.example.ui;

import controller.UserController;
import exception.InvalidFormatEmailException;
import exception.InvalidFormatPhoneNumberException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button backFromSignUp;

    @FXML
    private Button deleteSignUp;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button saveSignUpInfo;

    @FXML
    private ImageView signUpImage;

    @FXML
    private Button helpSignUp;

    @FXML
    private TextField userNameTextField;

    @FXML
    void BackFromSignUp(ActionEvent event) throws IOException {
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
    void deleteInformation(ActionEvent event) {
        nameTextField.setText(null);
        userNameTextField.setText(null);
        passwordTextField.setText(null);
        emailTextField.setText(null);
        numberTextField.setText(null);
    }

    @FXML
    void saveSignUpInfo(ActionEvent event)  {
        controller.SignUpController sign = new controller.SignUpController();
        try {
            if(sign.checkEmailRegex(emailTextField.getText()) | sign.checkPhoneNumber(numberTextField.getText()) | sign.checkPasswordRegex(passwordTextField.getText())){
                int check = sign.addUser(userNameTextField.getText(),emailTextField.getText(),passwordTextField.getText(),nameTextField.getText(),nameTextField.getText());
                if(check==1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION , "Your request was sent to admin !!!");
                    alert.setTitle(null);
                    alert.show();
                }
                else if(check==-1){
                    Alert alert = new Alert(Alert.AlertType.ERROR , "This user name is already selected!! ");
                    alert.setTitle(null);
                    alert.show();
                }
                else if(check==-2){
                    Alert alert = new Alert(Alert.AlertType.ERROR , "This email is already selected!! ");
                    alert.setTitle(null);
                    alert.show();
                }
                else if (check==-4){
                    Alert alert = new Alert(Alert.AlertType.ERROR , "This format of password is not corrected!!");
                    alert.setTitle(null);
                    alert.show();
                }
            }
        }
        catch (InvalidFormatPhoneNumberException | InvalidFormatEmailException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR,exception.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }

    }
    @FXML
    void helpSignUp(ActionEvent event) {
        StringBuilder test = new StringBuilder();
        test.append("Number:11 corrector :09131021532\n");
        test.append("--------------------------\n");
        test.append("Email:test@gmail.com\n");
        test.append("--------------------------\n");
        test.append("Password:1 corrector number + 1 upperCase corrector \n1 smallCase corrector + one special sign\nand more than 8 corrector -->like :aliAli@1421\n");
        test.append("--------------------------\n");
        test.append("User name :a new user name!! \n");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help sign Up");
        alert.setContentText(test.toString());
        alert.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(signUpImage);
        transition.setByY(100);
        transition.setAutoReverse(true);
        transition.setDuration(new Duration(3000));
        transition.setCycleCount(500);
        transition.play();
    }
}
