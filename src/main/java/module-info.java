module com.example.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    opens com.example.model.productModel to javafx.fxml;
    opens com.example.model.accountModel to javafx.fxml;

    exports com.example.model.productModel;
    exports com.example.model.accountModel;


    opens com.example.ui to javafx.fxml;
    exports com.example.ui;
}