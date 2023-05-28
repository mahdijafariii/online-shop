package com.example.view;

import com.example.controller.AdminController;
import com.example.controller.UserController;
import com.example.model.accountModel.AdminModel;
import com.example.model.accountModel.CustomerModel;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginPanelView {
    CustomerModel mahdi = new CustomerModel("mahdi25", "mahdi@gmail.com", "09162390873", "mahdi25@@", "Mahdi Jafari");

    private AdminModel admin = AdminModel.getAdmin();
    private AdminController adminController = new AdminController();
    private UserController userController = new UserController();
    private Scanner in = new Scanner(System.in);

    public void loginPanel() {
        System.out.println("--------------------------------------------------------This is our login system---------------------------------------------------------");
        int check = -2;
        String userName;
        String password;
        int count = 0;//if you enter your pass and name wrong 3 time it will be break , so you exit from login!
        while (true) {
            count++;
            System.out.println("What is your user name :");
            userName = in.nextLine();
            System.out.println("What is your password :");
            password = in.nextLine();
            check = adminController.checkUserNamePass(userName, password);
            if (check != -1) {
                break;
            } else if (count == 3) {
                break;
            }
        }
        boolean stayInLogin=true;
        while(stayInLogin){
            int whatToDo = 11;
            if (count != 3) {//now line 39 do not run and program do not crash!
                System.out.println("Hi " + admin.getAllCostumers().get(check).getFullName() + " what do you want to do:\n" +
                        "1)Edit info!\n" +
                        "2)See product!\n" +
                        "3)Buy with id in any number!\n" +
                        "4)See purchased history!\n" +
                        "5)Comment!\n" +
                        "6)Set score!!\n" +
                        "7)See cart!!\n" +
                        "8)Finalize buy!!\n" +
                        "9)Request for charge balance!!\n" +
                        "10)See invoices!!\n" +
                        "11)See discount Codes!! \n" +
                        "12)Exit!!");
                whatToDo = in.nextInt();
            }

            if (count == 3) {
                whatToDo = 11;
            }
            switch (whatToDo) {
                case 1:
                    System.out.println("which do you want to edit ? Enter number:(1-->Full name ,, 2-->password ,, 3-->phone number ,, 4-->email");
                    int whichEdit = in.nextInt();
                    if (whichEdit == 1) {
                        in.nextLine();
                        System.out.println("What is your new full name:");
                        userController.changeName(admin.getAllCostumers().get(check), userName, password, in.nextLine());
                    } else if (whichEdit == 3) {
                        in.nextLine();
                        System.out.println("What is your new phone number:");
                        userController.changePhoneNumber(admin.getAllCostumers().get(check), userName, password, in.nextLine());
                    } else if (whichEdit == 2) {
                        in.nextLine();
                        System.out.println("What is you new password:");
                        boolean checkPass = userController.changePassword(admin.getAllCostumers().get(check), userName, password, in.nextLine());
                        if (!checkPass) {
                            System.out.println("please enter the password in correct format-->(correct format -->start with English letter+ at least one digit + at least one sign(#.!@$*&_)+letters+more than 8 letter!)");
                        }
                    } else if (whichEdit == 4) {
                        in.nextLine();
                        System.out.println("What is you new email:");
                        boolean checkPass = userController.changeEmail(admin.getAllCostumers().get(check), userName, password, in.nextLine());
                        if (!checkPass) {
                            System.out.println("please enter the email in correct format-->(correct format --> dijimahdi@gmail.com !)");
                        }
                    }
                    break;
                case 2:
                    ProductView productView=new ProductView();
                    productView.productPanel(userName,password);
                    break;
                case 3:
                    System.out.println("For buy you can give me Id of product or go to see products and product info and add to you cart!! (for give me id:press 1 else press 2!!)");
                    int checkBuy= in.nextInt();
                    if(checkBuy==1){
                        in.nextLine();
                        System.out.println("Now please give me a ID and count of you want to buy of this product !! (x5-VEHI-5 3)");
                        String id =in.nextLine();
                        System.out.println("Count of you want to buy of this product:");
                        String countProduct=in.nextLine();
                        userController.buyProductByID(admin.getAllCostumers().get(check),id,AdminModel.getAdmin(),Integer.parseInt(countProduct));
                    }
                    break;
                case 4:
                    System.out.println(userController.getPurchasedHistory(admin.getAllCostumers().get(check)));
                    break;
                case 5:
                    in.nextLine();
                    System.out.println("what is id of product:");
                    String id=in.nextLine();
                    System.out.println("Enter your opinion about this product!!");
                    String comment=in.nextLine();
                    userController.comment(admin.getAllCostumers().get(check),id,AdminModel.getAdmin(),comment);
                    break;
                case 6:
                    System.out.println("This is your purchased buy from us bring up id !!");
                    System.out.println(userController.getPurchasedHistory(admin.getAllCostumers().get(check)));
                    System.out.println("What is your score for this product!!(score should <10)");
                    double score=in.nextInt();
                    if(score>10){
                        System.out.println("Score is upper than 10");
                        break;
                    }
                    in.nextLine();
                    System.out.println("Enter Id:");
                    int checkScore=userController.setScore(admin.getAllCostumers().get(check),score,AdminModel.getAdmin(),in.nextLine());
                    if(checkScore==-1){
                        System.out.println("We do not have product with this id!!");
                    }
                    else if(checkScore==-2){
                        System.out.println("Operation failed");
                    }
                    else{
                        System.out.println("Successfully!!!");
                    }
                    break;
                case 7:
                    System.out.println("-------------------------------------This is your cart-------------------------------------!");
                    if(admin.getAllCostumers().get(check).getCart()!=null){
                        System.out.println(userController.seeCart(admin.getAllCostumers().get(check))+"\n\n");
                    }
                    else{
                        System.out.println("You do not have anything in your cart!!");
                    }

                    break;
                case 8:
                    System.out.println("------------------------------Now you want to finalize your buy---------------------!!");
                    System.out.println("-------------------------------------This is your cart-------------------------------------!");
                    System.out.println(userController.seeCart(admin.getAllCostumers().get(check))+"\n\n");


                    System.out.println("Are you have discount code ? (yes press 1 , no press two");
                    int applyDiscount = in.nextInt();
                    ArrayList<String> discounts = new ArrayList<>();
                    if(applyDiscount==1){
                        System.out.println("Enter your discount codes !!! (if you do not have code any more press 0)");
                        while(true){
                            String discount = in.nextLine();
                            if(discount.equals("0")){
                                break;
                            }
                            else{

                                    discounts.add(discount);

                            }
                        }
                    }





                    int checkFinalize=userController.finalizeBuy(discounts,admin.getAllCostumers().get(check),AdminModel.getAdmin());
                    if(checkFinalize==-5){
                        System.out.println("One of the product is not in capacity!!!");
                    }
                    else if(checkFinalize==1){
                        System.out.println(admin.getAllCostumers().get(check).getInvoiceHistory().get(admin.getAllCostumers().get(check).getInvoiceHistory().size()-1).toString());
                        admin.getAllCostumers().get(check).setCart(new ArrayList<>());
                        System.out.println("Success");
                        System.out.println("Your profit :"+ ((userController.calculateWithoutDiscount(admin.getAllCostumers().get(check),discounts,admin))-(admin.getAllCostumers().get(check).getInvoiceHistory().get(admin.getAllCostumers().get(check).getInvoiceHistory().size()-1).getTotalPrice()))+"\n\n");
                    }
                    else if(checkFinalize==-1){
                        System.out.println("You do not have enough money first please charge your account !!");
                    }
                    break;
                case 9:
                    int checkCharge;
                    do {
                        in.nextLine();
                        System.out.println("Please enter your card number:");
                        String cardNumber = in.nextLine();
                        System.out.println("Please enter your cvv2:");
                        String cvv2 = in.nextLine();
                        System.out.println("Please enter your password of card :");
                        String cardPassword = in.nextLine();
                        System.out.println("Enter amount of charge:");
                        String charge = in.nextLine();
                        checkCharge = userController.chargeBalance(admin.getAllCostumers().get(check), charge, cardNumber, cvv2, cardPassword, AdminModel.getAdmin());
                        if (checkCharge==1){
                            System.out.println("Your request was send for admin system when accept your balance will be charge!!!");
                        }
                        else if(checkCharge==-2){
                            System.out.println("Your format of cvv2 is not correct!!(3 digit --> 123)");
                        }
                        else if(checkCharge==-3){
                            System.out.println("Your password format is not correct !!!(6 digit --> 546489)");
                        }
                        else if(checkCharge==-1){
                            System.out.println("Your format of card number is not correct !!! (16 digit -->6280231331312323)");
                        }
                    }while (checkCharge!=1);
                    break;
                case 10:
                    System.out.println(userController.beforeInvoice(admin.getAllCostumers().get(check)));
                    break;
                case 11:
                    System.out.println(userController.showDiscounts(admin.getAllCostumers().get(check)));
                    break;
                case 12:
                    stayInLogin=false;
                    break;



            }
        }


    }


}
