package controller;

import model.accountModel.AdminModel;
import model.accountModel.CustomerModel;
import model.accountModel.DiscountCode;
import model.productModel.CategoryModel;
import model.productModel.digitalProduct.PersonalComputer;
import model.productModel.digitalProduct.SSD;
import model.productModel.digitalProduct.Usb;
import model.productModel.foods.Food;
import model.productModel.stationery.NoteBook;
import model.productModel.stationery.Pen;
import model.productModel.stationery.Pencil;
import model.productModel.vehicle.Bike;
import model.productModel.vehicle.Vehicle;

import javax.xml.stream.events.Comment;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;


public class AdminController {
    private AdminModel admin = AdminModel.getAdmin();



    //*************************************************************add vehicle

    public void addBike(String name, double price, int countInCapacity, int type, String nameOfCreator) {
        if (type == 1) {
            Bike test = new Bike(name, price, countInCapacity, 10, CategoryModel.VEHICLES, nameOfCreator, Bike.typeOfBike.CITY_TYPE);
            admin.getProductsOfStore().add(test);


        } else if (type == 2) {
            Bike test = new Bike(name, price, countInCapacity, 10, CategoryModel.VEHICLES, nameOfCreator, Bike.typeOfBike.HYBRID_TYPE);
            admin.getProductsOfStore().add(test);

        } else if (type == 3) {
            Bike test = new Bike(name, price, countInCapacity, 10, CategoryModel.VEHICLES, nameOfCreator, Bike.typeOfBike.ROAD_TYPE);
            admin.getProductsOfStore().add(test);


        } else if (type == 4) {
            Bike test = new Bike(name, price, countInCapacity, 10, CategoryModel.VEHICLES, nameOfCreator, Bike.typeOfBike.MOUNTAIN_TYPE);
            admin.getProductsOfStore().add(test);


        }
    }

    public void addVehicle(String name, double price, int countInCapacity, String nameOfCreator, boolean Automatic, int engineVolume) {
        Vehicle test = new Vehicle(name, price, countInCapacity, 10, CategoryModel.VEHICLES, nameOfCreator, Automatic, engineVolume);
        admin.getProductsOfStore().add(test);

    }

    //*************************************************************add stationery
    public void addNoteBook(String name, double price, int countInCapacity, String nameOfCreator, int numberLeaves, String typeLeaves) {
        NoteBook test = new NoteBook(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, numberLeaves, typeLeaves);
        admin.getProductsOfStore().add(test);

    }

    public void addPen(String name, double price, int countInCapacity, String nameOfCreator, String color) {
        Pen test = new Pen(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, color);
        admin.getProductsOfStore().add(test);

    }

    public void addPencil(String name, double price, int countInCapacity, String nameOfCreator, String color, int type) {
        if (type == 1) {
            Pencil test = new Pencil(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, color, Pencil.typeOfPencil.B);
            admin.getProductsOfStore().add(test);
        } else if (type == 2) {
            Pencil test = new Pencil(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, color, Pencil.typeOfPencil.F);
            admin.getProductsOfStore().add(test);
        } else if (type == 3) {
            Pencil test = new Pencil(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, color, Pencil.typeOfPencil.HB);
            admin.getProductsOfStore().add(test);
        } else if (type == 4) {
            Pencil test = new Pencil(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, color, Pencil.typeOfPencil.H2);
            admin.getProductsOfStore().add(test);
        } else if (type == 5) {
            Pencil test = new Pencil(name, price, countInCapacity, 10, CategoryModel.STATIONERY, nameOfCreator, color, Pencil.typeOfPencil.H);
            admin.getProductsOfStore().add(test);
        }

    }

    //*************************************************************add food
    public void addFood(String name, double price, int countInCapacity, int dateProduction, int dateExpiration) {
        Food test = new Food(name, price, countInCapacity, 10, CategoryModel.FOODS, dateProduction, dateExpiration);
        admin.getProductsOfStore().add(test);
    }

    //*************************************************************add digital product
    public void addPersonalComputer(String name, double price, int countInCapacity, double weight, String dimension, String modelCpu, int RAM) {
        PersonalComputer test = new PersonalComputer(name, price, countInCapacity, 10, CategoryModel.DIGITAL_PRODUCTS, weight, dimension, modelCpu, RAM);
        admin.getProductsOfStore().add(test);
    }

