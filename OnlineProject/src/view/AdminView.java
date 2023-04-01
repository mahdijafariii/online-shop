package view;

import controller.AdminController;
import model.accountModel.AdminModel;

import java.util.Scanner;

public class AdminView {
    private Scanner in = new Scanner(System.in);
    AdminController adminController = new AdminController();
    private AdminModel admin=AdminModel.getAdmin();


    public void adminView(){
        boolean exiting2 = true;
        while(exiting2) {
            System.out.println("please enter your name:");
            String adminName = in.nextLine();
            System.out.println("please enter your password:");
            String adminPassword = in.nextLine();
            if (adminName.equals("admin") && adminPassword.equals(adminPassword)) {
                boolean exiting1 = true;
                while (exiting1) {
                    System.out.println("Enter command ://for help enter help");
                    String command = in.nextLine();
                    String[] splitCommand = command.split(" ");
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
                        case "edit":
                            adminController.editInfo(splitCommand[1], splitCommand[2], splitCommand[3]);
                            break;
                        case "showCustomers":
                            adminController.costumers();
                            break;
                        case "showChargeRequests":
                            adminController.listChargeRequest();
                            break;
                        case "showCommentRequests":
                            adminController.listCommentsOfProduct();
                            break;
                        case "showSignUpRequests":
                            adminController.listOfSignUp();
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
                            System.out.println("------------------------------------------------------This is are help system------------------------------------------------------");
                            System.out.println("Important:  All of commands should be written on line and with on space between words! (for name like amir ali --> amir_ali is correct! ");
                            System.out.println("---------------------------------------------------------for adding item--------------------------------------------------------\n" +
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
                                    "add PC idea_pad 55000000 10 2 0.5*0.3 12700H 16 ");
                            System.out.println("-----------------------------------------------------------For editing item--------------------------------------------------------");
                            System.out.println("edit -Id Product- -type edit- -new edition- (type edit : name - price - capacity)\n" +
                                    "edit x5-VEHI-1 name x6\n" +
                                    "edit x5-VEHI-1 price 4000000000\n" +
                                    "edit x5-VEHI-1 capacity 10");
                            System.out.println("---------------------------------------------------------For showing customers------------------------------------------------------------");
                            System.out.println("showCustomers");
                            System.out.println("-------------------------------------------------------For showing comment requests-------------------------------------------------------");
                            System.out.println("showCommentRequests");
                            System.out.println("-------------------------------------------------------For showing charge requests--------------------------------------------------------");
                            System.out.println("showChargeRequests");
                            System.out.println("-------------------------------------------------------For showing sign up requests-------------------------------------------------------");
                            System.out.println("showSignUpRequest");
                            System.out.println("-----------------------------------------------------------For removing items-------------------------------------------------------------");
                            System.out.println("remove -product ID-\n" +
                                    "remove x5-VEHI-1");
                            System.out.println("--------------------------------------------------------For accept/reject requests--------------------------------------------------------");
                            System.out.println("accept charge -number of this charge request in list-\n" +
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
                            break;
                        case "exit":
                            exiting1 = false;
                            exiting2 = false;
                            break;


                    }
                }
            } else {
                System.out.println("wrong name and password if you are not admin Enter exit if you want to try again enter try!!");
                String tryOrExit = in.nextLine();
                if (tryOrExit.equals("exit"))
                    break;
            }
        }




    }
}
