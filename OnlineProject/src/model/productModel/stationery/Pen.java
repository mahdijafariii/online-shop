package model.productModel.stationery;
import model.productModel.CategoryModel;
import model.productModel.ProductsModel;

public class Pen extends StationeryProduct{
    private String colorOfPen;
    public Pen( String name , double price , int countInCapacity , double averageOfScores  , CategoryModel type,String creatorCountry,String colorOfPen){
        super(name,price,countInCapacity,averageOfScores,type,creatorCountry);
        this.colorOfPen=colorOfPen;
    }

    public void setColorOfPen(String colorOfPen) {
        this.colorOfPen = colorOfPen;
    }

    public String getColorOfPen() {
        return colorOfPen;
    }

    @Override
    public String toString(){
        return super.toString()+" -- Color:"+colorOfPen;
    }



}
