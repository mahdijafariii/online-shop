package model.productModel.digitalProduct;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;

public class StorageEquipment extends DigitalProducts {
    private double capacity;
    StorageEquipment(String productID,String name ,double price ,boolean inventoryStatus ,double averageOfScores  ,CategoryModel type,double weight , String dimensions,double capacity){
        super(productID,name,price,inventoryStatus,averageOfScores,type ,weight,dimensions);
        this.capacity=capacity;
    }
}
