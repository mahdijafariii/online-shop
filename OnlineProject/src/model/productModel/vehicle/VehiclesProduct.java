package model.productModel.vehicle;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public abstract class VehiclesProduct extends ProductsModel{
    private String nameOfCreator;
    VehiclesProduct(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type, String nameOfCreator){
        super(productID,name,price,inventoryStatus,averageOfScores,type);
        this.nameOfCreator=nameOfCreator;
    }

}