    public void addSSD(String name, double price, int countInCapacity, double weight, String dimension, double capacity, int reading, int writing) {
        SSD test = new SSD(name, price, countInCapacity, 10, CategoryModel.DIGITAL_PRODUCTS, weight, dimension, capacity, reading, writing);
        admin.getProductsOfStore().add(test);

    }

    public void addUsb(String name, double price, int countInCapacity, double weight, String dimension, double capacity, int version) {
        Usb test = new Usb(name, price, countInCapacity, 10, CategoryModel.DIGITAL_PRODUCTS, weight, dimension, capacity, version);
        admin.getProductsOfStore().add(test);

    }
    //*************************************************************remove product
    public void removeProduct(String productId){
        for(int i =0 ; i <admin.getProductsOfStore().size();i++){
            if(admin.getProductsOfStore().get(i).getProductID().equals(productId)){
                admin.getProductsOfStore().remove(i);
                break;
            }
        }
    }


    //*************************************************************edit product info
    public boolean editInfo(String ID, String type, String newType) {
        int numberInlist = -1;
        for (int i = 0; i < admin.getProductsOfStore().size(); i++) {
            if (admin.getProductsOfStore().get(i).getProductID() == ID) {
                numberInlist = i;
                break;
            }
        }
        if (numberInlist == -1) {
            return false;
        }
        else if (type.equals("price")) {
            admin.getProductsOfStore().get(numberInlist).setPrice(Integer.parseInt(newType));
            return true;
        }
        else if (type.equals("name")) {
            admin.getProductsOfStore().get(numberInlist).setName(newType);
            return true;

        }
        else if (type.equals("capacity")) {
            admin.getProductsOfStore().get(numberInlist).setCountInCapacity(Integer.parseInt(newType));
            return true;

        }


        return true;
    }
    //*************************************************************comment
    public void acceptComment(int opinionNumb){
        int numberOfComment=0;
        int numberOfProduct=0;
        String findProductAddComment=null;
        for(int i=0 ; i <admin.getComments().size(); i++){
            if(admin.getComments().get(i).getOpinionNumb()==opinionNumb){
                numberOfComment=i;
                findProductAddComment=admin.getComments().get(i).getProductId();
                break;
                }
        }
            for(int j = 0 ; j<admin.getProductsOfStore().size();j++){
                if(admin.getProductsOfStore().get(j).getProductID().equals(findProductAddComment)){
                    numberOfProduct=j;
                    break;
                }
            }
                admin.getProductsOfStore().get(numberOfProduct).getCommentsOfProduct().add(admin.getComments().get(numberOfComment));
                admin.getComments().remove(numberOfComment);
        }

    public void rejectComment(int opinionNumb){
        for(int i =0 ; i <admin.getComments().size();i++){
            if(admin.getComments().get(i).getOpinionNumb()==opinionNumb){
                admin.getComments().remove(i);
                break;
            }
        }
        }

    //*************************************************************charge requests
    public void chargeAccept(int numberInList){
        for(int i =0; i<admin.getChargeRequest().size();i++){
            if(admin.getChargeRequest().get(i).getNumberRequest()==numberInList){
                double balance=admin.getChargeRequest().get(i).getCustomer().getBalance();
                double amount=Double.parseDouble(admin.getChargeRequest().get(i).getAmount());
                admin.getChargeRequest().get(i).getCustomer().setBalance(balance+amount);
                admin.getChargeRequest().remove(admin.getChargeRequest().get(i));
                break;
            }
        }

    }
    public void chargeRejected(int numberInList) {
        for (int i = 0; i < admin.getChargeRequest().size(); i++) {
            if (admin.getChargeRequest().get(i).getNumberRequest() == numberInList) {
                admin.getChargeRequest().remove(admin.getChargeRequest().get(i));
                break;
            }
        }

    }
    //*************************************************************sign up requests
    public void acceptSignUp(int numberInList){
        for(int i =0; i<admin.getSignUpRequest().size();i++){
            if(admin.getSignUpRequest().get(i).getNumberOfRequest()==numberInList){
                CustomerModel test = new CustomerModel(admin.getSignUpRequest().get(i).getUserName(),admin.getSignUpRequest().get(i).getEmail(),admin.getSignUpRequest().get(i).getPhoneNumber(),admin.getSignUpRequest().get(i).getPassWord(),admin.getSignUpRequest().get(i).getFullName());
                admin.getAllCostumers().add(test);
                admin.getSignUpRequest().remove(admin.getSignUpRequest().get(i));
                break;
            }
        }
    }
    public void rejectSignUp(int numberInList){
        for(int i =0; i<admin.getSignUpRequest().size();i++){
            if(admin.getSignUpRequest().get(i).getNumberOfRequest()==numberInList){
                admin.getSignUpRequest().remove(admin.getSignUpRequest().get(i));
                break;
            }
        }
    }


