package model.productModel.foods;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;

public class Food extends ProductsModel{
    private int dateOfProduction;
    private int dateOfExpiration;
    Food(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type,int dateOfProduction,int dateOfExpiration){
        super(productID,name,price,inventoryStatus,averageOfScores,type);
        this.dateOfExpiration=dateOfExpiration;
        this.dateOfProduction=dateOfProduction;
    }


}
