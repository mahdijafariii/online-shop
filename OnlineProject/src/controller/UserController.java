package controller;

import model.accountModel.*;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;
import model.productModel.digitalProduct.*;
import model.productModel.foods.Food;
import model.productModel.stationery.NoteBook;
import model.productModel.stationery.Pen;
import model.productModel.stationery.Pencil;
import model.productModel.stationery.StationeryProduct;
import model.productModel.vehicle.Bike;
import model.productModel.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    Pattern email = Pattern.compile("[_A-Za-z0-9-+]+\\.?[_A-Za-z0-9-+]+@gmail.com$");
    Pattern password = Pattern.compile("(\\S){8,}");
    Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
    public boolean changeName(CustomerModel costumer,String userName , String password,String newFullName) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            costumer.setFullName(newFullName);
            return true;
        }
        else
            return false;
    }
    public boolean changePassword(CustomerModel costumer,String userName , String password,String newPassword) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            if(checkPasswordRegex(newPassword)){
                costumer.setPassword(newPassword);
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    public boolean changeEmail(CustomerModel costumer,String userName , String password,String newEmail) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            if(checkEmailRegex(newEmail)){
                costumer.setEmail(newEmail);
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public void changePhoneNumber(CustomerModel costumer, String userName , String password, String newPhoneNumber) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            costumer.setPhoneNumber(newPhoneNumber);
        }
    }
    //--------------------------------------------------------filter product as category

    public String filterCategory(ArrayList<ProductsModel> products, String typeOfCategory){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getTypeCategory().name().toLowerCase().compareTo(typeOfCategory.toLowerCase())==0){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
    return test.toString();}//filter as a category !

    //--------------------------------------------------------filter vehicle as bike and type of bike
    public String filterBike(ArrayList<ProductsModel> products){
        ArrayList<Bike> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Bike){
                newProducts.add((Bike) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}



    //--------------------------------------------------------filter as vehicle as volume and automatic and manual
    public String filterVehicle(ArrayList<ProductsModel> products){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++) {
            if (products.get(i) instanceof Vehicle) {
                newProducts.add((Vehicle) products.get(i));
            }
        }
            StringBuilder test = new StringBuilder();
            for(int j=0;j<newProducts.size();j++){
                test.append(newProducts.get(j).toString()+"  \n");
            }
        return test.toString();}


    //--------------------------------------------------------filter as Digital product!
    public ArrayList<DigitalProducts> filterDigitalProduct(ArrayList<ProductsModel> products){
        ArrayList<DigitalProducts> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof DigitalProducts){
                newProducts.add((DigitalProducts) products.get(i));
            }
        }
        return newProducts;}


    //--------------------------------------------------------filter Digital product as capacity of ssd and usb!
    public String filterDigitalProductAsCapacity(ArrayList<DigitalProducts> products,int min,int max ){
        ArrayList<DigitalProducts> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof StorageEquipment){
                if(((StorageEquipment) products.get(i)).getCapacity()>min && ((StorageEquipment)products.get(i)).getCapacity()<max){
                    newProducts.add((StorageEquipment) products.get(i));
                }
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}
    //--------------------------------------------------------filter Digital product as personal computer
    public String filterDigitalProductAsPc(ArrayList<DigitalProducts> products ){
        ArrayList<PersonalComputer> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof PersonalComputer){
                newProducts.add((PersonalComputer) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}


    //--------------------------------------------------------filter Digital product as Usb!
    public String filterDigitalProductAsUsb(ArrayList<DigitalProducts> products ){
        ArrayList<Usb> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Usb){
                newProducts.add((Usb) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}


    //--------------------------------------------------------filter Digital product as SSD!
    public String filterDigitalProductAsSSD(ArrayList<DigitalProducts> products ){
        ArrayList<SSD> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof SSD){
                newProducts.add((SSD) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}


    //--------------------------------------------------------filter as Food!
    public String filterFood(ArrayList<ProductsModel> products){
        ArrayList<Food> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Food){
                newProducts.add((Food) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}


    //--------------------------------------------------------filter as Stationery!
    public ArrayList<StationeryProduct> filterStationery(ArrayList<ProductsModel> products){
        ArrayList<StationeryProduct> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof StationeryProduct){
                newProducts.add((StationeryProduct) products.get(i));
            }
        }

        return newProducts;}
    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*filter stationery as pen and pen color

    public String filterStationeryAsPen(ArrayList<StationeryProduct> products ){
        ArrayList<Pen> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Pen){
                newProducts.add((Pen)products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-filter stationery as pencil and type of pencil

    public String filterStationeryAsPencil(ArrayList<StationeryProduct> products ){
        ArrayList<Pencil> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Pencil){
                newProducts.add((Pencil) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}


    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-filter stationery as NoteBook and number of leaves of NoteBook
    public String filterStationeryAsNoteBook(ArrayList<StationeryProduct> products ){
        ArrayList<NoteBook> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof NoteBook){
                newProducts.add((NoteBook) products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}

    //--------------------------------------------------------filter as a capacity of product


    public String filterَAsCapacity(ArrayList<ProductsModel> products){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getCountInCapacity()>0){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}
    //--------------------------------------------------------filter as a price of product


    public String filterَAsPrice(ArrayList<ProductsModel> products,double minPrice,double maxPrice){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getPrice()<maxPrice && products.get(i).getPrice()>minPrice){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}
    //--------------------------------------------------------filter as a score of product

    public String filterَAsScore(ArrayList<ProductsModel> products,double minScore,double maxScore){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getAverageOfScores()<=maxScore && products.get(i).getAverageOfScores()>=minScore){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}
    //---------------------------------------------------------search by name
    public String searchInProduct(ArrayList<ProductsModel> products,String test){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        char[] search = test.toCharArray();
        int count=0;
        for(int i=0;i<products.size();i++){
            for(int j=0 ; j<products.get(i).getName().length();j++) {
                for(int k=0;k<search.length;k++){
                    if(products.get(i).getName().charAt(j)==search[k]){
                        count++;
                        break;
                    }
                }

            }
            if (count>(search.length/2+1)){
                newProducts.add(products.get(i));
                count=0;
            }
        }
            StringBuilder show = new StringBuilder();
            for(int j=0;j<newProducts.size();j++){
                show.append(newProducts.get(j).toString()+"  \n");
            }

        return show.toString();}
    public String searchExactInProduct(ArrayList<ProductsModel> products,String iD){
        for(int i=0 ;i<products.size();i++){
            if(products.get(i).getName().equals(iD)){
                return products.get(i).toString()+"\n\n";
            }
        }
        return "We do not have product with this id!!";}
    //---------------------------------------------------------view of cart
    public String seeCart(CustomerModel user){
        StringBuilder test = new StringBuilder();
        if(user.getCart().size()==0){
            System.out.println("you do not have add any product to your cart!!!");
        }
        for(int i=0;i<user.getCart().size();i++){
            test.append((i+1)+")");
            test.append(user.getCart().get(i).getName());
            test.append("    "+"price:"+user.getCart().get(i).getPrice()+"    "+"ID:"+user.getCart().get(i).getProductID()+"\n");
        }

    return test.toString();}
    //---------------------------------------------------------getPurchasedHistory!
    public String getPurchasedHistory(CustomerModel customerModel){
        StringBuilder test =new StringBuilder();
        for(int i=0;i<customerModel.getPurchaseHistory().size();i++){
            test.append((i+1)+"Name:"+customerModel.getPurchaseHistory().get(i).getName()+"  --  ID:");
            test.append(customerModel.getPurchaseHistory().get(i).getProductID()+"  -- Price:");
            test.append(customerModel.getPurchaseHistory().get(i).getPrice()+"  \n\n");
        }
        if(test.toString()==null){
            return "you dose not have any buy!!";
        }
        else{
            return test.toString();
        }
    }
    //----------------------------------------------------------finalize buy!!
    public int finalizeBuy(CustomerModel customerModel ,AdminModel admin) {
        InvoiceController invoiceController = new InvoiceController();
        InvoiceModel test = new InvoiceModel(customerModel.getCart());
        test.setTotalPrice(invoiceController.calculateInvoice(test));
        int checkBalance = invoiceController.deductFromBalance(test, customerModel);
        if (checkBalance == 1) {
            customerModel.getInvoiceHistory().add(test);
            for(int i =0 ; i <admin.getProductsOfStore().size();i++){
                for(int j=0;j<customerModel.getCart().size();j++){
                    if(admin.getProductsOfStore().get(i).getProductID().equals(customerModel.getCart().get(j).getProductID())){
                        if(admin.getProductsOfStore().get(i).getCountInCapacity()!=0) {
                            admin.getProductsOfStore().get(i).setCountInCapacity(admin.getProductsOfStore().get(i).getCountInCapacity() - 1);
                            customerModel.getPurchaseHistory().add(customerModel.getCart().get(j));//when you want to set score it is in purchased history!!
                            customerModel.getCart().remove(j);
                        }
                        else{
                            return -5;//one of the product is not in capacity!!
                        }

                    }
                }
            }
            return 1;
        }
        else
        {
            return -1;
        }

    }










    //---------------------------------------------------------buy product
    public int buyProductByID(CustomerModel user ,String Id,AdminModel admin,int count){
        for(int i =0 ; i<admin.getProductsOfStore().size();i++){
            if(admin.getProductsOfStore().get(i).getProductID().equals(Id)){
                if(admin.getProductsOfStore().get(i).getCountInCapacity()>count){
                    for(int j=0;j<count;j++) {
                        user.getCart().add(admin.getProductsOfStore().get(i));
                    }
                    return 1;//add successfully
                }
                else {
                    return -2;//we do not have this volume of product
                }
            }

        }
    return -1;}//we do not have product with this id in our products!!
    //---------------------------------------------------------comment
    public void comment(CustomerModel user, String IdProduct , AdminModel admin,String comment){
        OpinionRequestModel opinion=new OpinionRequestModel(user,IdProduct,comment);
        for (int i =0;i<user.getPurchaseHistory().size();i++){
            if(user.getPurchaseHistory().get(i).getProductID()==IdProduct){
                opinion.setUserBuyProduct(true);
                break;
            }
        }
        admin.getComments().add(opinion);
    }
    //---------------------------------------------------------set score
    public int setScore(CustomerModel user, double newScore, AdminModel admin,String id){
        int check=-1;
        for (int i =0;i<admin.getProductsOfStore().size();i++){
            admin.getProductsOfStore().get(i).getProductID().equals(id);
            check=i;
            break;
        }
        if(check==-1){
            return -1;//we do not have this product in our store!!
        }
        ScoreModel score=new ScoreModel(user,newScore,admin.getProductsOfStore().get(check));
        for(int j=0;j<user.getPurchaseHistory().size();j++){
            if(user.getPurchaseHistory().get(j).getProductID().equals(id)){
                score.setScore((score.getProducts().getAverageOfScores()+newScore)/2);
                return 1;
            }
        }
        return -2;
    }
//-------------------------------------------------------------charging account
    public int chargeBalance(CustomerModel user,String charge , String cardNumber,String cvv2 ,String cardPass,AdminModel admin){
        if(!(checkCardNumber(cardNumber))) {
            return -1;
        }
        else if(!(checkCvv2(cvv2))){
            return -2;
        }
        else if(!(checkPassOfCard(cardPass))){
            return -3;
        }
        else  {
            ChargeRequestModel test = new ChargeRequestModel(user, charge,cvv2,cardNumber,cardPass);
            admin.getChargeRequest().add(test);
            return 1;
        }

    }
    //-----------------------------------------------------------all of regex
    public boolean checkCardNumber(String cardNumber){
        Pattern pattern = Pattern.compile("^[0-9]{16}$");
        Matcher matcher = pattern.matcher(cardNumber);
        if(matcher.find()){
            return true;
        }
        else return false;
    }
    public boolean checkCvv2(String cardNumber){
        Pattern pattern = Pattern.compile("^[0-9]{3}$");
        Matcher matcher = pattern.matcher(cardNumber);
        if(matcher.find()){
            return true;
        }
        else return false;
    }
    public boolean checkPassOfCard(String cardNumber){
        Pattern pattern = Pattern.compile("^[0-9]{6}$");
        Matcher matcher = pattern.matcher(cardNumber);
        if(matcher.find()){
            return true;
        }
        else return false;
    }


    public boolean checkPasswordRegex(String passwordCheck)
    {
        Matcher passMatcher = password.matcher(passwordCheck);
        Matcher passMatcher2 = password2.matcher(passwordCheck);
        if (passMatcher.find() & passMatcher2.find()) {
            return true;
        } else
            return false;
    }//regex of password
    public boolean checkEmailRegex(String email)
    {
        Matcher emailMatcher=this.email.matcher(email);
        return emailMatcher.find();
    }//regex of email


}
