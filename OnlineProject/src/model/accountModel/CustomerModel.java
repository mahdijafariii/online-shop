package model.accountModel;

import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

import java.util.ArrayList;

public class CustomerModel extends AccountModel{
    final private ArrayList<ProductsModel> cart ;
    final private ArrayList<ProductsModel> purchaseHistory;
    private double balance ;
    CustomerModel(String name,String email ,String phoneNumber , String password,double balance){
        super(name,email,phoneNumber,password);
        this.balance=balance;
        cart = new ArrayList<>();
        purchaseHistory=new ArrayList<>();
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
}
