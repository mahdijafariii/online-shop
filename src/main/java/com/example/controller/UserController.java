package com.example.controller;

import com.example.exception.InvalidFormatEmailException;
import com.example.exception.InvalidFormatPhoneNumberException;
import com.example.exception.InvalidInputException;
import com.example.model.accountModel.*;
import com.example.model.productModel.ProductsModel;
import com.example.model.productModel.digitalProduct.*;
import com.example.model.productModel.foods.Food;
import com.example.model.productModel.stationery.NoteBook;
import com.example.model.productModel.stationery.Pen;
import com.example.model.productModel.stationery.Pencil;
import com.example.model.productModel.stationery.StationeryProduct;
import com.example.model.productModel.vehicle.Bike;
import com.example.model.productModel.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    private Pattern email = Pattern.compile("[_A-Za-z0-9-+]+\\.?[_A-Za-z0-9-+]+@gmail.com$");
    private Pattern password = Pattern.compile("(\\S){8,}");
    private Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
    private  Pattern phoneNumber = Pattern.compile("(\\S){11}");

    public boolean changeName(CustomerModel costumer,String userName , String password,String newFullName) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            costumer.setFullName(newFullName);
            return true;
        }
        else
            return false;
    }
    public boolean changePassword(CustomerModel costumer,String userName , String password,String newPassword) throws InvalidInputException {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            if(checkPasswordRegex(newPassword)){
                costumer.setPassword(newPassword);
                return true;
            }
            else
                throw new InvalidInputException("The format of Password is not correct !!");
        }
        else
            return false;
    }
    public boolean changeEmail(CustomerModel costumer,String userName , String password,String newEmail) throws InvalidFormatEmailException {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            if(checkEmailRegex(newEmail)){
                costumer.setEmail(newEmail);
                return true;
            }
            else
                throw new InvalidFormatEmailException("The format of Email is not correct !!");
        }
        else
            return false;
    }

    public void changePhoneNumber(CustomerModel costumer, String userName , String password, String newPhoneNumber) throws InvalidFormatPhoneNumberException {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            if(checkPhoneNumber(newPhoneNumber)){
                costumer.setPhoneNumber(newPhoneNumber);
            }
            else{
                throw new InvalidFormatPhoneNumberException("The phone Number pattern is not correct !!");
            }
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
    public ArrayList<Bike> filterBike(ArrayList<ProductsModel> products){
        ArrayList<Bike> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Bike){
                newProducts.add((Bike) products.get(i));
            }
        }

        return newProducts;}
    //-----------------------------------------------------------filter as engine volume !!

    public String filterVehicleAsVolumeEngine(ArrayList<Vehicle> products,int minVolume,int maxVolume ){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getEngineVolume()>minVolume && products.get(i).getEngineVolume()<maxVolume){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}

    //-----------------------------------------------------------filter vehicle as manual !!

    public ArrayList<Vehicle> filterVehicleAsManual(ArrayList<Vehicle> products ){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(!(products.get(i).isAutomatic())){
                newProducts.add(products.get(i));
            }
        }

        return newProducts;}
    //-----------------------------------------------------------filter ram of pc !!

    public String filterPcAsRAM(ArrayList<PersonalComputer> products ,int minRAM,int maxRAM ){
        ArrayList<PersonalComputer> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getRAM()>minRAM && products.get(i).getRAM()<maxRAM){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();}
    //-----------------------------------------------------------filter pen as color !!


    public String filterPenAsColor(ArrayList<Pen> products ,String color ){
        ArrayList<Pen> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(color.toLowerCase().compareTo(products.get(i).getColorOfPen().toLowerCase())==0){
                newProducts.add(products.get(i));
            }
        }
        StringBuilder test = new StringBuilder();
        for(int j=0;j<newProducts.size();j++){
            test.append(newProducts.get(j).toString()+"  \n");
        }
        return test.toString();
       }



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


    public ArrayList filterVehicleReturnArray(ArrayList<ProductsModel> products){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++) {
            if (products.get(i) instanceof Vehicle) {
                newProducts.add((Vehicle) products.get(i));
            }
        }
        return newProducts;}




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
    public ArrayList<PersonalComputer> filterPcReturnArray(ArrayList<DigitalProducts> products ){
        ArrayList<PersonalComputer> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof PersonalComputer){
                newProducts.add((PersonalComputer) products.get(i));
            }
        }
        return newProducts;}


    //--------------------------------------------------------filter Digital product as Usb!
    public ArrayList<Usb> filterDigitalProductAsUsb(ArrayList<DigitalProducts> products ){
        ArrayList<Usb> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Usb){
                newProducts.add((Usb) products.get(i));
            }
        }

        return newProducts;}


    //--------------------------------------------------------filter Digital product as SSD!
    public ArrayList<SSD> filterDigitalProductAsSSD(ArrayList<DigitalProducts> products ){
        ArrayList<SSD> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof SSD){
                newProducts.add((SSD) products.get(i));
            }
        }

        return newProducts;}


    //--------------------------------------------------------filter as Food!
    public ArrayList<Food> filterFood(ArrayList<ProductsModel> products){
        ArrayList<Food> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Food){
                newProducts.add((Food) products.get(i));
            }
        }
        return newProducts;}


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
    public ArrayList<Pen> filterPenReturnArray(ArrayList<StationeryProduct> products ){
        ArrayList<Pen> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Pen){
                newProducts.add((Pen)products.get(i));
            }
        }
        return newProducts;}
    public ArrayList<StationeryProduct> filterCategoryReArray(ArrayList<ProductsModel> products, String typeOfCategory){
        ArrayList<StationeryProduct> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getTypeCategory().name().toLowerCase().compareTo(typeOfCategory.toLowerCase())==0){
                newProducts.add((StationeryProduct) products.get(i));
            }
        }

        return newProducts;}//filter as a category !

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-filter stationery as pencil and type of pencil

    public ArrayList<Pencil> filterStationeryAsPencil(ArrayList<StationeryProduct> products ){
        ArrayList<Pencil> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Pencil){
                newProducts.add((Pencil) products.get(i));
            }
        }
        return newProducts;}


    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-filter stationery as NoteBook and number of leaves of NoteBook
    public ArrayList<NoteBook> filterStationeryAsNoteBook(ArrayList<StationeryProduct> products ){
        ArrayList<NoteBook> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof NoteBook){
                newProducts.add((NoteBook) products.get(i));
            }
        }
        return newProducts;}

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


    public ArrayList<ProductsModel> filterَAsPrice(ArrayList<ProductsModel> products,double minPrice,double maxPrice){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getPrice()<maxPrice && products.get(i).getPrice()>minPrice){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}
    //--------------------------------------------------------filter as a score of product

    public ArrayList<ProductsModel> filterَAsScore(ArrayList<ProductsModel> products,double minScore,double maxScore){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getAverageOfScores()<=maxScore && products.get(i).getAverageOfScores()>=minScore){
                newProducts.add(products.get(i));
            }
        }

        return newProducts;}
    //---------------------------------------------------------search by name
    public ArrayList<ProductsModel> searchInProduct(ArrayList<ProductsModel> products,String test){
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


        return newProducts;}
    public String searchExactInProduct(ArrayList<ProductsModel> products,String iD){
        for(int i=0 ;i<products.size();i++){
            if(products.get(i).getProductID().equals(iD)){
                return products.get(i).toString()+"\n\n";
            }
        }
        return "-";}
    //---------------------------------------------------------com.example.view of cart
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
            test.append((i+1)+")Name:"+customerModel.getPurchaseHistory().get(i).getName()+"  --  ID:");
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
    public int finalizeBuy(ArrayList<String> discount,CustomerModel customerModel ,AdminModel admin) {
        InvoiceController invoiceController = new InvoiceController();
        InvoiceModel test = new InvoiceModel(customerModel);
        test.setTotalPrice(invoiceController.calculateInvoice(test,calculateDiscount(discount,admin,customerModel)));//you should set it manual and function is in invoice com.example.controller
        int checkBalance = invoiceController.deductFromBalance(test, customerModel);//check balance manual and mines price of product from balance
        if (checkBalance == 1) {
            for(int i =0 ; i <admin.getProductsOfStore().size();i++){
                for(int j=0;j<customerModel.getCart().size();j++){
                    if(admin.getProductsOfStore().get(i).getProductID().equals(customerModel.getCart().get(j).getProductID())){
                        if(admin.getProductsOfStore().get(i).getCountInCapacity()!=0) {//check balance of product in capacity
                            admin.getProductsOfStore().get(i).setCountInCapacity(admin.getProductsOfStore().get(i).getCountInCapacity() - 1);//mines balance !!
                            customerModel.getPurchaseHistory().add(customerModel.getCart().get(j));//when you want to set score it is in purchased history!!
                        }
                        else{
                            return -5;//one of the product is not in capacity!!
                        }

                    }
                }
            }
            customerModel.getInvoiceHistory().add(test);
            return 1;
        }
        else
        {
            return -1;
        }

    }
    //--------------------------------------------------------- calculate without discount
    public double calculateWithoutDiscount(CustomerModel customerModel,ArrayList<String> discount ,AdminModel admin){

        for(int i = 0 ;i< customerModel.getCart().size(); i++){
            customerModel.getCart().set(i,null);
        }
        double count=0 ;
        for(int j = 0 ; j<discount.size() ; j++){
            for(int k = 0  ;k< admin.getDiscountCodes().size() ; k++){
                if(discount.get(j).equals(admin.getDiscountCodes().get(k).getCode())){
                    count=count+admin.getDiscountCodes().get(k).getAmountDiscount();
                }
            }
        }
      return   ((customerModel.getInvoiceHistory().get(customerModel.getInvoiceHistory().size()-1).getTotalPrice()*100)/(100-count));

    }
    //---------------------------------------------------------calculate discount code
    public double calculateDiscount(ArrayList<String> discount , AdminModel admin,CustomerModel customer){


        if(discount.size()==0){
            return 0;
        }
        double amountDiscount =0 ;
        for(int i = 0 ; i<discount.size() ; i++){
            if(checkDiscount(discount.get(i),admin)){

                int numDiscountInList=-1;
                for(int k = 0 ; k <admin.getDiscountCodes().size() ; k++){
                    if(admin.getDiscountCodes().get(k).getCode().equals(discount.get(i))){
                        numDiscountInList=k;
                        break;
                    }
                }
                if(discount.get(i).split("-")[2].toLowerCase().equals("foods") || discount.get(i).split("-")[2].toLowerCase().equals("digital_products") ||discount.get(i).split("-")[2].toLowerCase().equals("vehicles") ||discount.get(i).split("-")[2].toLowerCase().equals("stationery")){
                    for(int j=0 ; j<customer.getCart().size() ; j++ ){
                        if (customer.getCart().get(j).getTypeCategory().name().equals(discount.get(i).split("-")[2])){
                            amountDiscount=customer.getCart().get(j).getPrice()*((admin.getDiscountCodes().get(numDiscountInList).getAmountDiscount())/100)+amountDiscount;
                        }
                    }
                    admin.getDiscountCodes().get(numDiscountInList).setDiscountCodeCapacity(admin.getDiscountCodes().get(numDiscountInList).getDiscountCodeCapacity()-1);
                }
                else if (discount.get(i).split("-")[2].startsWith("0")){
                    for(int j=0 ; j<customer.getCart().size() ; j++ ){
                            amountDiscount=customer.getCart().get(j).getPrice()*((admin.getDiscountCodes().get(numDiscountInList).getAmountDiscount())/100)+amountDiscount;
                    }
                    admin.getDiscountCodes().get(numDiscountInList).setDiscountCodeCapacity(admin.getDiscountCodes().get(numDiscountInList).getDiscountCodeCapacity()-1);

                }
                else{
                    for(int j=0 ; j<customer.getCart().size() ; j++ ){
                        if (customer.getCart().get(j).getName().equals(discount.get(i).split("-")[2])){
                            amountDiscount=customer.getCart().get(j).getPrice()*((admin.getDiscountCodes().get(numDiscountInList).getAmountDiscount())/100)+amountDiscount;
                        }
                    }
                    admin.getDiscountCodes().get(numDiscountInList).setDiscountCodeCapacity(admin.getDiscountCodes().get(numDiscountInList).getDiscountCodeCapacity()-1);
                }
            }
        }
        return amountDiscount;
    }

    public boolean checkDiscount(String discount , AdminModel admin){
        int numInDiscountList=-1 ;
        for(int i= 0 ; i <admin.getDiscountCodes().size() ; i++){
            if(admin.getDiscountCodes().get(i).getCode().equals(discount)){
                numInDiscountList=i;
                break;
            }
        }
        if(numInDiscountList==-1){
            return false;
        }
        if(admin.getDiscountCodes().get(numInDiscountList).getDiscountCodeCapacity()==0){
            System.out.println(admin.getDiscountCodes().get(numInDiscountList).getDiscountCodeCapacity());
            return false;
        }
        if(admin.getDiscountCodes().get(numInDiscountList).getTime().before(new Date(2021,12,29))){
            System.out.println(admin.getDiscountCodes().get(numInDiscountList).getTime());
            return false;
        }
        return true;
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
            if(admin.getProductsOfStore().get(i).getProductID().equals(id)) {
                check = i;
                break;
            }

        }
        if(check==-1){
            return -1;//we do not have this product in our store!!
        }
        ScoreModel score=new ScoreModel(user,newScore,admin.getProductsOfStore().get(check));
        for(int j=0;j<user.getPurchaseHistory().size();j++){
            if(user.getPurchaseHistory().get(j).getProductID().equals(id)){
                double beforeScore=admin.getProductsOfStore().get(check).getAverageOfScores();
                admin.getProductsOfStore().get(check).setAverageOfScores(((beforeScore+newScore)/2));
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
    //----------------------------------------------------------see before invoices
    public String beforeInvoice(CustomerModel customerModel){
        StringBuilder test = new StringBuilder();
        for(int i = 0 ; i <customerModel.getInvoiceHistory().size(); i++){
            test.append((i+1)+")"+customerModel.getInvoiceHistory().get(i).toString()+"\n\n");
        }
    return test.toString();}


    //----------------------------------------------------------see discounts
    public String showDiscounts(CustomerModel customerModel){
        StringBuilder test = new StringBuilder();
        for (int i = 0 ; i <customerModel.getDiscountCodes().size() ; i++ ){
            test.append(customerModel.getDiscountCodes().get(i).toString());
            test.append("\n");
        }
        return test.toString();
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
    public boolean checkPhoneNumber(String phoneNumberNew)
    {
        Matcher phoneNumber=this.phoneNumber.matcher(phoneNumberNew);
        return phoneNumber.find();
    }//regex of email



}
