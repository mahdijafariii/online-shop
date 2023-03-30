package model.productModel.vehicle;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public abstract class VehiclesProduct extends ProductsModel{
    private String nameOfCreator;
    VehiclesProduct(String name , double price , int countInCapacity , double averageOfScores  , CategoryModel type, String nameOfCreator){
        super(name,price,countInCapacity,averageOfScores,type);
        this.nameOfCreator=nameOfCreator;
    }

    public void setNameOfCreator(String nameOfCreator) {
        this.nameOfCreator = nameOfCreator;
    }

    public String getNameOfCreator() {
        return nameOfCreator;
    }

    @Override
    public String toString(){
        return super.toString()+" --name of developer country:"+nameOfCreator;
    }

}
