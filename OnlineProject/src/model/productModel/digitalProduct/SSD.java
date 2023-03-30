package model.productModel.digitalProduct;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;
public class SSD extends StorageEquipment{
    private int readingSpeed;
    private int writingSpeed;
    SSD(String productID,String name ,double price ,boolean inventoryStatus ,double averageOfScores  ,CategoryModel type,double weight , String dimensions,double capacity,int readingSpeed,int writingSpeed){
        super(productID,name,price,inventoryStatus,averageOfScores,type ,weight,dimensions,capacity);
        this.readingSpeed=readingSpeed;
        this.writingSpeed=writingSpeed;
    }
}
