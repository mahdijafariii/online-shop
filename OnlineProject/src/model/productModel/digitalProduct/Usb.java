package model.productModel.digitalProduct;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;

public class Usb extends StorageEquipment{
    private int usbVersion;
    Usb(String productID,String name ,double price ,boolean inventoryStatus ,double averageOfScores  ,CategoryModel type,double weight , String dimensions,double capacity,int usbVersion){
        super(productID,name,price,inventoryStatus,averageOfScores,type ,weight,dimensions,capacity);
        this.usbVersion=usbVersion;
    }

}
