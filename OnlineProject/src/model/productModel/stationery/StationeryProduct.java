package model.productModel.stationery;

import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public abstract class StationeryProduct extends ProductsModel {
    private String creatorCountry;
    StationeryProduct(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type , String creatorCountry){
        super(productID,name,price,inventoryStatus,averageOfScores,type);
        this.creatorCountry=creatorCountry;
    }

}
