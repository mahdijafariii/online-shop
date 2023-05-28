package com.example.model.productModel.digitalProduct;
import com.example.model.productModel.CategoryModel;
public class PersonalComputer extends DigitalProducts{
    private String modelOfCPU;
    private int RAM;
    public PersonalComputer(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, double weight, String dimensions, String modelOfCPU, int RAM){
        super(name,price,countInCapacity,averageOfScores,type,weight,dimensions);
        this.modelOfCPU=modelOfCPU;
        this.RAM=RAM;
    }

    public void setModelOfCPU(String modelOfCPU) {
        this.modelOfCPU = modelOfCPU;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getRAM() {
        return RAM;
    }

    public String getModelOfCPU() {
        return modelOfCPU;
    }

    @Override
    public String toString(){
        return super.toString()+"\nCPU:"+modelOfCPU+" --RAM:"+RAM;
    }


}
