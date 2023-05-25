package model.productModel.vehicle;

import model.productModel.CategoryModel;

public class Vehicle extends VehiclesProduct{
    private boolean automatic;
    private int engineVolume;
    public Vehicle(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, String nameOfCreator, boolean automatic, int engineVolume){
        super(name,price,countInCapacity,averageOfScores,type,nameOfCreator);
        this.engineVolume=engineVolume;
        this.automatic=automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    @Override
    public String toString(){
        return super.toString()+" --Automatic:"+automatic+" --Engine Volume:"+engineVolume;
    }

}
