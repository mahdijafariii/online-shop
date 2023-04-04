package model.accountModel;

import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

import java.util.ArrayList;

public class CustomerModel extends AccountModel{
    private String fullName;
    private ArrayList<ProductsModel> cart ;
    final private ArrayList<ProductsModel> purchaseHistory;
    final private ArrayList<InvoiceModel> invoiceHistory;
    private double balance ;
    public CustomerModel(String name, String email, String phoneNumber, String password, String fullName){
        super(name,email,phoneNumber,password);
        this.balance=0;
        cart = new ArrayList<>();
        purchaseHistory=new ArrayList<>();
        invoiceHistory = new ArrayList<>();
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

    public void setCart(ArrayList<ProductsModel> cart) {
        this.cart = cart;
    }

    public ArrayList<InvoiceModel> getInvoiceHistory() {
        return invoiceHistory;
    }

    @Override
    public String toString(){
        return "User name:"+getUserName()+"  --  Full name:"+getFullName()+"  --  Email:"+getEmail()+"  --  Balance:"+getBalance();
    }
}
