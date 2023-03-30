package model.accountModel;

import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

import java.util.ArrayList;

public class CustomerModel extends AccountModel{
    private String fullName;
    final private ArrayList<ProductsModel> cart ;
    final private ArrayList<ProductsModel> purchaseHistory;
    private double balance ;
    CustomerModel(String name,String email ,String phoneNumber , String password,double balance,String fullName){
        super(name,email,phoneNumber,password);
        this.balance=balance;
        cart = new ArrayList<>();
        purchaseHistory=new ArrayList<>();
        this.fullName=fullName;
    }

    public ArrayList<ProductsModel> getCart() {
        return cart;
    }

    public ArrayList<ProductsModel> getPurchaseHistory() {
        return purchaseHistory;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
