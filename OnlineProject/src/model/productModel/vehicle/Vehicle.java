package model.productModel.vehicle;

import model.productModel.CategoryModel;

public class Vehicle extends VehiclesProduct{
    private boolean automatic;
    public int engineVolume;
    Vehicle(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type,String nameOfCreator,boolean automatic,int engineVolume){
        super(productID,name,price,inventoryStatus,averageOfScores,type,nameOfCreator);
        this.engineVolume=engineVolume;
        this.automatic=automatic;
    }

}
