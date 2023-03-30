package model.accountModel;

import model.productModel.ProductsModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceModel {
    private static int invoceID=0;
    private Date date ;
    private SimpleDateFormat format=new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzzz") ;
    private double totalPrice;
    private ArrayList<ProductsModel> listOfShoppingItem;
    InvoiceModel(double totalPrice){
        this.totalPrice=totalPrice;
    }
    public String time(Date date,SimpleDateFormat format){
        date = new Date();
        return format.format(date);
    }




}
