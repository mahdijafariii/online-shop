package com.example.model.productModel.digitalProduct;
import com.example.model.productModel.CategoryModel;

public class StorageEquipment extends DigitalProducts {
    private double capacity;
    StorageEquipment(String name ,double price ,int countInCapacity ,double averageOfScores  ,CategoryModel type,double weight , String dimensions,double capacity){
        super(name,price,countInCapacity,averageOfScores,type ,weight,dimensions);
        this.capacity=capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString(){
        return super.toString()+" --Capacity:"+capacity;
    }
}
