package controller;

import model.accountModel.CustomerModel;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {
    Pattern email = Pattern.compile("[_A-Za-z0-9-+]+\\.?[_A-Za-z0-9-+]+@gmail.com$");
    Pattern password = Pattern.compile("(\\S){8,}");
    Pattern password2 = Pattern.compile("(.*[a-z])(.*[0-9])[a-z0-9#.!@$*&_]");
    public boolean changeName(CustomerModel costumer,String userName , String password,String newFullName) {
        if(userName.compareTo(costumer.getUserName())==0 && password.compareTo(costumer.getPassword())==0){
            costumer.setUserName(newFullName);
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
            if(products.get(i).getTypeCategory().name().compareTo(type.toString())==0){
                newProducts.add(products.get(i));
            }
        }
    return newProducts;}





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
