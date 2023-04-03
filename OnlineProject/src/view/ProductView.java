package view;

import controller.AdminController;
import controller.ProductController;
import controller.SignUpController;
import controller.UserController;
import model.accountModel.AdminModel;
import model.productModel.ProductsModel;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    private Scanner in = new Scanner(System.in);
    ProductController productController = new ProductController();
    AdminModel admin =AdminModel.getAdmin();
    ArrayList<ProductsModel> gustCart=new ArrayList<>();
    UserController userController=new UserController();
    public String productPanel(String userName,String password){
        System.out.println("-------------------------------------------------------------This is our product hope you enjoy--------------------------------------");
        boolean checkProduct=true;
        ArrayList<String> test = new ArrayList<>();
        test=productController.showProduct();
        int count =0;
        do{
            System.out.println(test.get(count));
            System.out.println("What do you want to do:\n1)Next page!!\n2)Previous page!!\n3)see info of product and buy!!\n4)see cart and remove product from it!!\n5)comment for product!!\n6)filter and search!!\n7)exit!! ");
            int whatToDo= in.nextInt();
            switch (whatToDo) {
                case 1:
                    count = productController.nextPage(count);
                    break;
                case 2 :
                    count = productController.previousPage(count);
                    break;
                case 3 :
                    System.out.println("What is the number of product in list!");
                    int showProduct = in.nextInt();
                    if (admin.getProductsOfStore().size() != showProduct && showProduct > 0) {
                        System.out.println(productController.showProductInfo(showProduct));
                        System.out.println("What do you want to do? 1-->buy 2-->back to show product!");
                        int choose = in.nextInt();
                        if (choose == 1) {
                            in.nextLine();
                            if (userName.equals("Gust") && password.equals("Gust")) {
                                SignUpController gust = new SignUpController();
                                System.out.println("User name \n" +
                                        "Email:\n" +
                                        "Password:\n" +
                                        "Full name:\n" +
                                        "Phone number:");
                                while (true) {
                                    int checkSignUP = gust.addUser(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
                                    if (checkSignUP == -1) {
                                        System.out.println("We have this user name in our store please enter another user name: Enter every thing again!!");
                                    } else if (checkSignUP == -2) {
                                        System.out.println("We have this email in our store please enter another user name: Enter every thing again!!");
                                    } else if (checkSignUP == -4) {
                                        System.out.println("This format of password is not accepted (correct format -->start with English letter+ at least one digit + at least one sign(#.!@$*&_)+letters+more than 8 letter! Enter every thing again!!");

                                    } else if (checkSignUP == -3) {
                                        System.out.println("This format of email is not accepted! (correct format --> correct@gmail.com) Enter every thing again!!");


                                    } else if (checkSignUP == 1) {
                                        System.out.println("We send your request for admin if admin accept your request soon you can login with your user name and password!!!");
                                        userName = "false";// now you can buy product as a gust without set user and... again!
                                        break;
                                    }
                                }
                            }
                            boolean isUser= false;
                            for (int i = 0; i < admin.getAllCostumers().size(); i++) {
                                if (admin.getAllCostumers().get(i).getUserName().equals(userName) && admin.getAllCostumers().get(i).getPassword().equals(password)) {
                                    admin.getAllCostumers().get(i).getCart().add(admin.getProductsOfStore().get(showProduct-1));
                                    System.out.println("your product was added!! ");

                                    isUser=true;
                                    break;
                                }
                            }
                            if(!isUser) {
                                gustCart.add(admin.getProductsOfStore().get(showProduct - 1));
                                System.out.println("your product was added!!");
                            }
                        }
                    }
                    else {
                        System.out.println("This is a wrong number !");
                    }
                    break;
                case 4:
                    boolean isUser= false;
                    for (int i = 0; i < admin.getAllCostumers().size(); i++) {
                        if (admin.getAllCostumers().get(i).getUserName().equals(userName) && admin.getAllCostumers().get(i).getPassword().equals(password)) {
                            System.out.println(userController.seeCart(admin.getAllCostumers().get(i)));
                            isUser=true;
                            System.out.println("If you want to remove product press number of it in list else press -1:");
                            int removeProduct=in.nextInt();
                            if(removeProduct==-1){
                                break;
                            }
                            admin.getAllCostumers().get(i).getCart().remove(removeProduct-1);
                            break;
                        }
                    }
                    if(!isUser) {
                        for(int j=0 ; j<gustCart.size();j++) {
                            System.out.println((j+1)+"Name:"+gustCart.get(j).getName()+"  --  product Id:"+gustCart.get(j).getProductID()+"  --  price:"+gustCart.get(j).getPrice()+"\n");
                        }
                        System.out.println("If you want to remove product press number of it in list else press -1:");
                        int removeProduct=in.nextInt();
                        if(removeProduct==-1){
                            break;
                        }
                        gustCart.remove(removeProduct-1);
                        break;
                    }
                break;
                case 5:
                    System.out.println("Now you want to comment for product!!");
                    if (userName.equals("false")||userName.equals("Gust")){
                        System.out.println("you are not user of our website first you should sign up !!");
                    }
                    else{
                        in.nextLine();
                        for (int i = 0; i < admin.getAllCostumers().size(); i++) {
                            if (admin.getAllCostumers().get(i).getUserName().equals(userName) && admin.getAllCostumers().get(i).getPassword().equals(password)) {
                                System.out.println("what is id of product:");
                                String id=in.nextLine();
                                System.out.println("Enter your opinion about this product!!");
                                String comment=in.nextLine();
                                userController.comment(admin.getAllCostumers().get(i),id,AdminModel.getAdmin(),comment);
                                System.out.println("ok!");
                                break;
                            }
                            }
                    }
                    break;

                case 6:
                    in.nextLine();
                    System.out.println("------------------------------------------This is out filter and search system!!------------------------------------------");
                    System.out.println("HELP SYSTEM:   -->> you should enter your filtering or search by command like these!!(for buy product bring up Id and use in login system!!)\n" +
                            "filter digital_product!!\n" +
                            "filter digital_product min max(as a capacity)!!\n" +
                            "filter digital_product pc!!\n" +
                            "filter digital_product usb!!\n " +
                            "filter digital_product ssd!!\n" +
                            "filter stationery!!\n" +
                            "filter stationery pen!!\n" +
                            "filter stationery noteBook !!\n" +
                            "filter stationery pencil !!\n" +
                            "filter food!!\n" +
                            "filter Vehicle!!\n" +
                            "filter Vehicle bike!!\n" +
                            "filter Vehicle vehicle!!\n" +
                            "filter capacity!!(show you our product that have we have in capacity)!!\n" +
                            "filter score min max!!\n" +
                            "filter price min max!! (filter price 5000 50000)\n" +
                            "search productName!! (search silicon)\n" +
                            "searchExact productId" );
                    boolean filter=true;
                    while (filter){
                        System.out.println("write your command for filtering or searching!!");
                        String command=in.nextLine();
                        String[] splitCommand = command.split(" ");
                        switch (splitCommand[0]){
                            case "filter":
                                switch (splitCommand[1]){
                                    case "digital_product":
                                        if(splitCommand.length==2){
                                            System.out.println(userController.filterCategory(admin.getProductsOfStore(),"digital_products"));
                                        }
                                        else if(true) {
                                            if (splitCommand[2].equals("usb")) {
                                                System.out.println(userController.filterDigitalProductAsUsb(userController.filterDigitalProduct(admin.getProductsOfStore())));
                                            } else if (splitCommand[2] .equals("pc") ) {
                                                System.out.println(userController.filterDigitalProductAsPc((userController.filterDigitalProduct(admin.getProductsOfStore()))));
                                            } else if (splitCommand[2] .equals( "ssd")) {
                                                System.out.println(userController.filterDigitalProductAsSSD((userController.filterDigitalProduct(admin.getProductsOfStore()))));
                                            }
                                            else if(splitCommand.length==4){
                                                System.out.println(userController.filterDigitalProductAsCapacity(userController.filterDigitalProduct(admin.getProductsOfStore()),Integer.parseInt(splitCommand[3]),Integer.parseInt(splitCommand[4])));
                                            }
                                        }
                                        break;
                                    case "Vehicle":
                                        if(splitCommand.length==2){
                                            System.out.println(userController.filterCategory(admin.getProductsOfStore(),"vehicles"));

                                        }
                                        else {
                                            if (splitCommand[2] .equals("bike") ) {
                                                System.out.println(userController.filterBike(admin.getProductsOfStore()));

                                            } else if (splitCommand[2] .equals("vehicle") ) {
                                                System.out.println(userController.filterVehicle(admin.getProductsOfStore()));
                                            }
                                        }
                                        break;
                                    case "food":
                                        System.out.println(userController.filterFood(admin.getProductsOfStore()));
                                        break;
                                    case "stationery":
                                        if(splitCommand.length==2){
                                            System.out.println(userController.filterCategory(admin.getProductsOfStore(),"STATIONERY"));
                                        }
                                        else{
                                            if(splitCommand[2].equals("noteBook")){
                                                System.out.println(userController.filterStationeryAsNoteBook(userController.filterStationery(admin.getProductsOfStore())));
                                            }
                                            else if(splitCommand[2].equals("pen")){
                                                System.out.println(userController.filterStationeryAsPen(userController.filterStationery(admin.getProductsOfStore())));

                                            }
                                            else if(splitCommand[2].equals("pencil")){
                                                System.out.println(userController.filterStationeryAsPencil(userController.filterStationery(admin.getProductsOfStore())));

                                            }
                                        }
                                        break;
                                    case "capacity":
                                        System.out.println(userController.filterَAsCapacity(admin.getProductsOfStore()));
                                        break;
                                    case "score":
                                        System.out.println(userController.filterَAsScore(admin.getProductsOfStore(),Double.parseDouble(splitCommand[2]),Double.parseDouble(splitCommand[3])));
                                        break;
                                    case "price":
                                        System.out.println(userController.filterَAsPrice(admin.getProductsOfStore(),Double.parseDouble(splitCommand[2]),Double.parseDouble(splitCommand[3])));
                                        break;

                                }

                                break;
                            case "search":
                                System.out.println(userController.searchInProduct(admin.getProductsOfStore(),splitCommand[1]));
                                break;
                            case "searchExact":
                                System.out.println(userController.searchExactInProduct(admin.getProductsOfStore(),splitCommand[1]));

                                break;
                            case "exit":
                                filter=false;
                                break;
                        }

                    }




                    break;

                case 7:
                    checkProduct=false;
                    break;


                    }
        }while (checkProduct);





    return"";}




    public void byWhenFiltering(String id){

    }


}
