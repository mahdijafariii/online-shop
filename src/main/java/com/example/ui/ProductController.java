package com.example.ui;

import com.example.controller.UserController;
import javafx.animation.RotateTransition;
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
import com.example.model.accountModel.AdminModel;
import com.example.model.productModel.ProductsModel;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ProductController implements Initializable {
    UserController userController = new UserController();
    AdminModel admin = AdminModel.getAdmin();
    @FXML
    private MenuItem filterDigitalProductSsd;

    @FXML
    private TextField searchInProductField;

    @FXML
    private Label labelChoiceHonor;
    @FXML
    private MenuItem filterVehicleManual;
    @FXML
    private ImageView digitalImage;
    @FXML
    private ImageView foodImage;
    @FXML
    private ImageView vehicleImage;
    @FXML
    private ImageView stationeryImage;
    @FXML
    private CheckBox checkBoxScore;

    @FXML
    private CheckBox filterPrice;


    @FXML
    private Slider sliderScore;
    @FXML
    private TextField maxPrice;

    @FXML
    private TextField minPrice;


    @FXML
    private MenuItem filterDigitalProductUsb;

    @FXML
    private MenuItem filterFood;

    @FXML
    private MenuItem filterStationery;

    @FXML
    private MenuItem filterStationeryNoteBook;
    @FXML
    private MenuItem allProduct;

    @FXML
    private MenuItem filterStationeryPen;

    @FXML
    private MenuItem filterStationeryPencil;

    @FXML
    private MenuItem filterVehicle;

    @FXML
    private MenuItem filterVehicleBike;

    @FXML
    private Button backLogin;

    @FXML
    private Button checkSpecialProduct;
    @FXML
    private MenuButton filter;

    @FXML
    private MenuItem filterDigitalProductPc;

    @FXML
    private MenuItem filterDigitalProduct;


    @FXML
    private ImageView imageSearch;

    @FXML
    private TextArea labelInfoProducts;

    @FXML
    private TextField seeInfoProduct;

    @FXML
    private TableView<ProductsModel> tableView;



    @FXML
    void checkSpecialProduct(ActionEvent event) {
        UserController userController = new UserController();
        AdminModel adminModel = AdminModel.getAdmin();
        String check = userController.searchExactInProduct(adminModel.getProductsOfStore(),seeInfoProduct.getText());
        if(check.equals("-")){
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(seeInfoProduct);
            transition.setByX(3);
            transition.setDuration(new Duration(50));
            TranslateTransition transition1 = new TranslateTransition();
            transition1.setNode(seeInfoProduct);
            transition1.setByY(3);
            transition1.setDuration(new Duration(50));
            TranslateTransition transition2 = new TranslateTransition();
            transition2.setNode(seeInfoProduct);
            transition2.setByX(-3);
            transition2.setDuration(new Duration(50));
            TranslateTransition transition3 = new TranslateTransition();
            transition3.setNode(seeInfoProduct);
            transition3.setByY(-3);
            transition3.setDuration(new Duration(50));
            RotateTransition rotateTransition = new RotateTransition();
            rotateTransition.setNode(checkSpecialProduct);
            rotateTransition.setByAngle(360);
            rotateTransition.setDuration(new Duration(50));
            rotateTransition.play();
            SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().add(transition);
            sequentialTransition.getChildren().add(transition1);
            sequentialTransition.getChildren().add(transition2);
            sequentialTransition.getChildren().add(transition3);
            sequentialTransition.play();
        }
        else {
            labelInfoProducts.setText(check);
        }


    }



    @FXML
    void backFromLoginToOnlineShop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(200);
        stage.setTitle("Online shop!!");
        stage.show();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AdminModel adminModel = AdminModel.getAdmin();
        TableColumn<ProductsModel,String> IDColumn=new TableColumn<>("Id");
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        TableColumn<ProductsModel,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<ProductsModel,Double> priceColumn=new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<ProductsModel,Integer> quantityColumn=new TableColumn<>("amount");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("countInCapacity"));
        TableColumn<ProductsModel,Double> averageColumn=new TableColumn<>("average Score");
        averageColumn.setCellValueFactory(new PropertyValueFactory<>("averageOfScores"));
        tableView.getColumns().addAll(IDColumn,nameColumn,priceColumn,quantityColumn,averageColumn);
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(adminModel.getProductsOfStore());
        tableView.setItems(data);



        TranslateTransition transition = new TranslateTransition();
        transition.setNode(digitalImage);
        transition.setByY(15);

        transition.setDuration(new Duration(4000));
        transition.setAutoReverse(true);
        transition.setCycleCount(500);
        transition.play();

        TranslateTransition transition1 = new TranslateTransition();
        transition1.setNode(stationeryImage);
        transition1.setByY(68);
        transition1.setDuration(new Duration(4000));
        transition1.setAutoReverse(true);
        transition1.setCycleCount(500);
        transition1.play();

        TranslateTransition transition2 = new TranslateTransition();
        transition2.setNode(foodImage);
        transition2.setByY(128);
        transition2.setDuration(new Duration(4000));
        transition2.setAutoReverse(true);
        transition2.setCycleCount(500);
        transition2.play();

        TranslateTransition transition3 = new TranslateTransition();
        transition3.setNode(vehicleImage);
        transition3.setByY(187);
        transition3.setDuration(new Duration(4000));
        transition3.setAutoReverse(true);
        transition3.setCycleCount(500);
        transition3.play();

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(labelChoiceHonor);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(new Duration(4000));
        rotateTransition.setCycleCount(500);
        rotateTransition.play();



    }

    @FXML
    void filterDigitalProductFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterDigitalProduct(admin.getProductsOfStore()));
        tableView.setItems(data);
    }

    @FXML
    void filterFoodFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterFood(admin.getProductsOfStore()));
        tableView.setItems(data);
    }

    @FXML
    void filterStationeryFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterStationery(admin.getProductsOfStore()));
        tableView.setItems(data);
    }

    @FXML
    void filterVehicleFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterVehicleReturnArray(admin.getProductsOfStore()));
        tableView.setItems(data);
    }
    @FXML
    void filterStationeryNoteBookFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterStationeryAsNoteBook(userController.filterStationery(admin.getProductsOfStore())));
        tableView.setItems(data);
    }

    @FXML
    void filterStationeryPenFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterPenReturnArray(userController.filterStationery(admin.getProductsOfStore())));
        tableView.setItems(data);
    }

    @FXML
    void filterStationeryPencilFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterStationeryAsPencil(userController.filterStationery(admin.getProductsOfStore())));
        tableView.setItems(data);
    }

    @FXML
    void filterVehicleBikeFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterBike(admin.getProductsOfStore()));
        tableView.setItems(data);
    }

    @FXML
    void filterDigitalProductSsdFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterDigitalProductAsSSD(userController.filterDigitalProduct(admin.getProductsOfStore())));
        tableView.setItems(data);
    }

    @FXML
    void filterDigitalProductUsbFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterDigitalProduct(admin.getProductsOfStore()));
        tableView.setItems(data);
    }
    @FXML
    void filterDigitalProductPcFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterPcReturnArray(userController.filterDigitalProduct(admin.getProductsOfStore())));
        tableView.setItems(data);
    }
    @FXML
    void filterVehicleManualFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterVehicleAsManual(userController.filterVehicleReturnArray(admin.getProductsOfStore())));
        tableView.setItems(data);
    }


    @FXML
    void searchInProductFieldFunc(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.searchInProduct(admin.getProductsOfStore(),searchInProductField.getText()));
        tableView.setItems(data);
        if(userController.searchInProduct(admin.getProductsOfStore(),searchInProductField.getText()).size()==0){
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(searchInProductField);
            transition.setByX(3);
            transition.setDuration(new Duration(50));
            TranslateTransition transition1 = new TranslateTransition();
            transition1.setNode(searchInProductField);
            transition1.setByY(3);
            transition1.setDuration(new Duration(50));
            TranslateTransition transition2 = new TranslateTransition();
            transition2.setNode(searchInProductField);
            transition2.setByX(-3);
            transition2.setDuration(new Duration(50));
            TranslateTransition transition3 = new TranslateTransition();
            transition3.setNode(searchInProductField);
            transition3.setByY(-3);
            transition3.setDuration(new Duration(50));
            SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().add(transition);
            sequentialTransition.getChildren().add(transition1);
            sequentialTransition.getChildren().add(transition2);
            sequentialTransition.getChildren().add(transition3);
            sequentialTransition.play();
        }
    }

    @FXML
    void filterPriceFunc(ActionEvent event) {
        if(Double.parseDouble(minPrice.getText())<0 || Double.parseDouble(maxPrice.getText())<0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error input number!!!");
            alert.setContentText("The value cannot be less than zero");
            alert.show();
        }
        else{
            if(filterPrice.isSelected()){
                checkBoxScore.setSelected(false);
                ArrayList<ProductsModel> arrayList = new ArrayList<>();
                arrayList.addAll(tableView.getItems());
                ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterَAsPrice(arrayList,Double.parseDouble(minPrice.getText()),Double.parseDouble(maxPrice.getText())));
                tableView.setItems(data);
            }
        }

    }
    @FXML
    void checkBoxScoreFunc(ActionEvent event) {
        if(checkBoxScore.isSelected()){
            filterPrice.setSelected(false);
            ArrayList<ProductsModel> arrayList = new ArrayList<>();
            arrayList.addAll(tableView.getItems());
            ObservableList<ProductsModel> data= FXCollections.observableArrayList(userController.filterَAsScore(arrayList,sliderScore.getValue(),10));
            tableView.setItems(data);
        }
    }

    @FXML
    void allProduct(ActionEvent event) {
        ObservableList<ProductsModel> data= FXCollections.observableArrayList(admin.getProductsOfStore());
        tableView.setItems(data);
    }



}