    //*************************************************************see costumers
    public String costumers(){
        StringBuilder test = new StringBuilder();
        for (int j = 0 ; j<admin.getAllCostumers().size();j++){
            test.append((j+1)+")"+admin.getAllCostumers().get(j).toString()+"  --  phone number:"+admin.getAllCostumers().get(j).getPhoneNumber()+"\n");
        }
        return test.toString();
    }
    //************************************************************see list comment of product
    public String listCommentsOfProduct(){

        StringBuilder test = new StringBuilder();
        for (int j = 0 ; j<admin.getComments().size();j++){
            test.append((j+1)+")"+admin.getComments().get(j).toString()+"\n");
        }
        return test.toString();
    }
    //************************************************************see list of sign up
    public String listOfSignUp(){

        StringBuilder test = new StringBuilder();
        for (int j = 0 ; j<admin.getSignUpRequest().size();j++){
            test.append((j+1)+")"+admin.getSignUpRequest().get(j).toString()+"\n");
        }
        return test.toString();
    }
    //*************************************************************see list charge request

    public String listChargeRequest(){

        StringBuilder test = new StringBuilder();
        for (int j = 0 ; j<admin.getChargeRequest().size();j++){
            test.append((j+1)+")"+admin.getChargeRequest().get(j).toString()+"\n");
        }
        return test.toString();
    }
    //*************************************************************
    public int checkUserNamePass(String userName, String password){
        for(int i=0; i<admin.getAllCostumers().size();i++){
            if(admin.getAllCostumers().get(i).getUserName().equals(userName)){
                if(admin.getAllCostumers().get(i).getPassword().equals(password)){
                    return i;
                }
            }
        }
    return -1;}
    //*************************************************************
    public void generateCategoryDiscount(String category , double amountOfDiscount , int year , int month , int day , int capacity){


        DiscountCode discountCode = new DiscountCode(amountOfDiscount,new Date(year,month,day),capacity,category.toUpperCase());
        admin.getDiscountCodes().add(discountCode);

    }
    //*************************************************************

    public void generateNormalDiscount( double amountOfDiscount , int year , int month , int day , int capacity){
        DiscountCode discountCode = new DiscountCode(amountOfDiscount,new Date(year,month,day),capacity);
        admin.getDiscountCodes().add(discountCode);
    }
    //*************************************************************

    public void generateSpecialDiscount(String name , double amountOfDiscount , int year , int month , int day , int capacity ){
        DiscountCode discountCode = new DiscountCode(amountOfDiscount,new Date(year,month,day),name,capacity);
        admin.getDiscountCodes().add(discountCode);
    }
    //*************************************************************

    public String showAllDiscounts(){
        StringBuilder test = new StringBuilder();
        for(int i = 0 ; i < admin.getDiscountCodes().size() ; i++){
            test.append((i+1)+")"+admin.getDiscountCodes().get(i).toString());
            test.append("\n");
        }
        return test.toString();
    }
    //*************************************************************

    public void addDiscountWithZeroBuy(){
        DiscountCode discountCode = new DiscountCode(10,new Date(5000,12,30),1);
        for(int i =0 ; i<admin.getAllCostumers().size() ; i++){
            if(admin.getAllCostumers().get(i).getInvoiceHistory().size()==0){
                admin.getAllCostumers().get(i).getDiscountCodes().add(discountCode);
            }
        }
        admin.getDiscountCodes().add(discountCode);
    }
    //*************************************************************
    public void giveDiscountToCustomer(int discount , int customer){
        admin.getAllCostumers().get(customer-1).getDiscountCodes().add(admin.getDiscountCodes().get(discount-1));
    }
    //*************************************************************


}

