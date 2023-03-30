package model.productModel.digitalProduct;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;
public class PersonalComputer extends DigitalProducts{
    String modelOfCPU;
    int RAM;
    PersonalComputer(String productID,String name ,double price ,boolean inventoryStatus ,double averageOfScores  ,CategoryModel type,double weight , String dimensions,String modelOfCPU,int RAM){
        super(productID,name,price,inventoryStatus,averageOfScores,type,weight,dimensions);
        this.modelOfCPU=modelOfCPU;
        this.RAM=RAM;
    }


}
