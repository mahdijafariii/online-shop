package controller;

import model.accountModel.CustomerModel;
import model.accountModel.InvoiceModel;
import model.productModel.ProductsModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceController {
    public double calculateInvoice(InvoiceModel invoice){
        ArrayList<ProductsModel> test ;
        test =invoice.getListOfShoppingItem();
        double price=0;
        for(int i=0;i<test.size();i++){
            test.get(i).getPrice();
            price=test.get(i).getPrice()+price;
        }
    return price;}
    public int deductFromBalance(InvoiceModel invoiceModel, CustomerModel customerModel) {
        double newBalance;
        if (customerModel.getBalance() > invoiceModel.getTotalPrice()) {
            newBalance = customerModel.getBalance() - invoiceModel.getTotalPrice();
            customerModel.setBalance(newBalance);
            return 1;
        } else {
            return -1;
        }
    }








}
