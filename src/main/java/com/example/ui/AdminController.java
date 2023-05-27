package com.example.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.accountModel.AdminModel;

import java.io.IOException;
import java.util.Objects;

public class AdminController {
    @FXML
    private TextArea TextCommandAdmin;

    @FXML
    private Button backForAdmin;
    @FXML
    private Button saveButton;

    @FXML
    private Button deleteCommand;
    @FXML
    private TextArea help;

    @FXML
    void saveCommand(ActionEvent event) {
        controller.AdminController adminController = new controller.AdminController();

        System.out.println("Enter command ://for help enter help");
        String[] commands = TextCommandAdmin.getText().split("\n");
        for (int i = 0; i < commands.length; i++) {
            String[] splitCommand = commands[i].split(" ");
                switch (splitCommand[0]) {
                    case "add":
                        switch (splitCommand[1]) {
                            case "vehicle":
                                if (splitCommand.length - 2 == 6) {
                                    adminController.addVehicle(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), splitCommand[5], Boolean.parseBoolean(splitCommand[6]), Integer.parseInt(splitCommand[7]));
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "bike":
                                if (splitCommand.length - 2 == 5) {
                                    adminController.addBike(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), Integer.parseInt(splitCommand[5]), splitCommand[6]);
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "noteBook":
                                if (splitCommand.length - 2 == 6) {
                                    adminController.addNoteBook(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), splitCommand[5], Integer.parseInt(splitCommand[6]), splitCommand[7]);
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "pen":
                                if (splitCommand.length - 2 == 5) {
                                    adminController.addPen(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), splitCommand[5], splitCommand[6]);
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "pencil":
                                if (splitCommand.length - 2 == 6) {
                                    adminController.addPencil(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), splitCommand[5], splitCommand[6], Integer.parseInt(splitCommand[7]));

                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "food":
                                if (splitCommand.length - 2 == 5) {
                                    adminController.addFood(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), Integer.parseInt(splitCommand[5]), Integer.parseInt(splitCommand[6]));
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "ssd":
                                if (splitCommand.length - 2 == 8) {
                                    adminController.addSSD(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), Double.parseDouble(splitCommand[5]), splitCommand[6], Double.parseDouble(splitCommand[7]), Integer.parseInt(splitCommand[8]), Integer.parseInt(splitCommand[9]));
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "usb":
                                if (splitCommand.length - 2 == 7) {
                                    adminController.addUsb(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), Double.parseDouble(splitCommand[5]), splitCommand[6], Double.parseDouble(splitCommand[7]), Integer.parseInt(splitCommand[8]));
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;
                            case "PC":
                                if (splitCommand.length - 2 == 7) {
                                    adminController.addPersonalComputer(splitCommand[2], Double.parseDouble(splitCommand[3]), Integer.parseInt(splitCommand[4]), Double.parseDouble(splitCommand[5]), splitCommand[6], splitCommand[7], Integer.parseInt(splitCommand[8]));
                                } else {
                                    System.out.println("please enter help and see correct command!!");
                                }
                                break;

                        }
                        break;
                    case "discountZeroBuy":
                        adminController.addDiscountWithZeroBuy();
                        break;
                    case "discountCategory":
                        adminController.generateCategoryDiscount(splitCommand[1], Integer.parseInt(splitCommand[2]), Integer.parseInt(splitCommand[3]), Integer.parseInt(splitCommand[4]), Integer.parseInt(splitCommand[5]), Integer.parseInt(splitCommand[6]));
                        break;
                    case "discountNameProduct":
                        adminController.generateSpecialDiscount(splitCommand[1], Double.parseDouble(splitCommand[2]), Integer.parseInt(splitCommand[3]), Integer.parseInt(splitCommand[4]), Integer.parseInt(splitCommand[5]), Integer.parseInt(splitCommand[6]));
                        break;
                    case "showAllDiscount":
                        System.out.println(adminController.showAllDiscounts());
                        break;
                    case "giveDiscount":
                        adminController.giveDiscountToCustomer(Integer.parseInt(splitCommand[1]), Integer.parseInt(splitCommand[2]));
                        break;
                    case "normalDiscount":
                        adminController.generateNormalDiscount(Double.parseDouble(splitCommand[1]), Integer.parseInt(splitCommand[2]), Integer.parseInt(splitCommand[3]), Integer.parseInt(splitCommand[4]), Integer.parseInt(splitCommand[5]));
                        break;
                    case "setInterfaceDiscount":
                        adminController.setDiscountInterface(splitCommand[1], Double.parseDouble(splitCommand[2]));
                        break;
                    case "removeInterfaceDiscount":
                        adminController.removeDiscountInterface(splitCommand[1]);
                        break;
                    case "edit":
                        adminController.editInfo(splitCommand[1], splitCommand[2], splitCommand[3]);
                        break;
                    case "showCustomers":
                        help.setText(null);
                        help.setText(adminController.costumers());
                        break;
                    case "showChargeRequests":
                        help.setText(null);
                        help.setText(adminController.listChargeRequest());
                        break;
                    case "showCommentRequests":
                        help.setText(null);
                        help.setText(adminController.listCommentsOfProduct());
                        break;
                    case "showSignUpRequests":
                        help.setText(null);
                        help.setText(adminController.listOfSignUp());
                        break;
                    case "remove":
                        adminController.removeProduct(splitCommand[1]);
                        break;
                    case "accept":
                        switch (splitCommand[1]) {
                            case "charge":
                                adminController.chargeAccept(Integer.parseInt(splitCommand[2]));
                                break;
                            case "comment":
                                adminController.acceptComment(Integer.parseInt(splitCommand[2]));
                                break;
                            case "signUp":
                                adminController.acceptSignUp(Integer.parseInt(splitCommand[2]));
                                break;

                        }
                        break;
                    case "reject":
                        switch (splitCommand[1]) {
                            case "charge":
                                adminController.chargeRejected(Integer.parseInt(splitCommand[2]));
                                break;
                            case "comment":
                                adminController.rejectComment(Integer.parseInt(splitCommand[2]));
                                break;
                            case "signUp":
                                adminController.rejectSignUp(Integer.parseInt(splitCommand[2]));
                                break;
                        }
                        break;
                    case "help":
                        StringBuilder test = new StringBuilder();
                        test.append("-----------------------------This is are help system-----------------------------\n");
                        test.append("Important:  All of commands should be written on line and with on space between words! (for name like amir ali --> amir_ali is correct! \n");
                        test.append("-----------------------------for adding item-----------------------------\n" +
                                "vehicle : add vehicle -name- -price- -count In capacity- -name creator- -type of gear- -engin volume- (type of gear :Automatic:true , Manual=false)\n" +
                                "add vehicle x5 5000000000 6 bmw true 25000\n" +
                                "add bike -name- -price- -count In capacity- -type of bike- (type of bike: 1-->City 2-->Hybrid 3-->Road 4-->Mountain)\n" +
                                "add bike viva 16500000 10 1\n" +
                                "add noteBook -name- -price- -count In capacity- -name creator- -number of leaves- -type of leaves-\n" +
                                "add noteBook fantasize 18000 50 AmirWorkShop 150 paper\n" +
                                "add pencil -name- -price- -count In capacity- -name creator- -color- -type of pen- (type of pen 1-->B 2-->F 3-->HB 4-->H2 5-->H)\n" +
                                "add pencil design 50000 10 Germany black 1 \n" +
                                "add pen -name- -price- -count In capacity- -name creator- -color-\n" +
                                "add pen bluePen 5000 90 Kian blue \n" +
                                "add ssd -name- -price- -count In capacity- -weight- -dimension- -capacity- -reading speed- writing speed-\n" +
                                "add ssd silicon 2500000 50 0.5 0.15*0.10 1000 100 50\n" +
                                "add usb -name- -price- -count In capacity- -weight- -dimension- -capacity- -version- (version:2-3)\n" +
                                "add usb silicon 180000 150 0.1 0.02*0.07 32 32 3\n" +
                                "add PC -name- -price- -count In capacity- -weight- -dimension- -cpu- -ram-\n" +
                                "add PC idea_pad 55000000 10 2 0.5*0.3 12700H 16 \n");
                        test.append("-----------------------------For editing item-----------------------------\n");
                        test.append("edit -Id Product- -type edit- -new edition- (type edit : name - price - capacity)\n" +
                                "edit x5-VEHI-1 name x6\n" +
                                "edit x5-VEHI-1 price 4000000000\n" +
                                "edit x5-VEHI-1 capacity 10\n");
                        test.append("-----------------------------For showing customers-----------------------------\n");
                        test.append("showCustomers\n");
                        test.append("-----------------------------For showing comment requests-----------------------------\n");
                        test.append("showCommentRequests\n");
                        test.append("-----------------------------For showing charge requests-----------------------------\n");
                        test.append("showChargeRequests\n");
                        test.append("-----------------------------For showing sign up requests-----------------------------\n");
                        test.append("showSignUpRequests\n");
                        test.append("-----------------------------For removing items-----------------------------\n");
                        test.append("remove -product ID-\n" +
                                "remove x5-VEHI-1\n");
                        test.append("-----------------------------For accept/reject requests-----------------------------\n");
                        test.append("accept charge -number of this charge request in list-\n" +
                                "accept charge 5\n" +
                                "accept comment -number of this comment request in list-\n" +
                                "accept comment 6\n" +
                                "accept signUp -number of this sign up request in list-\n" +
                                "accept signUp 4\n" +
                                "reject charge -number of this charge request in list-\n" +
                                "reject charge 5\n" +
                                "reject comment -number of this comment request in list-\n" +
                                "reject signUp 4\n" +
                                "reject signUp -number of this sign up request in list-\n" +
                                "reject signUp 4\n\n\n");
                        help.setText(test.toString());

                        break;
                    case "exit":
                        break;


                }
        }
    }

    @FXML
    void BackInMainFromAdmin(ActionEvent event) throws IOException {
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
    void deleteCommand(ActionEvent event) {
        TextCommandAdmin.setText(null);

    }
}
