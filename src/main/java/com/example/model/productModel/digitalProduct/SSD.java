package com.example.model.productModel.digitalProduct;
import com.example.model.productModel.CategoryModel;
public class SSD extends StorageEquipment{
    private int readingSpeed;
    private int writingSpeed;
    public SSD(String name, double price, int countInCapacity, double averageOfScores, CategoryModel type, double weight, String dimensions, double capacity, int readingSpeed, int writingSpeed){
        super(name,price,countInCapacity ,averageOfScores,type ,weight,dimensions,capacity);
        this.readingSpeed=readingSpeed;
        this.writingSpeed=writingSpeed;
    }

    public void setReadingSpeed(int readingSpeed) {
        this.readingSpeed = readingSpeed;
    }

    public void setWritingSpeed(int writingSpeed) {
        this.writingSpeed = writingSpeed;
    }

    public int getReadingSpeed() {
        return readingSpeed;
    }

    public int getWritingSpeed() {
        return writingSpeed;
    }

    @Override
    public String toString(){
        return super.toString()+" --Reading and writing speed:"+readingSpeed+"~~"+writingSpeed;
    }
}
