package com.example.model.productModel.stationery;
import com.example.model.productModel.CategoryModel;

public class NoteBook extends StationeryProduct{
    private int numberOfLeaves;
    private String typeOfLeaves;
    public NoteBook(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, String creatorCountry, int numberOfLeaves, String typeOfLeaves){
        super(name,price,countInCapacity,averageOfScores,type,creatorCountry);
        this.numberOfLeaves=numberOfLeaves;
        this.typeOfLeaves=typeOfLeaves;
    }

    public void setNumberOfLeaves(int numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }

    public void setTypeOfLeaves(String typeOfLeaves) {
        this.typeOfLeaves = typeOfLeaves;
    }

    public int getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public String getTypeOfLeaves() {
        return typeOfLeaves;
    }

    @Override
    public String toString(){
        return super.toString()+" --Number of leaves:"+numberOfLeaves+" --Type of leaves:"+typeOfLeaves;
    }

}
