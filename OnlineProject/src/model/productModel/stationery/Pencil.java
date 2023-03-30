package model.productModel.stationery;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public class Pencil extends StationeryProduct{
    private enum typeOfPencil {
        HB,B,F,H,H2;
    }
    typeOfPencil type;
    Pencil(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type,String creatorCountry,String colorOfPen,typeOfPencil typeOfPenceil){
        super(productID,name,price,inventoryStatus,averageOfScores,type,creatorCountry);
        this.type=typeOfPenceil;
    }
}
