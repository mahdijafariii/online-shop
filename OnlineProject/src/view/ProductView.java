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
    private ProductController productController = new ProductController();
    private AdminModel admin =AdminModel.getAdmin();

    private static ArrayList<ProductsModel> gustCart;
    private UserController userController=new UserController();
    public String productPanel(String userName,String password){
        System.out.println("-------------------------------------------------------------This is our product hope you enjoy--------------------------------------");
        boolean checkProduct=true;
        ArrayList<String> test = new ArrayList<>();
        test=productController.showProduct();
        int count =0;

        do{
            if(productController.showProduct().size()!=0) {
                System.out.println(test.get(count));
            }
            else{
                System.out.println("We do not have any product in our store wait until admin charge new product!!\n\n");
            }
            System.out.println("What do you want to do:\n1)Next page!!\n2)Previous page!!\n3)See info of product !!\n4)Filter and search!!\n5)Exit!! ");
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
                    }
                    break;



                case 4:
                    in.nextLine();
                    System.out.println("------------------------------------------This is out filter and search system!!------------------------------------------");
                    System.out.println("HELP SYSTEM:   -->> you should enter your filtering or search by command like these!!(for buy product bring up Id and use in login system!!)\n" +
                            "filter digital_product!!\n" +
                            "filter digital_product min max(as a capacity)!!\n" +
                            "filter digital_product pc!!\n" +
                            "filter digital_product pc ram min max!!\n" +
                            "filter digital_product usb!!\n " +
                            "filter digital_product ssd!!\n" +
                            "filter stationery!!\n" +
                            "filter stationery pen!!\n" +
                            "filter stationery prn color type(type-->red*green*black*blue*and...)!!\n" +
                            "filter stationery noteBook !!\n" +
                            "filter stationery pencil !!\n" +
                            "filter food!!\n" +
                            "filter Vehicle!!\n" +
                            "filter Vehicle bike!!\n" +
                            "filter Vehicle vehicle!!\n" +
                            "filter Vehicle vehicle manual!!\n" +
                            "filter Vehicle vehicle engine min max!!\n" +
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
                                        else  {
                                            if (splitCommand[2].equals("usb")) {
                                                System.out.println(userController.filterDigitalProductAsUsb(userController.filterDigitalProduct(admin.getProductsOfStore())));
                                            } else if (splitCommand[2] .equals("pc") ) {
                                                if(splitCommand[3].equals("ram")){
                                                    System.out.println(userController.filterPcAsRAM(userController.filterPcReturnArray((userController.filterDigitalProduct(admin.getProductsOfStore()))),Integer.parseInt(splitCommand[4]),Integer.parseInt(splitCommand[5])));
                                                }
                                                else {
                                                    System.out.println(userController.filterDigitalProductAsPc((userController.filterDigitalProduct(admin.getProductsOfStore()))));
                                                }
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

                                            }
                                            else if (splitCommand[2] .equals("vehicle") )
                                            {
                                                if(splitCommand[3].equals("engine")){
                                                    System.out.println(userController.filterVehicleAsVolumeEngine(userController.filterVehicleReturnArray(admin.getProductsOfStore()),Integer.parseInt(splitCommand[4]),Integer.parseInt(splitCommand[5])));
                                                }
                                                else if(splitCommand[3].equals("manual")){
                                                    System.out.println(userController.filterVehicleAsManual(userController.filterVehicleReturnArray(admin.getProductsOfStore())));
                                                }
                                                else{
                                                    System.out.println(userController.filterVehicle(admin.getProductsOfStore()));
                                                }
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
                                                if(splitCommand[3].equals("color"))
                                                {
                                                    System.out.println(userController.filterPenAsColor(userController.filterPenReturnArray(userController.filterStationery(admin.getProductsOfStore())),splitCommand[4]));

                                                }
                                                else{
                                                    System.out.println(userController.filterStationeryAsPen(userController.filterStationery(admin.getProductsOfStore())));

                                                }

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


                case 5:
                    checkProduct=false;
                    break;



                    }
        }while (checkProduct);





    return"";}







}
