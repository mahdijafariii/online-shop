package model.productModel.stationery;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public class NoteBook extends StationeryProduct{
    private int numberOfLeaves;
    private String typeOfLeaves;
    NoteBook(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type,String creatorCountry ,int numberOfLeaves,String typeOfLeaves){
        super(productID,name,price,inventoryStatus,averageOfScores,type,creatorCountry);
        this.numberOfLeaves=numberOfLeaves;
        this.typeOfLeaves=typeOfLeaves;
    }

}
