package model.productModel.digitalProduct;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;

public abstract class DigitalProducts extends ProductsModel {
    private double weight;
    private String dimensions;
    DigitalProducts(String productID,String name ,double price ,boolean inventoryStatus ,double averageOfScores  ,CategoryModel type,double weight,String dimensions){
        super(productID,name,price,inventoryStatus,averageOfScores,type);
        this.weight=weight;
        this.dimensions=dimensions;
    }
}
