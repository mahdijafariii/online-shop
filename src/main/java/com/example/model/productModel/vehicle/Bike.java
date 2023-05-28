package com.example.model.productModel.vehicle;

import com.example.model.productModel.CategoryModel;

public class Bike extends VehiclesProduct{

    public enum typeOfBike{
        MOUNTAIN_TYPE,ROAD_TYPE,HYBRID_TYPE,CITY_TYPE;

    }
    private typeOfBike type;

    public Bike(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, String nameOfCreator, typeOfBike typeOfBike){
        super(name,price,countInCapacity,averageOfScores,type,nameOfCreator);
        this.type=typeOfBike;
    }

    public void setType(typeOfBike type) {
        this.type = type;
    }

    public String getType() {
        return type.name();
    }

    @Override
    public String toString(){
        return super.toString()+"\nType of bike: "+type;
    }

}
