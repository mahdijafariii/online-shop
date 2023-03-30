package model.productModel.vehicle;

import model.productModel.CategoryModel;

public class Bike extends VehiclesProduct{

    enum typeOfBike{
        MOUNTAIN_TYPE,ROAD_TYPE,HYBRID_TYPE,CITY_TYPE;

    }
    private typeOfBike type;

    Bike(String productID, String name , double price , boolean inventoryStatus , double averageOfScores  , CategoryModel type, String nameOfCreator,typeOfBike typeOfBike){
        super(productID,name,price,inventoryStatus,averageOfScores,type,nameOfCreator);
        this.type=typeOfBike;
    }

}
