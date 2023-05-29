package com.example.ui;

import com.example.controller.UserController;
import com.example.exception.InsufficientAmountOfProductException;
import com.example.exception.InsufficientMoneyException;
import com.example.exception.InvalidDiscountException;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;
import com.example.model.productModel.ProductsModel;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class FinalizeBuyController implements Initializable {
    private ArrayList<String> discounts = new ArrayList<>(); ;
    private UserController userController = new UserController();
    private CustomerModel customer ;
    private AdminModel adminModel =AdminModel.getAdmin();
    @FXML
    private Button addDiscount;

    @FXML
    private Button backFromFinalizeBuy;

    @FXML
    private Button buyButton;

    @FXML
    private TableView<ProductsModel> cart;

    @FXML
    private Button deleteFromCartButton;

    @FXML
    private TextArea discountField;

    @FXML
    private TextField fieldBalance;

    @FXML
    private TextField fieldDiscount;

    @FXML
    private TextField fieldUserName;

    @FXML
    private ImageView imageBuy;

    @FXML
    private TextField textFieldDeleteProduct;

    @FXML
    void addDiscountFunc(ActionEvent event) throws InvalidDiscountException {
        try {
            if(!(fieldDiscount.getText()==null || fieldDiscount.getText().equals(""))){
                userController.checkDiscount(fieldDiscount.getText(),adminModel);
                boolean checkDiscount =true;
                for(int i = 0 ; i<discounts.size();i++){
                    if(fieldDiscount.getText().equals(discounts.get(i))){
                        checkDiscount=false;
                    }
                }
                if(checkDiscount){
                    discounts.add(fieldDiscount.getText());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("The discount added !!");
                    alert.show();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("This discount code is repeated!!");
                    alert.show();
                }

            }
        }
        catch (InvalidDiscountException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.show();
        }


    }

    @FXML
    void backFromFinalizeBuyFunc(ActionEvent event) throws IOException {
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
    void buyButtonFunc(ActionEvent event) throws IOException, InsufficientMoneyException, InsufficientAmountOfProductException {
        int checkFinalize=0;
        try {
            checkFinalize=userController.finalizeBuy(discounts,customer,adminModel);
        }
        catch (InvalidDiscountException|InsufficientAmountOfProductException | InsufficientMoneyException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(exception.getMessage());
            alert.show();
        }

        if(checkFinalize==1){
            customer.setCart(new ArrayList<>());
            customer.getInvoiceHistory().get(customer.getInvoiceHistory().size()-1).setProfit(userController.calculateWithoutDiscount(customer,discounts,adminModel)-(customer.getInvoiceHistory().get(customer.getInvoiceHistory().size()-1).getTotalPrice()));
            discounts = new ArrayList<>();
            //go to new page !!!
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("invoice-after-buy.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.setScene(scene);
            stage.setX(500);
            stage.setY(200);
            stage.setTitle("Invoice");
            stage.show();


        }

    }

    @FXML
    void deleteFromCartButtonFunc(ActionEvent event) {
        int check = customer.getCart().size();
        for(int i = 0 ; i<customer.getCart().size() ; i++){
            if(textFieldDeleteProduct.getText().equals(customer.getCart().get(i).getProductID())){
                customer.getCart().remove(i);
                ObservableList<ProductsModel> data= FXCollections.observableArrayList(customer.getCart());
                cart.setItems(data);
                break;
            }
        }
        if (check==customer.getCart().size()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You do not product with this id in your cart!!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("The product was removed!!");
            alert.show();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customer=adminModel.getCustomerGui();
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageBuy);
        transition.setByX(380);
        transition.setDuration(new Duration(2000));

        TranslateTransition transition2 = new TranslateTransition();
        transition2.setNode(imageBuy);
        transition2.setByY(350);
        transition2.setDuration(new Duration(2000));

        TranslateTransition transition3 = new TranslateTransition();
        transition3.setNode(imageBuy);
        transition3.setByX(-380);
        transition3.setDuration(new Duration(2000));

        TranslateTransition transition4 = new TranslateTransition();
        transition4.setNode(imageBuy);
        transition4.setByY(-350);
        transition4.setDuration(new Duration(2000));



        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.setCycleCount(500);
        sequentialTransition.getChildren().add(transition);
        sequentialTransition.getChildren().add(transition2);
        sequentialTransition.getChildren().add(transition3);
        sequentialTransition.getChildren().add(transition4);
        sequentialTransition.play();

        ///cart !!!

        customer=adminModel.getCustomerGui();
        TableColumn<ProductsModel,String> IDColumn=new TableColumn<>("Id");
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductsModel,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ProductsModel,Double> priceColumn=new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ProductsModel,Double> averageColumn=new TableColumn<>("average Score");
        averageColumn.setCellValueFactory(new PropertyValueFactory<>("averageOfScores"));
        cart.getColumns().addAll(IDColumn,nameColumn,priceColumn,averageColumn);
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(customer.getCart());
        cart.setItems(data);

        //discount Field
        discountField.setText(userController.showDiscounts(customer));
        //username and balance ser
        fieldUserName.setText(customer.getUserName());
        fieldBalance.setText(String.valueOf(customer.getBalance()));

    }
}
