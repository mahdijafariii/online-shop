package model.accountModel;

import model.productModel.ProductsModel;

import java.util.ArrayList;

public class CustomerModel extends AccountModel{
    private String fullName;
    private ArrayList<ProductsModel> cart ;
    private ArrayList<ProductsModel> purchaseHistory;
    private ArrayList<InvoiceModel> invoiceHistory;
    private ArrayList<DiscountCode> discountCodes;
    private double balance ;
    public CustomerModel(String name, String email, String phoneNumber, String password, String fullName){
        super(name,email,phoneNumber,password);
        this.balance=0;
        cart = new ArrayList<>();
        purchaseHistory=new ArrayList<>();
        invoiceHistory = new ArrayList<>();
        discountCodes = new ArrayList<>();
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

    public ArrayList<DiscountCode> getDiscountCodes() {
        return discountCodes;
    }

    @Override
    public String toString(){
        return "User name:"+getUserName()+"  --  Full name:"+getFullName()+"  --  Email:"+getEmail()+"  --  Balance:"+getBalance();
    }
}
