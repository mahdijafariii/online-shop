package model.accountModel;

import model.productModel.ProductsModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceModel {
    private static int invoiceID=0;
    private final int idInvoice;
    private final Date date ;
    private final String timeInvoice;
    private double totalPrice;
    private ArrayList<ProductsModel> listOfShoppingItem;
    public InvoiceModel(ArrayList<ProductsModel> products){
        listOfShoppingItem = products;
        invoiceID++;
        idInvoice=invoiceID;
        date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzzz");
        this.timeInvoice= format.format(date);
    }


    public ArrayList<ProductsModel> getListOfShoppingItem() {
        return listOfShoppingItem;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){
        StringBuilder test =new StringBuilder();
        test.append("---------------------------------------------------------------------------------\n");
        test.append("Time:"+timeInvoice+"                                                    Invoice ID:"+idInvoice+"\n");
        int countNumberInList=1;
        for(int i=0 ; i<listOfShoppingItem.size();i++){
            String id =listOfShoppingItem.get(i).getProductID();
            for(int j=0;j<listOfShoppingItem.size();j++){
                if(j==i){
                }
                else{
                    if(listOfShoppingItem.get(j).getProductID().equals(id)){
                        countNumberInList++;
                    }

                }

            }
            test.append("Name:"+listOfShoppingItem.get(i).getName()+"     ---    ID:"+listOfShoppingItem.get(i).getProductID()+"    ---    price:"+listOfShoppingItem.get(i).getPrice()+"    ---    number:"+countNumberInList+"\n");
            countNumberInList=1;
        }
        test.append("-------------------------------------------------------------------------------------\n");
        test.append("Total price:"+totalPrice);
    return test.toString();}
}
