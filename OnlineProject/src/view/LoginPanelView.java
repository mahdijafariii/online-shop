package view;

import controller.AdminController;
import controller.UserController;
import model.accountModel.AdminModel;
import model.accountModel.CustomerModel;

import java.util.Scanner;

public class LoginPanelView {
    CustomerModel mahdi = new CustomerModel("mahdi25", "mahdi@gmail.com", "09162390873", "mahdi25@@", "Mahdi Jafari");

    AdminModel admin = AdminModel.getAdmin();
    AdminController adminController = new AdminController();
    UserController userController = new UserController();
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
            int whatToDo = 10;
            if (count != 3) {//now line 39 do not run and program do not crash!
                System.out.println("Hi " + admin.getAllCostumers().get(check).getFullName() + " what do you want to do:\n" +
                        "1)edit info!\n" +
                        "2)see product!\n" +
                        "3)buy with id in any number!\n" +
                        "4)see purchased history!\n" +
                        "5)comment!\n" +
                        "6)set score!!\n" +
                        "7)see cart!!\n" +
                        "8)finalize buy!!\n" +
                        "9)request for charge balance!!\n" +
                        "10)exit!!");
                whatToDo = in.nextInt();
            }

            if (count == 3) {
                whatToDo = 10;
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
                        userController.buyProductByID(admin.getAllCostumers().get(check),in.nextLine(),AdminModel.getAdmin(),Integer.parseInt(in.nextLine()));
                    }
                    break;
                case 4:
                    System.out.println(userController.getPurchasedHistory(admin.getAllCostumers().get(check)));
                    break;
                case 5:
                    System.out.println("what is id of product:");
                    String id=in.nextLine();
                    System.out.println("Enter your opinion about this product!!");
                    String comment=in.nextLine();
                    userController.comment(admin.getAllCostumers().get(check),id,AdminModel.getAdmin(),comment);
                    break;
                case 6:
                    System.out.println("This is your purchased buy from us bring up id !!");
                    System.out.println(userController.getPurchasedHistory(admin.getAllCostumers().get(check)));
                    System.out.println("what is your score for this product!!(score should <10)");
                    double score=in.nextInt();
                    if(score>10){
                        System.out.println("score is upper than 10");
                        break;
                    }
                    in.nextLine();
                    System.out.println("Enter Id:");
                    int checkScore=userController.setScore(admin.getAllCostumers().get(check),score,AdminModel.getAdmin(),in.nextLine());
                    if(checkScore==-1){
                        System.out.println("we do not have product with this id!!");
                    }
                    else if(checkScore==-2){
                        System.out.println("Operation failed");
                    }
                    else{
                        System.out.println("successfully!!!");
                    }
                    break;
                case 7:
                    System.out.println("-------------------------------------This is your cart-------------------------------------!");
                    System.out.println(userController.seeCart(admin.getAllCostumers().get(check))+"\n\n");
                    break;
                case 8:
                    System.out.println("Now you want to finalize your buy!!");
                    System.out.println("-------------------------------------This is your cart-------------------------------------!");
                    System.out.println(userController.seeCart(admin.getAllCostumers().get(check))+"\n\n");

                    break;
                case 9:
                    break;
                case 10:
                    stayInLogin=false;
                    break;



            }
        }


    }

}
