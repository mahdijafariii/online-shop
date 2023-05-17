package model.productModel.digitalProduct;
import model.productModel.ProductsModel;
import model.productModel.CategoryModel;

public abstract class DigitalProducts extends ProductsModel {
    private double weight;
    private String dimensions;
    DigitalProducts(String name ,double price ,int countInCapacity ,double averageOfScores  ,CategoryModel type,double weight,String dimensions){
        super(name,price,countInCapacity,averageOfScores,type);
        this.weight=weight;
        this.dimensions=dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String toString(){
        return super.toString()+" --Weight:"+weight+" --Dimensions:"+dimensions;
    }

}
