package model.productModel.stationery;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public class Pen extends StationeryProduct{
    private String colorOfPen;
    Pen(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type,String creatorCountry,String colorOfPen){
        super(productID,name,price,inventoryStatus,averageOfScores,type,creatorCountry);
        this.colorOfPen=colorOfPen;
    }



}
