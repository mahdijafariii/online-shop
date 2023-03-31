package controller;

import model.accountModel.CustomerModel;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;
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

    public boolean changePhoneNumber(CustomerModel costumer,String userName , String password,String newPhoneNumber) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            costumer.setPhoneNumber(newPhoneNumber);
            return true;
        }
        else
            return false;
    }
    public ArrayList<ProductsModel> filterCategory(ArrayList<ProductsModel> products, CategoryModel type){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getTypeCategory().name().toUpperCase().compareTo(type.toString().toLowerCase())==0){
                newProducts.add(products.get(i));
            }
        }
    return newProducts;}//filter as a category !

    //--------------------------------------------------------Bike filtering
    public ArrayList<Bike> filterBike(ArrayList<ProductsModel> products){
        ArrayList<Bike> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Bike){
                newProducts.add((Bike) products.get(i));
            }
        }
        return newProducts;}
    public ArrayList<Bike> filterBikeAsType(ArrayList<Bike> products,String typeOfBike){
        ArrayList<Bike> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(typeOfBike.toLowerCase().compareTo(products.get(i).getType().toLowerCase())==0){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}



    //--------------------------------------------------------filter as vehicle
    public ArrayList<Vehicle> filterVehicle(ArrayList<ProductsModel> products){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i) instanceof Vehicle){
                newProducts.add((Vehicle) products.get(i));
            }
        }
        return newProducts;}
    public ArrayList<Vehicle> filterVehicleAsVolumeEngine(ArrayList<Vehicle> products,int minVolume,int maxVolume ){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getEngineVolume()>minVolume && products.get(i).getEngineVolume()<maxVolume){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}

    public ArrayList<Vehicle> filterVehicleAsAutomatic(ArrayList<Vehicle> products ){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).isAutomatic()){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}

    public ArrayList<Vehicle> filterVehicleAsManual(ArrayList<Vehicle> products ){
        ArrayList<Vehicle> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(!(products.get(i).isAutomatic())){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}


    //--------------------------------------------------------


    public ArrayList<ProductsModel> filterَAsCapacity(ArrayList<ProductsModel> products){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getCountInCapacity()>0){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}//filter as a capacity of product
    // --------------------------------------------------------


    public ArrayList<ProductsModel> filterَAsPrice(ArrayList<ProductsModel> products,double minPrice,double maxPrice){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getPrice()<maxPrice && products.get(i).getPrice()>minPrice){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}
    public ArrayList<ProductsModel> filterَAsScore(ArrayList<ProductsModel> products,double minScore,double maxScore){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getAverageOfScores()<maxScore && products.get(i).getAverageOfScores()>minScore){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}


    public ArrayList<ProductsModel> filterَAsFieldInCategory(ArrayList<ProductsModel> products){
        ArrayList<ProductsModel> newProducts= new ArrayList<>();
        for(int i=0;i<products.size();i++){

            if(){
                newProducts.add(products.get(i));
            }
        }
        return newProducts;}//you should give the list of filterAsCategory to this function






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
