package com.example.model.productModel.stationery;
import com.example.model.accountModel.AdminModel;
import com.example.model.productModel.CategoryModel;
import com.example.model.productModel.discount;

public class Pen extends StationeryProduct implements discount {
    private String colorOfPen;
    private double amountDiscount ;
    public Pen( String name , double price , int countInCapacity , double averageOfScores  , CategoryModel type,String creatorCountry,String colorOfPen){
        super(name,price,countInCapacity,averageOfScores,type,creatorCountry);
        this.colorOfPen=colorOfPen;
    }

    public void setColorOfPen(String colorOfPen) {
        this.colorOfPen = colorOfPen;
    }

    public String getColorOfPen() {
        return colorOfPen;
    }

    @Override
    public String toString(){
        return super.toString()+" -- Color:"+colorOfPen;
    }


    @Override
    public void setDiscount(String name, double amount) {
        for(int i = 0 ; i< AdminModel.getAdmin().getProductsOfStore().size() ; i++ ){
            if(AdminModel.getAdmin().getProductsOfStore().get(i).getProductID().equals(name)){
                amountDiscount =amount;
                AdminModel.getAdmin().getProductsOfStore().get(i).setPrice(AdminModel.getAdmin().getProductsOfStore().get(i).getPrice()*((100-amount)/100));
                break;
            }
        }
    }

    @Override
    public void removeDiscount(String name) {
        for(int i = 0 ; i< AdminModel.getAdmin().getProductsOfStore().size() ; i++ ){
            if(AdminModel.getAdmin().getProductsOfStore().get(i).getProductID().equals(name)){
                AdminModel.getAdmin().getProductsOfStore().get(i).setPrice((AdminModel.getAdmin().getProductsOfStore().get(i).getPrice()*(100))/(100-amountDiscount));
                break;
            }
        }
    }
}
